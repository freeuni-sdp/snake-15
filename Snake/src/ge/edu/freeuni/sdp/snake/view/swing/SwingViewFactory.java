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
	private SwingScreen screen;

	/**
	 * Constructor for different Swing views
	 * 
	 * @param frame
	 *            on which will be painted elements
	 * @param screen
	 */
	public SwingViewFactory(SwingScreen screen) {
		this.screen = screen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ge.edu.freeuni.sdp.snake.view.ViewFactory#getLevelView(ge.edu.freeuni
	 * .sdp.snake.presenter.LevelPresenter)
	 */
	@Override
	public LevelView getLevelView(LevelPresenter presenter) {
		return new SwingLevelView(presenter);
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
		return new SwingMazeView(presenter, screen);
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
		return new SwingGameOverView();
	}

}
