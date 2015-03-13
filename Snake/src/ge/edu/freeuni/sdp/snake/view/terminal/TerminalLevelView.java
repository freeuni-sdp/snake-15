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
		_terminal.clearScreen();
		String[] names = _presenter.getLevelNames();

		for (int i = 0; i < names.length; i++) {
			_terminal.moveCursor(6, 6 + i);
			writeLine(String.format("[%1$s] - %2$s", i+1, names[i]));
		}

		_terminal.flush();

		boolean isAccepted = false;
		while (!isAccepted) {
			Key p = _terminal.readInput();
			if (p == null) continue;
			char ch = p.getCharacter();
			if (!Character.isDigit(ch)) continue;
			int index = Character.getNumericValue(ch) - 1;
			isAccepted = _presenter.setSelection(index);
		}
	}

	private void writeLine(String print) {
		char[] printToChar = print.toCharArray();
		for (int i = 0; i < print.length(); i++) {
			_terminal.putCharacter(printToChar[i]);
		}
	}
}