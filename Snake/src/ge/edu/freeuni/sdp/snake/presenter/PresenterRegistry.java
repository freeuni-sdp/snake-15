package ge.edu.freeuni.sdp.snake.presenter;

public class PresenterRegistry {

	LevelPresenter _levelPresenter;
	MazePresenter _mazePresenter;
	GameOverPresenter _gameOverPresenter;

	public LevelPresenter getLevelPresenter() {
		return _levelPresenter;
	}

	public void setLevelPresenter(LevelPresenter levelPresenter) {
		_levelPresenter = levelPresenter;
	}

	public MazePresenter getMazePresenter() {
		return _mazePresenter;
	}

	public void setMazePresenter(MazePresenter mazePresenter) {
		_mazePresenter = mazePresenter;
	}

	public GameOverPresenter getGameOverPresenter() {
		return _gameOverPresenter;
	}

	public void setGameOverPresenter(GameOverPresenter gameOverPresenter) {
		_gameOverPresenter = gameOverPresenter;
	}
}