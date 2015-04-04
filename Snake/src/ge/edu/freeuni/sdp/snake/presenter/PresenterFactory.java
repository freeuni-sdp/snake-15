package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.CommonGameFacadeFactory;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.GameFacadeFactory;
import ge.edu.freeuni.sdp.snake.model.HighScoreData;

public class PresenterFactory {

	private GameFacade game;
	private GameFacadeFactory gameFacadeFactory;
	
	public PresenterFactory() {
		this(new CommonGameFacadeFactory());
	}
	
	public PresenterFactory(GameFacadeFactory gameFacadeFactory) {
		this.gameFacadeFactory = gameFacadeFactory;
		
	}
	
	public LevelPresenter getLevelPresenter() {
		return new LevelPresenter();
	}

	public MazePresenter getMazePresenter() {
		game = gameFacadeFactory.getGameFacade();
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