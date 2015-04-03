package ge.edu.freeuni.sdp.snake.view.swing.screen;

import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.CellContent;
import ge.edu.freeuni.sdp.snake.presenter.CellPosition;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Screen extends JPanel {
	protected ArrayList<ArrayList<CellContent>> grid;
	protected int width;
	protected int height;
	protected int cellSize;

	public Screen(Size size, int cellSize) {
		width = size.getWidth();
		height = size.getHeight();
		this.setCellSize(cellSize);
		grid = new ArrayList<ArrayList<CellContent>>();
		for (int i = 0; i < width; i++) {
			ArrayList<CellContent> row = new ArrayList<>();
			for (int j = 0; j < height; j++)
				row.add(null);
			grid.add(row);
		}
	}

	public void update(CellPosition position, CellContent content) {
		grid.get(position.x).set(position.y, content);
	}

	public void getContent(CellPosition position) {
		grid.get(position.x).get(position.y);
	}

	public int getCellSize() {
		return cellSize;
	}

	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}

	@Override
	public abstract void paint(Graphics graphics);
}
