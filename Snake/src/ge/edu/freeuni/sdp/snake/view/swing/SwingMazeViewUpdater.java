package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.CellContent;
import ge.edu.freeuni.sdp.snake.presenter.CellPosition;
import ge.edu.freeuni.sdp.snake.presenter.CellUpdateListener;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingMazeViewUpdater implements CellUpdateListener {
	private JFrame frame;

	public SwingMazeViewUpdater(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void updateCell(CellPosition position, CellContent content) {
		java.awt.Graphics graphics = frame.getGraphics();
		int width = 20;
		int height = 20;
		switch (content) {
		case FoodMouse:
			graphics.setColor(Color.YELLOW);
			graphics.fillRect(position.x * width, position.y * height, width,
					height);
			break;
		case FoodPoison:
			graphics.setColor(Color.RED);
			graphics.fillRect(position.x * width, position.y * height, width,
					height);
			break;
		case Snake:
			graphics.setColor(Color.GREEN);
			graphics.fillOval(position.x * width + 2, position.y * height + 2,
					width - 4, height - 4);
			break;
		default:
			graphics.setColor(Color.BLACK);
			graphics.fillRect(position.x * width, position.y * height, width,
					height);
			break;
		}

	}

}
