package ge.edu.freeuni.sdp.snake.presenter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ge.edu.freeuni.sdp.snake.model.GameFacade;

public class PresenterFactory {

	public LevelPresenter getLevelPresenter() {
		return new LevelPresenter();
	}

	public MazePresenter getFullMazePresenter() {
		GameFacade game = new GameFacade();
		return new FullMazePresenter(game);
	}
	
	public MazePresenter getHugeMazePresenter() {
		GameFacade game = new GameFacade();
		return new HugeMazePresenter(game);
	}

	public GameOverPresenter getGameOverPresenter() {
		throw new NotImplementedException();
	}
}