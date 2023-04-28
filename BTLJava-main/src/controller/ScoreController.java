package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.quizModel;
import view.HomePage;
import view.Score;
import view.quizView;

public class ScoreController implements ActionListener {
	private Score sc;
	private quizModel qm;
	private HomePage hp;

	public ScoreController() {

	}
	
	public ScoreController(Score sc, HomePage hp) {
		this.sc = sc;
		this.hp = hp;
	}

	public void show() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String rs = e.getActionCommand();
		
		if(rs == "Reset") {
			try {
				sc.dispose();
				new HomePage();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
