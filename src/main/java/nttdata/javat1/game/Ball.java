package nttdata.javat1.game;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Maydo  - Class ball
 * 
 * Controls the interactions of the ball
 *
 */
public class Ball {
	

	private static boolean isFallOff;
	private static boolean isBonus;
	Random r = new Random();
	

	
	/**
	 * This class only has states as attributes, so its constructor is empty.
	 */
	public Ball() {

	};
	
	/**
	 * @return isFallOff  Returns true if you have lost the attempt because the ball has been dropped
	 */
	public boolean isFallOff() {
		return isFallOff;
	} 
	
	/**
	 * @return isBonus  Returns true if you are in bonus, that means you have managed to hit the ball in 5 holes without it falling out
	 */
	public boolean isBonus() {
		return isBonus;
	}
	
	/**
	 * @param isBonus
	 */
	public static void setBonus(boolean isBonus) {
		Ball.isBonus = isBonus;
	}
	
	/**
	 * Method for the behavior of the ball when it hits a pinball clicker
	 */
	public void bounce() {
		int soundListLength = InterfaceConstants.BOUNCE_SOUNDS.length;
		System.out.println();
		int rand = r.nextInt(3);
		switch(rand) {
			case 1:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.left(UserInterface.multiplyText(UserInterface.blankMultiplier, InterfaceConstants.MARGIN).concat(InterfaceConstants.BOUNCE_SOUNDS[rand]), UserInterface.consoleWidth));
				break;	
			case 2:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center(InterfaceConstants.BOUNCE_SOUNDS[rand], UserInterface.consoleWidth));
				break;	
			default:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.right(InterfaceConstants.BOUNCE_SOUNDS[rand].concat(UserInterface.multiplyText(UserInterface.blankMultiplier, InterfaceConstants.MARGIN)), UserInterface.consoleWidth));
				break;	
				
		}
	}

	/**
	 * Method for the behavior of the ball when it falls into a hole
	 */
	public void hole() {
		int holeListLength = InterfaceConstants.HOLE_MSG.length;
		int soundListLength = InterfaceConstants.HOLE_SOUNDS.length;
		int rand = r.nextInt(holeListLength);
		
		System.out.println();
		UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, (StringUtils.center(InterfaceConstants.HOLE_MSG[rand], UserInterface.consoleWidth)));
		
		rand = r.nextInt(3);
		switch(rand) {
			case 1:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.left(UserInterface.multiplyText(UserInterface.blankMultiplier, InterfaceConstants.MARGIN).concat(InterfaceConstants.HOLE_SOUNDS[rand]), UserInterface.consoleWidth));
				break;
			case 2:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center(InterfaceConstants.HOLE_SOUNDS[rand], UserInterface.consoleWidth));
				break;
			default:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.right(InterfaceConstants.HOLE_SOUNDS[rand].concat(UserInterface.multiplyText(UserInterface.blankMultiplier, InterfaceConstants.MARGIN)), UserInterface.consoleWidth));
				break;
		}
	}
	
	/**
	 * Method for the behavior of the ball when it reach the ramp
	 */
	public void ramp() {
		int soundListLength = InterfaceConstants.RAMP_SOUNDS.length;
		
		System.out.println();
		UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, (StringUtils.center(InterfaceConstants.RAMP_MSG, UserInterface.consoleWidth)));
		
		int rand = r.nextInt(3);
		switch(rand) {
		case 1:
			rand = r.nextInt(soundListLength);
			UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.left(UserInterface.multiplyText(UserInterface.blankMultiplier, InterfaceConstants.MARGIN).concat(InterfaceConstants.RAMP_SOUNDS[rand]), UserInterface.consoleWidth));
			break;
		case 2:
			rand = r.nextInt(soundListLength);
			UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center(InterfaceConstants.RAMP_SOUNDS[rand], UserInterface.consoleWidth));
			break;
		default:
			rand = r.nextInt(soundListLength);
			UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.right(InterfaceConstants.RAMP_SOUNDS[rand].concat(UserInterface.multiplyText(UserInterface.blankMultiplier, InterfaceConstants.MARGIN)), UserInterface.consoleWidth));
			break;
			
		}
	}

	/**
	 * Method for the behavior of the ball when it fall off from the game
	 */
	public static void fallOff() {
			
		System.out.println();
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED,StringUtils.center("poof", UserInterface.consoleWidth));
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED,StringUtils.center(InterfaceConstants.BALL_FALLOFF, UserInterface.consoleWidth));

		isBonus = Boolean.FALSE;
		isFallOff = Boolean.TRUE;
		Game.nTry++;

	}
}
