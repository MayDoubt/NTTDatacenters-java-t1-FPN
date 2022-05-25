package nttdata.javat1.game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import nttdata.javat1.Launcher;

public class SoundEffects {

	static File musicPath = new File(Launcher.SFX_INPUT);
	static Clip clip;
	
	private SoundEffects() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void initializeOst() {
		try {
			if(musicPath.exists()) {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			} else {
				System.out.println("Can't find the file.");
			}
		} catch (Exception ex ) {
			ex.printStackTrace();
		}	
	}
	
	public static void playSound() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void stopSound() {
		clip.stop();
	}
}
