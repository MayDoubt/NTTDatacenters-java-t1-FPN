package nttdata.javat1.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;


/**
 * @author Fernando Pérez  - Game Class
 * 
 * Control the main loop of the game
 *
 */
public class Game {
	
	/** Atributes for the Game class */
	static Random r = new Random();
	static Map <String, Integer> scoreBoard = new HashMap<>();
	static int nTry = 3;
	
	/**
	 * Empty constructor to let you know that it's not an instantiable class
	 */
	private Game() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Method that initialize the settings, the sound, etc.
	 * 
	 */
	public static void launchAndStart() {
		
		UserInterface.settingMenu();
		SoundEffects.initializeOst();
		SoundEffects.playSound();
		UserInterface.showIntro();
		UserInterface.menu();
	}
	
	/**
	 * Method that start a new game
	 */
	public static void newGame() {
		
		nTry = 3;
		//Creamos un userScore que se encargara de contar puntos
		ScoreKeeper userScore = new ScoreKeeper(0, 0, 0);
		int totalPoints = 0;
		//Revisamos el numero de bolas que tenemos.
		do {
			
			totalPoints = shotBall(userScore);
			nTry--;
				
		} while (nTry>0);
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center(InterfaceConstants.GAME_OVER, UserInterface.consoleWidth));
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center(UserInterface.toStrBuilder(InterfaceConstants.SCORE_MSG, String.valueOf(totalPoints), "pts.") , UserInterface.consoleWidth));
	}

	/**
	 * Method that recreate the launch of the ball
	 * 
	 * @param userScore
	 */
	private static int shotBall(ScoreKeeper userScore) {
		
		boolean isShooted = UserInterface.shotInput();
		if(isShooted) {
						
			Ball ball = new Ball();
			int timer = 0;
			int holeCounter = 0;
			int rampCounter = 0;
			
			do {
				
				//Turno de la bola
				//Rebota n veces al comienzo del turno
				int rand = r.nextInt(10);
				repeatBounce(ball, rand);
				
				//Luego puede volver a rebotar u otras de las opciones
				rand = r.nextInt(100);
				if(rand <=65) {
					fallInBouncer(ball, userScore);
				} else if (rand <=75) {
					holeCounter = fallInHole(ball, userScore, holeCounter);
				} else if (rand <=90) {
					rampCounter = enterRamp(ball, userScore, rampCounter);
				} else {
					fallOffBall(userScore);
					holeCounter = 0;
					rampCounter = 0;
					
				}
				
				//Decisiones post-turno
				if(holeCounter >= 5) {
					holeCounter = 5;
					Ball.setBonus(Boolean.TRUE);
					timer++;
				} else if (rampCounter >= 7) {
					rampCounter = 0;
					userScore.incrementAnchor();
				} else if (timer >= 30) {
					Ball.setBonus(Boolean.FALSE);
					timer = 0;
				}
				
			} while (!ball.isFallOff());
		}
		System.out.println("You have " + userScore.getScore() + " points!");
		return userScore.getScore();
		
	}

	/**
	 * Method that repeat the bounce of the ball n times.
	 * 
	 * @param ball
	 * @param times
	 */
	private static void repeatBounce(Ball ball, int times) {
		for(int i = 0; i<times; i++) {
			ball.bounce();
		}
	}

	private static void fallInBouncer(Ball ball, ScoreKeeper userScore) {
		
		ball.bounce();
		if(ball.isBonus()) {
			userScore.incrementScore (15*userScore.getStreak());
		} else {
			userScore.incrementScore (5*userScore.getStreak());
		}
	}
	
	private static int fallInHole(Ball ball, ScoreKeeper userScore, int holeCounter) {
		ball.hole();
		
		if(ball.isBonus()) {
			userScore.incrementScore (15*userScore.getStreak());
		} else {
			userScore.incrementScore (5*userScore.getStreak());
			userScore.incrementStreak();
		}
		holeCounter++;
		return holeCounter;
	}
	
	private static int enterRamp(Ball ball, ScoreKeeper userScore, int rampCounter) {
		ball.ramp();
		
		if(ball.isBonus()) {
			userScore.incrementScore (35*userScore.getStreak());
		} else {
			userScore.incrementScore(20);
		}
		rampCounter++;
		return rampCounter;
	}
	
	private static void fallOffBall(ScoreKeeper userScore) {
		Ball.fallOff();
		userScore.resetStreak();
		if(userScore.getAnchor() > 1) {
			nTry++;
			userScore.decreaseAnchor();
			UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, (StringUtils.center(UserInterface.toStrBuilder("You have ", String.valueOf(userScore.getAnchor()), " now. Watch out for the sea!"), UserInterface.consoleWidth)));
		}
	}
	
}
