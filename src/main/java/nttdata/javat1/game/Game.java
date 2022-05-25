package nttdata.javat1.game;

import java.util.Random;


public class Game {
	
	static Random r = new Random();
	static int nTry = 0;
	
	private Game() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void launchAndStart() {
		
		SoundEffects.initializeOst();
		SoundEffects.playSound();
		UserInterface.showIntro();
		UserInterface.menu();
	}

	private static void shotBall(ScoreKeeper userScore) {

		Ball ball = new Ball(userScore);
		int holeCounter = 0;
		int rampCounter = 0;
		do {
			int position = r.nextInt(20);
			repeatBounce(ball, position);

			position = r.nextInt(100);
			if (position <= 55) {
				ball.bounce();
			} else if (position < 65) {
				ball.hole();
				holeCounter++;
			} else if (position<85) {
				ball.ramp();
				rampCounter++;
			} else {
				ball.fallOff();
				System.out.println(nTry);
			}
			
			if (holeCounter == 3) {
				ball.setBonus(true);
				holeCounter = 0;
			}
			
			if (rampCounter == 5) {
				ball.increaseAnchor();
			}
			
		} while (ball.isFallOff());

	}

	private static void repeatBounce(Ball ball, int position) {
		for(int i = 0; i<position; i++) {
			ball.bounce();
		}
	}

	public static void newGame() {
		ScoreKeeper userScore = new ScoreKeeper(0, 0, 0);
		while (nTry <3) {
			
				shotBall(userScore);
				nTry++;
			}
		}
	}
}
