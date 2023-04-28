package dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface DAOInterface {
	public ArrayList selectAllEasy() ;
	public ArrayList selectAllMedium();
	public ArrayList selectAllDifficult();
}
