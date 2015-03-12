package ge.edu.freeuni.sdp.snake.view.terminal;

import ge.edu.freeuni.sdp.snake.presenter.CellContent;
import ge.edu.freeuni.sdp.snake.presenter.CellPosition;
import ge.edu.freeuni.sdp.snake.presenter.CellUpdateListener;

import com.googlecode.lanterna.terminal.Terminal;

public class TerminalMazeViewUpdater implements CellUpdateListener {

	private Terminal _terminal;

	public TerminalMazeViewUpdater(Terminal terminal) {
		_terminal = terminal;
	}

	@Override
	public void updateCell(CellPosition position, CellContent content) {
		char ch = converToChar(content);
		_terminal.moveCursor(position.x, position.y);
		_terminal.putCharacter(ch);
	}

	private char converToChar(CellContent content) {
		switch (content) {
		case FoodMouse:
			return '*';
		case FoodPoison:
			return '$';
		case Snake:
			return 'O';
		default:
			return ' ';
		}
	}
}
