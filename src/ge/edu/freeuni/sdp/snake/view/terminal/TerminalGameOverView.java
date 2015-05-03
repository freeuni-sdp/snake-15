package ge.edu.freeuni.sdp.snake.view.terminal;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import ge.edu.freeuni.sdp.snake.presenter.GameOverPresenter;
import ge.edu.freeuni.sdp.snake.view.GameOverView;

public class TerminalGameOverView implements GameOverView {

	private Terminal _terminal;
	private boolean _continueGame;

	public TerminalGameOverView(GameOverPresenter presenter, Terminal terminal) {
		_terminal = terminal;
		_continueGame = false;
	}

	@Override
	public void show() {
		_terminal.clearScreen();
		String[] names = { "        Game Over        ",
				"Do you want to play again?", "  Press Y to play again.",
				"  Press N or ESC to quit." };
		TerminalSize screenSize = _terminal.getTerminalSize();

		for (int i = 0; i < names.length; i++) {
			_terminal.moveCursor(screenSize.getColumns() / 2 - 15,
					screenSize.getRows() / 2 - 2 + i);
			writeLine(String.format("%s", names[i]));
		}

		_terminal.flush();
		while (true) {
			Key p = _terminal.readInput();
			if (p == null)
				continue;
			char ch = p.getCharacter();
			if (p.getKind() == Kind.Escape || ch == 'n')
				break;
			if (ch == 'y') {
				_continueGame = true;
				break;
			}
		}
	}

	@Override
	public boolean continueGameOrNot() {
		return _continueGame;
	}

	private void writeLine(String print) {
		char[] printToChar = print.toCharArray();
		for (int i = 0; i < print.length(); i++) {
			_terminal.putCharacter(printToChar[i]);
		}
	}

}
