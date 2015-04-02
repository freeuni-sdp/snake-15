package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.view.LevelView;

public class LevelViewUpdater implements LevelSelectionListener {
	
	private LevelView _levelView;
	
	public LevelViewUpdater(LevelView levelView) {
		_levelView = levelView;
	}

	@Override
	public void updateDescription(String description) {
		_levelView.showDescription(description);
	}

}
