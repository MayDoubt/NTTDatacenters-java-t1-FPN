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
			
			totalPoints += shotBall(userScore);
			nTry--;
				
		} while (nTry>0);
		
		UserInterface.addScorePlayer(totalPoints, scoreBoard);
	}

	

	/**
	 * Method that recreate the launch of the ball
	 * 
	 * @param userScore
	 */
	private static int shotBall(ScoreKeeper userScore) {
		
		boolean isShooted = UserInterface.shotInput();
		Ball.setFallOff(Boolean.FALSE);
		
		if(isShooted) {
						
			Ball ball = new Ball();
			int timer = 0;
			int holeCounter = 0;
			int rampCounter = 0;
			
			do {
				
				//Turno de la bola
				//Rebota n veces al comienzo del turno
				int rand = r.nextInt(10);
				repeatBounce(ball, userScore, rand);
				
				//Luego puede volver a rebotar u otras de las opciones
				rand = r.nextInt(100);
				if(rand <=75) {
					fallInBouncer(ball, userScore);
				} else if (rand <=85) {
					holeCounter = fallInHole(ball, userScore, holeCounter);
				} else if (rand <=95) {
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
	private static void repeatBounce(Ball ball, ScoreKeeper userScore, int times) {
		for(int i = 0; i<times; i++) {
			System.out.println();
			ball.bounce();
			if(ball.isBonus()) {
				userScore.incrementScore (150*userScore.getStreak());
			} else {
				userScore.incrementScore (100*userScore.getStreak());
			}
		}
	}

	/**
	 * Method with the logic when you fall in a bouncer
	 * 
	 * @param ball
	 * @param userScore
	 */
	private static void fallInBouncer(Ball ball, ScoreKeeper userScore) {
		
		ball.bounce();
		if(ball.isBonus()) {
			userScore.incrementScore (150*userScore.getStreak());
		} else {
			userScore.incrementScore (100*userScore.getStreak());
		}
	}
	
	/**
	 * Method with the logic when you fall in a hole
	 * 
	 * @param ball
	 * @param userScore
	 * @param holeCounter
	 * @return
	 */
	private static int fallInHole(Ball ball, ScoreKeeper userScore, int holeCounter) {
		ball.hole();
		
		if(ball.isBonus()) {
			userScore.incrementScore (350*userScore.getStreak());
			UserInterface.multiplyText(2, "\n");
			UserInterface.showImage(InterfaceConstants.TREASURE, InterfaceConstants.HIGH_SPEED);
		} else {
			userScore.incrementScore (150*userScore.getStreak());
			userScore.incrementStreak();
		}
		holeCounter++;
		return holeCounter;
	}
	
	/**
	 * Method with the logic when you enter in the ramp
	 * 
	 * @param ball
	 * @param userScore
	 * @param rampCounter
	 * @return
	 */
	private static int enterRamp(Ball ball, ScoreKeeper userScore, int rampCounter) {
		ball.ramp();
		
		if(ball.isBonus()) {
			userScore.incrementScore (500*userScore.getStreak());
		} else {
			userScore.incrementScore(200);
		}
		rampCounter++;
		return rampCounter;
	}
	
	/**
	 * Method with the logic when you fail hit the ball
	 * 
	 * @param userScore
	 */
	private static void fallOffBall(ScoreKeeper userScore) {
		Ball.fallOff();
		userScore.resetStreak();
		if(userScore.getAnchor() > 1) {
			nTry++;
			userScore.decreaseAnchor();
			UserInterface.typeWriteText(InterfaceConstants.HIGH_SPEED, (StringUtils.center(UserInterface.toStrBuilder("You have ", String.valueOf(userScore.getAnchor()), " now. Watch out for the sea!"), UserInterface.consoleWidth)));
		}
	}
	
}
