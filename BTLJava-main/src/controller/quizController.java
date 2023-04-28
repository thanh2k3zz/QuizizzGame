package controller;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.Timer;

import model.quizModel;
import view.HomePage;
import view.Score;
import view.quizView;

public class quizController implements ActionListener {
	private quizView qv;
	private quizModel qm;
	private HomePage home;
	private Score score;
	
	public quizController() {
	}
	
	public quizController(quizView quizView, quizModel qm, Score score) {
		this.qv = quizView;
		this.qm = qm;
		this.score = score;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setEnableButton(false);
		String sc = e.getActionCommand();
		if (sc.equals(this.qv.getAnswersView()[this.qv.getIndex()])) {
			this.qv.increaseCorrect();
		}
		
		displayAnswer(sc);
	}
	
	public void nextQuestion() {

			this.qv.nextQuestion();
	}
	public void setEnableButton(Boolean bool) {
		this.qv.setEnableButtonA(bool);
		this.qv.setEnableButtonB(bool);
		this.qv.setEnableButtonC(bool);
		this.qv.setEnableButtonD(bool);
	}

	public void displayAnswer(String sc) {

		try {
			this.qv.displayAnswer(sc);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}

}
