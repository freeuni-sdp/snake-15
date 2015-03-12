package ge.edu.freeuni.sdp.snake.view;

import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.presenter.PresenterRegistry;

public class ViewController {

	private ViewFactory _viewFactory;
	private PresenterRegistry _presenterRegistry;

	public ViewController(ViewFactory viewFactory,
			PresenterRegistry presenterRegistry) {
		_viewFactory = viewFactory;
		_presenterRegistry = presenterRegistry;
	}

	public void run() {

		// LevelView --> MazeView --> GameOverView

		/*
		 * LevelPresenter levelPresenter = new LevelPresenter(...); LevelView
		 * levelView = _viewFactory.getLevelView(levelPresenter);
		 * levelView.show();
		 */

		MazePresenter mazePresenter = _presenterRegistry.getMazePresenter();
		MazeView mazeView = _viewFactory.getMazeView(mazePresenter);
		mazeView.show();

		/*
		 * The same for GameOverView
		 */
	}
}