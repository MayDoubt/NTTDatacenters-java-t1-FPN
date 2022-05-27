package nttdata.javat1;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.javat1.game.Game;

/**
 * @author Fernando Pérez - Launcher Pinball
 * 
 * Pinball launcher
 *
 */
public class Launcher {

	/** Logger */
	static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {
		Game.launchAndStart();
	}
	

}
