package ge.edu.freeuni.sdp.snake.presenter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.ReverseGameFacade;

public class PresenterFactory {

	public LevelPresenter getLevelPresenter() {
		return new LevelPresenter();
	}

	public MazePresenter getMazePresenter() {
		Level level = Configuration.getInstance().getSelectedLevel();
		GameFacade game;
		if (level.getName() != "Swap sides") 
			game = new GameFacade();
		else 
			game = new ReverseGameFacade();
		return new MazePresenter(game);
	}

	public GameOverPresenter getGameOverPresenter() {
		throw new NotImplementedException();
	}
}