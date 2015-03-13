package ge.edu.freeuni.sdp.snake.presenter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ge.edu.freeuni.sdp.snake.model.GameFacade;

public class PresenterFactory {

	public LevelPresenter getLevelPresenter() {
		return new LevelPresenter();
	}

	public MazePresenter getMazePresenter() {
		GameFacade game = new GameFacade();
		return new MazePresenter(game);
	}

	public GameOverPresenter getGameOverPresenter() {
		throw new NotImplementedException();
	}
}