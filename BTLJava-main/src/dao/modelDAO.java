package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import controller.HomePageController;
import database.JDBCUtil;
import model.quizModel;
import view.quizView;

public class modelDAO implements DAOInterface{

	String questions[] = {};
	String answers[] = {};
	String options[][] = new String[5][4];
	private int index = 0;


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void increaseIndex() {
		index++;
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

	public static modelDAO getInstance() {
		return new modelDAO();
	}
	
	@Override
	public ArrayList selectAllEasy() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			ResultSet rs = st.executeQuery("SELECT question_easy.question, question_easy.answer, question_easy.A, question_easy.B, question_easy.C, question_easy.D\r\n"
					+ "			FROM level\r\n"
					+ "					INNER JOIN quiz ON level.level_question = quiz.level_question\r\n"
					+ "				INNER JOIN question_easy ON level.id_easy = question_easy.id_easy\r\n"
					+ "				WHERE quiz.level_question = 'easy'");
			
			// Bước 4:
			while(rs.next()) {
				
				questions = Arrays.copyOf(questions, questions.length + 1);
				questions[questions.length - 1] = rs.getString("question");
				
				answers = Arrays.copyOf(answers, answers.length + 1);
				answers[answers.length - 1] = rs.getString("answer");
				
				options[this.index][0] = rs.getString("A");
				options[this.index][1] = rs.getString("B");
				options[this.index][2] = rs.getString("C");
				options[this.index][3] = rs.getString("D");
				increaseIndex();
				
			}
			quizView quiz;
			try {
				quiz = new quizView(this.questions, this.answers, this.options);
				ketQua.add(quiz);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	

	@Override
	public ArrayList selectAllMedium() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			
//			System.out.println(sql);
			ResultSet rs = st.executeQuery("SELECT question_medium.question, question_medium.answer, question_medium.A, question_medium.B, question_medium.C, question_medium.D\r\n"
					+ "			FROM level\r\n"
					+ "					INNER JOIN quiz ON level.level_question = quiz.level_question\r\n"
					+ "				INNER JOIN question_medium ON level.id_medium = question_medium.id_medium\r\n"
					+ "				WHERE quiz.level_question = 'medium'");
			
			// Bước 4:
			while(rs.next()) {
				
//				System.out.println(question);
				
				questions = Arrays.copyOf(questions, questions.length + 1);
				questions[questions.length - 1] = rs.getString("question");
				answers = Arrays.copyOf(answers, answers.length + 1);
				answers[answers.length - 1] = rs.getString("answer");
				
//				for (int i = 0; i < 2; i++) {
//				    options[i][0] = rs.getString("A");
//				    options[i][1] = rs.getString("B");
//				    options[i][2] = rs.getString("C");
//				    options[i][3] = rs.getString("D");
//				}
//				options = Arrays.copyOf(options[5][0], options[options[0].length + 1]);
				options[this.index][0] = rs.getString("A");
				options[this.index][1] = rs.getString("B");
				options[this.index][2] = rs.getString("C");
				options[this.index][3] = rs.getString("D");
				increaseIndex();
			}
			quizView quiz;
			try {
				quiz = new quizView(this.questions, this.answers, this.options);
				ketQua.add(quiz);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList selectAllDifficult() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			
//			System.out.println(sql);
			ResultSet rs = st.executeQuery("SELECT question_difficult.question, question_difficult.answer, question_difficult.A, question_difficult.B, question_difficult.C, question_difficult.D\r\n"
					+ "				FROM level\r\n"
					+ "						INNER JOIN quiz ON level.level_question = quiz.level_question\r\n"
					+ "						INNER JOIN question_difficult ON level.id_difficult = question_difficult.id_difficult\r\n"
					+ "			WHERE quiz.level_question = 'difficult'");
			
			// Bước 4:
			while(rs.next()) {
				
				questions = Arrays.copyOf(questions, questions.length + 1);
				questions[questions.length - 1] = rs.getString("question");
				
				answers = Arrays.copyOf(answers, answers.length + 1);
				answers[answers.length - 1] = rs.getString("answer");
			
				options[this.index][0] = rs.getString("A");
				options[this.index][1] = rs.getString("B");
				options[this.index][2] = rs.getString("C");
				options[this.index][3] = rs.getString("D");
				increaseIndex();
				
			}
			quizView quiz;
			try {
				quiz = new quizView(this.questions, this.answers, this.options);
				ketQua.add(quiz);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				
				e.printStackTrace();
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
