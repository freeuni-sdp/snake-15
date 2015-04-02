package ge.edu.freeuni.sdp.snake.view;

import ge.edu.freeuni.sdp.snake.presenter.GameOverPresenter;
import ge.edu.freeuni.sdp.snake.presenter.HighScorePresenter;
import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;

public interface ViewFactory {

	LevelView getLevelView(LevelPresenter presenter);

	MazeView getMazeView(MazePresenter presenter);

	GameOverView getGameOverView(GameOverPresenter presenter);
	
	HighScoreView getHighScoreView(HighScorePresenter presenter);

}
