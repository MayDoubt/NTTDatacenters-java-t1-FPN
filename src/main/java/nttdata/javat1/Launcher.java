package nttdata.javat1;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.javat1.game.Game;

/**
 * Launcher Pinball
 *
 */
public class Launcher {

	/** Logger */
	static final Logger LOG = LoggerFactory.getLogger(Launcher.class);
	
	/** Input sound file */
	public static final String SFX_INPUT = "D:\\DATOS\\CESUR\\DEVELOP\\WORKSPACES\\DUAL\\nttdatacenters-java-t1-FPN\\src\\main\\sfx\\Drunken Sailor (Sea Shanty) [8 Bit Tribute to Irish Rovers].wav";

	public static void main(String[] args) {
		Game.launchAndStart();
	}
	

}
