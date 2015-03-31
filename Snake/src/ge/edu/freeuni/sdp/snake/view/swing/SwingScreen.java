package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.CellContent;
import ge.edu.freeuni.sdp.snake.presenter.CellPosition;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SwingScreen extends JPanel {
	private ArrayList<ArrayList<CellContent>> grid;
	private int width;
	private int height;
	private int cellSize;

	public SwingScreen(Size size, int cellSize) {
		width = size.getWidth();
		height = size.getHeight();
		this.cellSize = cellSize;
		grid = new ArrayList<ArrayList<CellContent>>();
		for (int i = 0; i < width; i++) {
			ArrayList<CellContent> row = new ArrayList<>();
			for (int j = 0; j < height; j++)
				row.add(null);
			grid.add(row);
		}
	}

	public void update(CellPosition position, CellContent conten) {
		grid.get(position.x).set(position.y, conten);
	}

	private void flush(Graphics graphics, int i, int j) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
	}

	@Override
	public void paint(Graphics graphics) {
		for (int i = 0; i < width; i++) {
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
