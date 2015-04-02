package ge.edu.freeuni.sdp.snake.presenter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.HighScoreData;

public class PresenterFactory {

	private GameFacade game;
	
	public LevelPresenter getLevelPresenter() {
		return new LevelPresenter();
	}

	public MazePresenter getMazePresenter() {
		game = new GameFacade();
		return new MazePresenter(game);
	}

	public GameOverPresenter getGameOverPresenter() {
		return new GameOverPresenter();
	}
	
	public HighScorePresenter getHighScorePresenter(){
		HighScoreData data = new HighScoreData();
		return new HighScorePresenter(data,game);
	}
	
}