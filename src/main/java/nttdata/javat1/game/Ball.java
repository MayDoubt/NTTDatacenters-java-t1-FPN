package nttdata.javat1.game;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class Ball {
	
	private ScoreKeeper scoreKeeper;
	private boolean isFallOff;
	private boolean isBonus;
	Random r = new Random();
	
	public Ball(ScoreKeeper scoreKeeper) {
		
		this.scoreKeeper = scoreKeeper;
	}
	
	public boolean isFallOff() {
		return isFallOff;
	} 
	
	public boolean isBonus() {
		return isBonus;
	}
	
	public void setBonus(boolean isBonus) {
		this.isBonus = isBonus;
	}
	
	public void increaseAnchor() {
		scoreKeeper.incrementAnchor();
	}
	
	public void bounce() {
		int rand = r.nextInt(3);
		int soundListLength = InterfaceConstants.BOUNCE_SOUNDS.length;
		System.out.println();
		switch(rand) {
			case 1:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(60, StringUtils.left(InterfaceConstants.BOUNCE_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
				break;	
			case 2:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(60, StringUtils.center(InterfaceConstants.BOUNCE_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
				break;	
			default:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(60, StringUtils.right(InterfaceConstants.BOUNCE_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
				break;	
		}
		if(isBonus) {
			scoreKeeper.incrementScore (15*scoreKeeper.getStreak());
		} else {
			scoreKeeper.incrementScore (5*scoreKeeper.getStreak());
		}
		
	}

	public void hole() {
		int rand = r.nextInt(3);
		int soundListLength = InterfaceConstants.HOLE_SOUNDS.length;
		System.out.println();
		switch(rand) {
			case 1:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(60, StringUtils.left(InterfaceConstants.HOLE_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
				break;
			case 2:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(60, StringUtils.center(InterfaceConstants.HOLE_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
				break;
			default:
				rand = r.nextInt(soundListLength);
				UserInterface.typeWriteText(60, StringUtils.right(InterfaceConstants.HOLE_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
				break;
		}
		if(isBonus) {
			scoreKeeper.incrementScore (15*scoreKeeper.getStreak());
		} else {
			scoreKeeper.incrementScore (5*scoreKeeper.getStreak());
			scoreKeeper.incrementStreak();
		}
	}
	
	public void ramp() {
		int rand = r.nextInt(3);
		int soundListLength = InterfaceConstants.RAMP_SOUNDS.length;
		System.out.println();
		switch(rand) {
		case 1:
			rand = r.nextInt(soundListLength);
			UserInterface.typeWriteText(60, StringUtils.left(InterfaceConstants.RAMP_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
			break;
		case 2:
			rand = r.nextInt(soundListLength);
			UserInterface.typeWriteText(60, StringUtils.center(InterfaceConstants.RAMP_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
			break;
		default:
			rand = r.nextInt(soundListLength);
			UserInterface.typeWriteText(60, StringUtils.right(InterfaceConstants.RAMP_SOUNDS[rand], UserInterface.CONSOLE_WIDTH));
			break;
		}
		if(isBonus) {
			scoreKeeper.incrementScore (35*scoreKeeper.getStreak());
		} else {
			scoreKeeper.incrementScore(20);
		}
	}

	public void fallOff() {
		if(scoreKeeper.getAnchor()>0) {
			UserInterface.typeWriteText(60, "You have seven lifes mate!");
			scoreKeeper.decreaseAnchor();
			scoreKeeper.resetStreak();
			isBonus = Boolean.FALSE;
			isFallOff = Boolean.FALSE;
		} else {
			UserInterface.typeWriteText(60, StringUtils.center("poof", UserInterface.CONSOLE_WIDTH));
			UserInterface.typeWriteText(60, StringUtils.center(InterfaceConstants.GAME_OVER, UserInterface.CONSOLE_WIDTH));
			scoreKeeper.resetStreak();
			isBonus = Boolean.FALSE;
			isFallOff = Boolean.TRUE;
		}
	}
	
}
