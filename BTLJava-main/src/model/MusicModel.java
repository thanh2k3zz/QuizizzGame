package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class MusicModel {
	private Clip clip;
	private AudioInputStream audio;
	private File file;
	
	Scanner scanner = new Scanner(System.in);
	
	
	String reponse = "";
	
	
	
	
	
	public MusicModel(String newFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.file = new File(newFile);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		this.clip = AudioSystem.getClip();
		
		this.clip.open(audioStream);
		
	}
	
	
	public void stopMusic() {
		this.clip.stop();
		this.clip.close();
	}
	
	public void startMusic() {
		this.clip.start();
		reponse = scanner.next();
	}
	
	public Clip getClip() {
		return clip;
	}
	public void setClip(Clip clip) {
		this.clip = clip;
	}
	public AudioInputStream getAudio() {
		return audio;
	}
	public void setAudio(AudioInputStream audio) {
		this.audio = audio;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public MusicModel(Clip clip, AudioInputStream audio, File file) {
		this.clip = clip;
		this.audio = audio;
		this.file = file;
	}
	
}
