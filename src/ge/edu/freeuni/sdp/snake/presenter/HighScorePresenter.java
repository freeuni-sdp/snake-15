package ge.edu.freeuni.sdp.snake.presenter;


import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.HighScoreData;

public class HighScorePresenter {

	private HighScoreData fileData;
	private GameFacade game;
	
	public HighScorePresenter(HighScoreData data,GameFacade game){
		fileData = data;
		this.game = game;
	}
	
	public boolean isGameOver() {
		return game.isGameOver();
	}
	
	public int getScore(){
		return game.getScore();
	}
	
	public String getHighScoreInfo(){
		fileData.readFile();
		return fileData.getFileContent();
	}
	
	public boolean checkNewScore(int score){
		if(fileData.checkIfFileMustBeEdited(score) == -1){
			return false;
		} 
		return true;
	}
	
	
	public void changeHighScoreInfo(String name,int score){
		fileData.editFile(name, score);
	}
	
}
