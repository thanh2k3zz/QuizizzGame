package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import dao.modelDAO;
import model.MusicModel;
import model.quizModel;
import view.HomePage;
import view.quizView;

public class HomePageController implements ActionListener {
	private HomePage hp;
	private quizController qc;
	private quizModel qm;
	private modelDAO md;
	private quizView qv;
	

	public HomePageController(HomePage hp, quizController qc, quizModel qm, modelDAO md, quizView qv)  {
		this.qv = qv;
		this.hp = hp;
		this.qc = qc;
		this.qm = qm;
		this.md = md;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sc = e.getActionCommand();
		System.out.println("Nhan" + sc);
		if ( sc == "Easy") {
			hp.dispose();
			new quizView("Easy", 1, 1);
		}else if ( sc == "Medium") {
			hp.dispose();
			new quizView("Medium", 2, 2);
		}else if ( sc == "Difficult") {
			hp.dispose();
			new quizView("Difficult", 3, 3);
		}
		}
	
	
	
	public void HomeMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Nhac nen
		Scanner scanner = new Scanner(System.in);
		File file = new File("MusicGame (1).wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		String reponse = "";
		
		clip.start();
		
		reponse = scanner.next();
	}
	}


