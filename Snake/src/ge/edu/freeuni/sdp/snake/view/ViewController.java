package ge.edu.freeuni.sdp.snake.view;

import java.io.File;

import ge.edu.freeuni.sdp.snake.presenter.*;
import ge.edu.freeuni.sdp.snake.view.terminal.TerminalViewFactory;

public class ViewController {

	private ViewFactory _viewFactory;
	private PresenterFactory _presenterRegistry;

	public ViewController(TerminalViewFactory viewFactory) {
		this(viewFactory, new PresenterFactory());
	}
	
	public ViewController(ViewFactory viewFactory,
			PresenterFactory presenterRegistry) {
		_viewFactory = viewFactory;
		_presenterRegistry = presenterRegistry;
	}

	public void run() {

		// LevelView --> MazeView --> GameOverView

//		File f = new File("memento");
//		if(f.exists())
		LevelPresenter levelPresenter = _presenterRegistry.getLevelPresenter();
		LevelView levelView = _viewFactory.getLevelView(levelPresenter);
		levelView.show();
		
		MazePresenter mazePresenter = _presenterRegistry.getMazePresenter();
		MazeView mazeView = _viewFactory.getMazeView(mazePresenter);
		mazeView.show();

		/*
		 * The same for GameOverView
		 */
	}
}