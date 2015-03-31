package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.CellContent;
import ge.edu.freeuni.sdp.snake.presenter.CellPosition;
import ge.edu.freeuni.sdp.snake.presenter.CellUpdateListener;

public class SwingMazeViewUpdater implements CellUpdateListener {
	private SwingScreen screen;

	public SwingMazeViewUpdater(SwingScreen screen) {
		this.screen = screen;
	}

	@Override
	public void updateCell(CellPosition position, CellContent content) {
		screen.update(position, content);
		screen.repaint();
	}

}
