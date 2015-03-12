package ge.edu.freeuni.sdp.snake.view.terminal;

import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.view.LevelView;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class TerminalLevelView implements LevelView {

	private Terminal _terminal;
	private LevelPresenter _presenter;

	public TerminalLevelView(LevelPresenter presenter, Terminal terminal) {
		_presenter = presenter;
		_terminal = terminal;
	}

	@Override
	public void show() {

		String[] names = _presenter.getLevelNames();

		for (int i = 0; i < names.length; i++) {
			_terminal.moveCursor(6, 6 + i);
			writeLine(names[i]);
		}

		_terminal.flush();

		boolean isAccepted = false;
		while (!isAccepted) {
			Key p = _terminal.readInput();
			if (p == null)
				continue;
			char ch = p.getCharacter();
			isAccepted = _presenter.setSelection(ch);
		}
	}

	private void writeLine(String print) {
		char[] printToChar = print.toCharArray();
		for (int i = 0; i < print.length(); i++) {
			_terminal.putCharacter(printToChar[i]);
		}
	}
}