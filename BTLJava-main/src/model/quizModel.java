package model;

import java.util.ArrayList;
import java.util.Arrays;

import dao.modelDAO;
import view.quizView;

public class quizModel {
	public String[] questions = {};
	public String[][] options = {};
	public String[] answers = {};
	private String[] testQuestion = {};
	private int index;
	private String results;
	private int correct_guesses = 0;
	private String question1;
	private String answer1;
	
	public String[] getTestQuestion() {
		return testQuestion;
	}
	
	public void setTestQuestion(String[] testQuestion) {
		this.testQuestion = testQuestion;
	}

	public quizModel() {
		
	}
	
	public quizModel(String[] questions, String[][] options, String[] answers, int index) {
//		super();
		this.questions = questions;
		this.options = options;
		this.answers = answers;
		this.index = index;
	}


	public quizModel(String results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return  question1 + ", answer1=" + answer1;
	}

	public void setResults(String results) {
		this.results = results;
	}
	
	public int getCorrect_guesses() {
		return correct_guesses;
	}
	public void setCorrect_guesses(int correct_guesses) {
		this.correct_guesses = correct_guesses;
	}
	
	public String[][] getOptions() {
		return options;
	}
	public void setOptions(String[][] options) {
		this.options = options;
	}
	
	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
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
	
	public void increaseCorrect() {
		correct_guesses++;
	}
	
	
}
