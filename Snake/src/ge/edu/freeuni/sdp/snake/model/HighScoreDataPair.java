package ge.edu.freeuni.sdp.snake.model;

public class HighScoreDataPair {

	private String name;
	private int highScore;

	public HighScoreDataPair(String name, int highScore) {
		this.name = name;
		this.highScore = highScore;
	}
	
	public String getName(){
		return name;
	}
	
	public int getHighScore(){
		return highScore;
	}
	
}
