
package view;

import java.awt.*;


import java.awt.event.ActionEvent;
//import org.jdesktop.swingx.JXButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.*;
import javax.swing.*;

import controller.quizController;
import model.MusicModel;
import model.quizModel;
import dao.modelDAO;

public class quizView extends JFrame{
	public String[] questionsView = {};
	public String[][] optionsView = {};
	public String[] answersView = {};
	private int correct_guesses = 0;
	private int seconds = 10;
	private int index = 0;
	
	private quizModel qm ;
	private quizController qc;
	private Score score;
	
	private JLabel timeLabel;
	private JPanel questionPanel;
	private JPanel buttonPanel; 
	public JLabel questionLabel;
	public JPanel timerPanel;
	private JLabel numberLabel;
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	
	
	public int getCorrect_guesses() {
		return correct_guesses;
	}

	public void setCorrect_guesses(int correct_guesses) {
		this.correct_guesses = correct_guesses;
	}
	
	public void increaseCorrect() {
		correct_guesses++;
	}

	public String[] getQuestionsView() {
		return questionsView;
	}

	public void setQuestionsView(String[] questionsView) {
		this.questionsView = questionsView;
	}

	public String[][] getOptionsView() {
		return optionsView;
	}

	public void setOptionsView(String[][] optionsView) {
		this.optionsView = optionsView;
	}

	public String[] getAnswersView() {
		return answersView;
	}

	public void setAnswersView(String[] answersView) {
		this.answersView = answersView;
	}

    
   
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void increaseIndex() {
		index++;
	}

	public quizView(String button, int index, int temp) {
		
		if(button == "Easy" && index == 1) {
			ArrayList<quizModel> listEasy = modelDAO.getInstance().selectAllEasy();
		}
		
		if(button == "Medium" && index == 2) {
			ArrayList<quizModel> listMedium = modelDAO.getInstance().selectAllMedium();
		}
		
		if(button == "Difficult" && index == 3) {
			ArrayList<quizModel> listDifficult = modelDAO.getInstance().selectAllDifficult();
		}
	}
    

	
	public quizView(String question1[], String answer1[], String[][] options) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

		this.setQuestionsView(question1);
		this.setAnswersView(answer1);
		this.setOptionsView(options);
		
		
//		Thanh thoi gian
		timerPanel = new JPanel(new BorderLayout());
		timeLabel = new JLabel("00:10", SwingConstants.CENTER);
        timeLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 24));
        timeLabel.setForeground(Color.white);
        timeLabel.setPreferredSize(new Dimension(this.getWidth(), 50));
        timeLabel.setBackground(new Color(70, 26, 66));
        timeLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        timeLabel.setOpaque(true);
        timerPanel.add(timeLabel);
        
        
        
		
//      Khung cau hoi
        questionPanel = new JPanel();
        questionPanel.setPreferredSize(new Dimension(this.getWidth(), 200));
        questionPanel.setBackground(new Color(70, 26, 66));
        questionLabel = new JLabel();
        questionLabel.setForeground(new Color(255, 255, 255));
        questionLabel.setFont(new Font("Gabriola",  Font.BOLD, 46));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        questionPanel.add(questionLabel);
        
        // Tạo panel nút
        buttonPanel = new JPanel(new GridLayout(2, 2, 30, 30));
        buttonPanel.setPreferredSize(new Dimension(this.getWidth(), 300));
        buttonPanel.setBackground(new Color(70, 26, 66));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ActionListener ac = new quizController(this, qm, score);
        
        
        button1 = new JButton("A");
        button1.addActionListener(ac);
        button1.setLayout(new BorderLayout());
        button1.setBackground(new Color(255, 118, 117));
        button1.setFont(new Font("Gabriola" , Font.BOLD, 30));
        button1.setForeground(Color.white);
        label1 = new JLabel();
        label1.setFont(new Font("Gabriola",  Font.BOLD, 30));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(Color.white);
        button1.add(label1, BorderLayout.SOUTH);
        button1.setFocusable(false);
        buttonPanel.add(button1);

        button2 = new JButton("B");
        button2.addActionListener(ac);
        button2.setLayout(new BorderLayout());
        button2.setFont(new Font("Gabriola" , Font.BOLD, 30));
        button2.setForeground(Color.white);
        button2.setBackground(new Color(255, 159, 67));
        label2 = new JLabel();
        label2.setFont(new Font("Gabriola",  Font.BOLD, 30));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(Color.white);
        button2.add(label2, BorderLayout.SOUTH);
        button2.setFocusable(false);
        buttonPanel.add(button2);

        button3 = new JButton("C");
        button3.addActionListener(ac);
        button3.setLayout(new BorderLayout());
        button3.setFont(new Font("Gabriola" , Font.BOLD, 30));
        button3.setBackground(new Color(255, 205, 86));
        button3.setForeground(Color.white);
        label3 = new JLabel();
        label3.setFont(new Font( "Gabriola",  Font.BOLD, 30));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setForeground(Color.white);
        button3.add(label3, BorderLayout.SOUTH);
        button3.setFocusable(false);
        buttonPanel.add(button3);

        button4 = new JButton("D");
        button4.addActionListener(ac);
        button4.setLayout(new BorderLayout());
        button4.setFont(new Font("Gabriola" , Font.BOLD, 30));
        button4.setBackground(new Color(75, 192, 192));
        button4.setForeground(Color.white);
        label4 = new JLabel();
        label4.setFont(new Font("Gabriola",  Font.BOLD, 30));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setForeground(Color.white);
        button4.add(label4, BorderLayout.SOUTH);
        button4.setFocusable(false);
        buttonPanel.add(button4);
		
		
		
		
		this.setTitle("Quiz Game");
		this.getContentPane().setBackground(new Color(78, 10, 75));
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(questionPanel, BorderLayout.CENTER);
		this.add(timerPanel, BorderLayout.NORTH);
		this.setSize(1000, 570);
		this.setLocation(250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		ImageIcon logo = new ImageIcon("logo.jpg");
		setIconImage(logo.getImage());
		this.setVisible(true);
		
		nextQuestion();
	}
	

	
	public void setTimerLabel() {
		timeLabel.setText("00:0"+String.valueOf(seconds));
	}
	
	Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				seconds--;
				setTimerLabel();
				if(seconds <=0) {
					try {
						displayAnswer("");
					} catch (UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
	
	public String results() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String formattedNumber = decimalFormat.format((double)(this.getCorrect_guesses()/(double)this.getQuestionsView().length)*100);
		return formattedNumber;
	}
	
	public void nextQuestion() {
			if(this.getIndex() >= this.getQuestionsView().length) {
				this.dispose();
				new Score(this.results());
			}else {
				questionLabel.setText("Question " + (this.getIndex() + 1) + ": " + this.getQuestionsView()[this.getIndex()]);
				label1.setText(this.getOptionsView()[this.getIndex() ][0]);
				label2.setText(this.getOptionsView()[this.getIndex() ][1]);
				label3.setText(this.getOptionsView()[this.getIndex() ][2]);
				label4.setText(this.getOptionsView()[this.getIndex() ][3]);			
				timer.start();
			
			}
	}
	
	
	public void displayAnswer(String sc) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		timer.stop();
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		
		
		if(this.getAnswersView()[this.getIndex()].equals("A")) {
			button1.setBackground(new Color(0, 204, 102));
			
		}else {
			button1.setBackground(new Color(230, 57, 70));
			
		}
		
		if(this.getAnswersView()[this.getIndex()].equals("B")) {
			button2.setBackground(new Color(0, 204, 102));
			
		}else {
			button2.setBackground(new Color(230, 57, 70));
			
		}
		
		if(this.getAnswersView()[this.getIndex()].equals("C")) {
			button3.setBackground(new Color(0, 204, 102));
			
		}else {
			button3.setBackground(new Color(230, 57, 70));
			
		}
		
		if(this.getAnswersView()[this.getIndex()].equals("D")) {
			button4.setBackground(new Color(0, 204, 102));
			
		}else {
			button4.setBackground(new Color(230, 57, 70));
			
		}
		
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				button1.setBackground(new Color(255, 118, 117));
				button2.setBackground(new Color(255, 159, 67));
				button3.setBackground(new Color(255, 205, 86));
				button4.setBackground(new Color(75, 192, 192));
				seconds = 10;
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				increaseIndex();
				nextQuestion();
			}
			
		});
		
		pause.setRepeats(false);
		pause.start();

	}
	
	
	public void indexPlus() {
		this.qm.increaseIndex();
	}
	
	
	public JLabel getQuestionLabel() {
		return questionLabel;
	}


	public void setTimeLabel(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}
	
	public void setTextTime(String second) {
		this.timeLabel.setText("00:0"+second);
	}
	
	public void setEnableButtonA(Boolean bool) {
		this.getButton1().setEnabled(bool);
	}
	
	public void setEnableButtonB(Boolean bool) {
		this.getButton2().setEnabled(bool);		
	}
	
	public void setEnableButtonC(Boolean bool) {
		this.getButton3().setEnabled(bool);		
	}
	
	public void setEnableButtonD(Boolean bool) {
		this.getButton4().setEnabled(bool);		
	}
	

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getLabel2() {
		return label2;
	}
	
	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JLabel getLabel3() {
		return label3;
	}
	
	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

	public JLabel getLabel4() {
		return label4;
	}

	public void setLabel4(JLabel label4) {
		this.label4 = label4;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}

	public JButton getButton4() {
		return button4;
	}

	public void setButton4(JButton button4) {
		this.button4 = button4;
	}
}

