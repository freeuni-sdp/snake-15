/**
 * 
 */
package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.GameOverPresenter;
import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.GameOverView;
import ge.edu.freeuni.sdp.snake.view.LevelView;
import ge.edu.freeuni.sdp.snake.view.MazeView;
import ge.edu.freeuni.sdp.snake.view.ViewFactory;

/**
 * @author Giorgi
 *
 */
public class SwingViewFactory implements ViewFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ge.edu.freeuni.sdp.snake.view.ViewFactory#getLevelView(ge.edu.freeuni
	 * .sdp.snake.presenter.LevelPresenter)
	 */
	@Override
	public LevelView getLevelView(LevelPresenter presenter) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ge.edu.freeuni.sdp.snake.view.ViewFactory#getMazeView(ge.edu.freeuni.
	 * sdp.snake.presenter.MazePresenter)
	 */
	@Override
	public MazeView getMazeView(MazePresenter presenter) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ge.edu.freeuni.sdp.snake.view.ViewFactory#getGameOverView(ge.edu.freeuni
	 * .sdp.snake.presenter.GameOverPresenter)
	 */
	@Override
	public GameOverView getGameOverView(GameOverPresenter presenter) {
		// TODO Auto-generated method stub
		return null;
	}

}
