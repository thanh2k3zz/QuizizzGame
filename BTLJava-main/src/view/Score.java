package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ScoreController;
import controller.quizController;
import model.quizModel;

public class Score extends JFrame{
	
	private JPanel contentPane;
	private JLabel scoreLabel;
	private quizModel qm;
	private quizController qc;
	private JLabel lblNewLabel;
	private HomePage hp;
	

	public Score(String results) {
		
		
		ImageIcon imageIcon = new ImageIcon("logoQuiz.png");
		Image i = imageIcon.getImage();
		Image new_img = i.getScaledInstance(400, 91, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(new_img);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1142, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_ = new JPanel();
		contentPane.add(panel_);
		panel_.setBackground(new Color(76, 26, 66));
		panel_.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(76, 26, 66));
		panel_.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel jlabel_3 = new JLabel("");
		jlabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_3.setIcon(imageIcon);
		panel_1.add(jlabel_3, BorderLayout.SOUTH);
		
		JLabel jlabel_4 = new JLabel("");
		panel_1.add(jlabel_4, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(76, 26, 66));
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel jlabel_2 = new JLabel("Your score");
		panel_2.add(jlabel_2, BorderLayout.NORTH);
		jlabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_2.setFont(new Font("Gabriola", Font.BOLD, 65));
		jlabel_2.setForeground(new Color(255, 255, 255));
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setText(results);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, BorderLayout.CENTER);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(76, 26, 66));
		contentPane.add(panel_3);
		
		ActionListener rs = new ScoreController(this, hp);
		JButton jbutton = new JButton("Reset");
		jbutton.addActionListener(rs);
		jbutton.setFont(new Font("Sitka Text", Font.BOLD, 35));
		jbutton.setFocusable(false);
		jbutton.setBackground(new Color(0,201,133));
		jbutton.setBackground(new Color(255, 255, 255));
		panel_3.add(jbutton);
		
		
		this.add(panel_3);
		this.setTitle("Quiz Game");
		ImageIcon logo = new ImageIcon("logo.jpg");
		setIconImage(logo.getImage());
		this.setSize(1000, 570);
		this.setLocation(250, 150);
		
		this.setVisible(true);
	}
	
	public Score(quizModel qm, quizController qc, HomePage hp){
	this.qm = qm;
	this.qc = qc;
	this.hp = hp;
}
	public void setTextScore(String yourScore) {
		this.scoreLabel.setText(yourScore);
	}
	
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	
	
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
}



