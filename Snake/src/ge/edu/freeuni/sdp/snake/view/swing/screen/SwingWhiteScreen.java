package ge.edu.freeuni.sdp.snake.view.swing.screen;

import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.CellContent;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class SwingWhiteScreen extends Screen {

	public SwingWhiteScreen(Size size, int cellSize) {
		super(size, cellSize);
	}

	private void flush(Graphics graphics, int i, int j) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
	}

	@Override
	public void paint(Graphics graphics) {
		for (int i = 0; i < super.width; i++) {
			for (int j = 0; j < height; j++) {
				CellContent c = grid.get(i).get(j);
				if (c != null)
					switch (c) {
					case FoodMouse:
						flush(graphics, i, j);
						graphics.setColor(Color.YELLOW);
						graphics.fillRect(i * cellSize, j * cellSize, cellSize,
								cellSize);
						break;
					case FoodPoison:
						flush(graphics, i, j);
						graphics.setColor(Color.RED);
						graphics.fillRect(i * cellSize, j * cellSize, cellSize,
								cellSize);
						break;
					case Snake:
						flush(graphics, i, j);
						graphics.setColor(Color.GREEN);
						graphics.fillOval(i * cellSize + 2, j * cellSize + 2,
								cellSize - 4, cellSize - 4);
						break;
					default:
						flush(graphics, i, j);
						break;
					}
				else
					flush(graphics, i, j);
			}
		}
	}
}
