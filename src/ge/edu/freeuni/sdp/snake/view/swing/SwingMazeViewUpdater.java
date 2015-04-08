package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.CellContent;
import ge.edu.freeuni.sdp.snake.presenter.CellPosition;
import ge.edu.freeuni.sdp.snake.presenter.CellUpdateListener;
import ge.edu.freeuni.sdp.snake.view.swing.screen.Screen;

public class SwingMazeViewUpdater implements CellUpdateListener {
	private Screen screen;

	public SwingMazeViewUpdater(Screen screen) {
		this.screen = screen;
	}

	@Override
	public void updateCell(CellPosition position, CellContent content) {
		screen.update(position, content);
		screen.repaint();
	}

}
