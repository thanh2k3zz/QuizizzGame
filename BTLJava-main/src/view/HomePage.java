package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.HomePageController;
import controller.quizController;
import dao.modelDAO;
import model.MusicModel;
import model.quizModel;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private quizModel qm;
	private quizView qv;
	private quizController qc;
	private JButton jbutton_1;
	private JButton jbutton_2;
	private JButton jbutton_3;
	private modelDAO md;
	private MusicModel musicModel;
	


	public HomePage() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		
		
//		Giao dien
		
		ImageIcon imageIcon = new ImageIcon("icon.png");
		Image i = imageIcon.getImage();
		Image new_img = i.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(new_img);
		

		ImageIcon imageIcon_2 = new ImageIcon("logohome.png");
		Image i_2 = imageIcon_2.getImage();
		Image new_img_2 = i_2.getScaledInstance(400, 180, Image.SCALE_SMOOTH);
		imageIcon_2 = new ImageIcon(new_img_2);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50, 10, 1405, 783);
		JPanel jpanel = new JPanel();
		jpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		jpanel.setBackground(new Color(70, 26, 66));
		jpanel.setForeground(new Color(255, 255, 255));
		this.setContentPane(jpanel);
		jpanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		jpanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));

		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(70, 26, 66));
		panel_2.setLayout(new BorderLayout(0, 0));

		
		
		JLabel jlabel_1 = new JLabel("");
		jlabel_1.setForeground(new Color(255, 255, 255));
		jlabel_1.setBackground(new Color(70, 26, 66));
		jlabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_1.setFont(new Font("Gabriola", Font.BOLD, 99));
		jlabel_1.setIcon(imageIcon_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(70, 26, 66));
		panel_1.add(panel_2);
		panel_1.add(panel_3);
		panel_2.add(jlabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(76, 26, 66));
		panel_2.add(panel_2_1, BorderLayout.NORTH);
		panel_2_1.setLayout(null);
		
		JLabel jlabel_2 = new JLabel();
		jlabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlabel_2.setBounds(20, 20, 100, 100);
		jlabel_2.setIcon(imageIcon);
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(70, 26, 66));
		panel_3.add(panel_4);
		ActionListener ac = new HomePageController(this, qc, qm, md, qv);
		jbutton_1 = new JButton("Easy");
		jbutton_1.addActionListener(ac);
		jbutton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbutton_1.setBackground(new Color(0, 201, 133));
		jbutton_1.setFont(new Font("Sitka Text", Font.BOLD, 35));
		jbutton_1.setFocusable(false);
		jbutton_1.setBackground(new Color(0,201,133));
		jbutton_1.setForeground(Color.white);
		panel_4.add(jbutton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(70, 26, 66));
		
		panel_3.add(panel_5);
		

		jbutton_2 = new JButton("Medium");
		jbutton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbutton_2.addActionListener(ac);
		jbutton_2.setBackground(new Color(0, 201, 133));
		jbutton_2.setFont(new Font("Sitka Text", Font.BOLD, 35));
		jbutton_2.setFocusable(false);
		jbutton_2.setBackground(new Color(0,201,133));
		jbutton_2.setForeground(Color.white);
		panel_5.add(jbutton_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(70, 26, 66));
		panel_3.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jbutton_3 = new JButton("Difficult");
		jbutton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbutton_3.addActionListener(ac);
		jbutton_3.setBackground(new Color(0, 201, 133));
		jbutton_3.setFont(new Font("Sitka Text", Font.BOLD, 35));
		jbutton_3.setFocusable(false);
		jbutton_3.setBackground(new Color(0,201,133));
		jbutton_3.setForeground(Color.white);
		panel_6.add(jbutton_3);
		jlabel_1.add(jlabel_2);
		
		JLabel jlabel_3 = new JLabel("Selection of levels");
		jlabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		jlabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_3.setFont(new Font("Gabriola", Font.BOLD, 70));
		jlabel_3.setForeground(new Color(255, 255, 255));
		panel_2.add(jlabel_3, BorderLayout.SOUTH);
		
		
		
		
		this.setTitle("Quiz Game");
		this.setSize(1000, 570);
		this.setLocation(250, 150);
		ImageIcon logo = new ImageIcon("logo.jpg");
		this.setIconImage(logo.getImage());
		this.setVisible(true);
		
	}
	
	
	public MusicModel getMusicModel() {
		return musicModel;
	}
	
	public void setMusicModel(MusicModel musicModel) {
		this.musicModel = musicModel;
	}
	
	public void stopMusicHome() {
		this.musicModel.stopMusic();
	}
	
	public JButton getJbutton_1() {
		return jbutton_1;
	}

	public void setJbutton_1(JButton jbutton_1) {
		this.jbutton_1 = jbutton_1;
	}

	public JButton getJbutton_2() {
		return jbutton_2;
	}

	public void setJbutton_2(JButton jbutton_2) {
		this.jbutton_2 = jbutton_2;
	}

	public JButton getJbutton_3() {
		return jbutton_3;
	}

	public void setJbutton_3(JButton jbutton_3) {
		this.jbutton_3 = jbutton_3;
	}

	
}