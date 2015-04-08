package ge.edu.freeuni.sdp.snake.view.terminal;

import ge.edu.freeuni.sdp.snake.presenter.CellUpdateListener;
import ge.edu.freeuni.sdp.snake.presenter.DirectionKey;
import ge.edu.freeuni.sdp.snake.presenter.LivesUpdateListener;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.MazeView;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;

public class TerminalMazeView implements MazeView {

	private Terminal _terminal;
	private MazePresenter _presenter;

	public TerminalMazeView(MazePresenter presenter, Terminal terminal) {
		_terminal = terminal;
		_presenter = presenter;
		CellUpdateListener updater = new TerminalMazeViewUpdater(terminal);
		_presenter.setCellUpdateListener(updater);
		LivesUpdateListener livesUpdater = new TerminalLivesViewUpdater(terminal);
		_presenter.setLivesUpdateListener(livesUpdater);
	}

	private boolean isStoped = false;
	private final char Space = ' ';
	@Override
	public void show() {
		_terminal.clearScreen();
		while (true) {
			Key key = _terminal.readInput();
			if (_presenter.isGameOver())
				return;
			if(key != null && key.getCharacter() == Space){
				isStoped = !isStoped;
			}
			if (key != null && key.getKind() == Kind.Escape){
				if(isStoped)_presenter.saveState();
				return;
			}
			if(!isStoped)
				_presenter.tick(convertToDirection(key));
			Sleep();
		}
	}

	private DirectionKey convertToDirection(Key key) {
		if (key == null)
			return DirectionKey.None;

		switch (key.getKind()) {
		case ArrowDown:
			return DirectionKey.Down;
		case ArrowUp:
			return DirectionKey.Up;
		case ArrowLeft:
			return DirectionKey.Left;
		case ArrowRight:
			return DirectionKey.Right;
		default:
			return DirectionKey.None;
		}
	}

	private void Sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void restoreState(){
		_presenter.restoreState();
	}
}