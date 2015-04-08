package ge.edu.freeuni.sdp.snake.view.terminal;

import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.presenter.LevelSelectionListener;
import ge.edu.freeuni.sdp.snake.view.LevelView;
import ge.edu.freeuni.sdp.snake.view.LevelViewUpdater;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class TerminalLevelView implements LevelView {

	private Terminal _terminal;
	private LevelPresenter _presenter;
	private int _lvlCount;
	private int _oldIndex;
	private int _selectedIndex;
	private static final String DESCR = "Description: ";
	private static final String HINT = "Press ENTER to start.";

	public TerminalLevelView(LevelPresenter presenter, Terminal terminal) {
		_presenter = presenter;
		_terminal = terminal;
		LevelSelectionListener listener = new LevelViewUpdater(this);
		_presenter.setLevelSelectionListener(listener);
		_oldIndex = -1;
		_selectedIndex = -1;
	}

	@Override
	public void show() {
		_terminal.clearScreen();
		String[] names = _presenter.getLevelNames();
		_lvlCount = names.length;

		for (int i = 0; i < names.length; i++) {
			_terminal.moveCursor(6, 6 + i);
			writeLine(String.format("[%1$s] - %2$s", i+1, names[i]));
		}

		_terminal.flush();

		boolean isAccepted = false;
		boolean isSelected = false;
		while (!isAccepted) {
			Key p = _terminal.readInput();
			if (p == null) continue;
			if (p.getKind() == Key.Kind.Enter && isSelected) {
				isAccepted = true;
				break;
			}
			char ch = p.getCharacter();
			if (!Character.isDigit(ch)) continue;
			int index = Character.getNumericValue(ch) - 1;
			updateIndexTracker(index);
			isSelected = _presenter.setSelection(index);
		}
	}

	private void updateIndexTracker(int index) {
		if (_oldIndex == -1) {
			_oldIndex = index;
			_selectedIndex = index;
		} else {
			_oldIndex = _selectedIndex;
			_selectedIndex = index;
		}
	}
	
	@Override
	public void showDescription(String description) {
		_terminal.moveCursor(5, 6 + _oldIndex);
		_terminal.putCharacter(' ');
		_terminal.moveCursor(5, 6 + _selectedIndex);
		_terminal.putCharacter('*');
		
		_terminal.moveCursor(6, 6 + _lvlCount + 1);
		clearLine();
		_terminal.moveCursor(6, 6 + _lvlCount + 1);

		writeLine(DESCR);
		writeLine(description);
		_terminal.moveCursor(6, 6 + _lvlCount + 3);
		writeLine(HINT);
		_terminal.flush();
	}

	private void writeLine(String print) {
		char[] printToChar = print.toCharArray();
		for (int i = 0; i < print.length(); i++) {
			_terminal.putCharacter(printToChar[i]);
		}
	}
	
	private void clearLine() {
		for (int i = 0; i < _terminal.getTerminalSize().getColumns(); ++i)
			_terminal.putCharacter(' ');
	}
}
