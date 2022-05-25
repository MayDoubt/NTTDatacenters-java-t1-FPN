package nttdata.javat1.game;


public class ScoreKeeper {

	private int score;
	private int streak;
	private int anchor;
	
	public ScoreKeeper (int score, int streak, int anchor) {
		this.score = score;
		this.streak = streak;
		this.anchor = anchor;
	}
	
	public void incrementScore (int points) {
		this.score += points;
	}
	
	public void incrementStreak () {
		if(this.streak < 5) {
			this.streak++;
		}
	}
	
	public void resetStreak () {
		this.streak = 0;
	}
	
	public void incrementAnchor () {
		this.anchor ++;
	}
	
	public void decreaseAnchor () {
		this.anchor --;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getStreak() {
		return streak;
	}
	
	public int getAnchor() {
		return anchor;
	}
}
