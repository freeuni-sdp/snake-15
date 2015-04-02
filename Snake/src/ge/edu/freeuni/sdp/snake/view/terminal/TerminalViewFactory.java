package ge.edu.freeuni.sdp.snake.view.terminal;

import ge.edu.freeuni.sdp.snake.presenter.GameOverPresenter;
import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.GameOverView;
import ge.edu.freeuni.sdp.snake.view.LevelView;
import ge.edu.freeuni.sdp.snake.view.MazeView;
import ge.edu.freeuni.sdp.snake.view.ViewFactory;

import com.googlecode.lanterna.terminal.Terminal;

public class TerminalViewFactory implements ViewFactory {

	private Terminal _terminal;

	public TerminalViewFactory(Terminal terminal) {
		_terminal = terminal;
	}

	@Override
	public LevelView getLevelView(LevelPresenter presenter) {
		return new TerminalLevelView(presenter, _terminal);
	}

	@Override
	public MazeView getMazeView(MazePresenter presenter) {
		return new TerminalMazeView(presenter, _terminal);
	}

	@Override
	public GameOverView getGameOverView(GameOverPresenter presenter) {
		return new TerminalGameOverView(presenter, _terminal);
	}

}
