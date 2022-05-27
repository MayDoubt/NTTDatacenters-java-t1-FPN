package nttdata.javat1.game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Maydo - SoundEffects Class
 *
 * Class that manages all sounds in the game
 *
 */
public class SoundEffects {

	/** Input sound file */
	public static final String SFX_INPUT = "\\src\\main\\sfx\\Drunken Sailor (Sea Shanty) [8 Bit Tribute to Irish Rovers].wav";
	static String musicPath = new File("").getAbsolutePath().concat(SFX_INPUT);
	static File audioFile = new File(musicPath);
	static Clip clip;
	
	/**
	 * Empty constructor to let you know that it's not an instantiable class
	 */
	private SoundEffects() {
		
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Method that initialize the ost file
	 */
	public static void initializeOst() {
		
		try {
			if(audioFile.exists()) {
				
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
			} else {
				System.out.println("Can't find the file.");
			}
			
		} catch (Exception ex ) {
			ex.printStackTrace();
		}	
	}
	
	/**
	 * Method that play the ost
	 */
	public static void playSound() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Method that stop the ost
	 */
	public static void stopSound() {
		clip.stop();
	}
}
