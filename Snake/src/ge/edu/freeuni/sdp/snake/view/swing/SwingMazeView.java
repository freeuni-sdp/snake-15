package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.MazeView;

import javax.swing.JFrame;

public class SwingMazeView implements MazeView {
	private MazePresenter presenter;
	private JFrame frame;

	public SwingMazeView(MazePresenter presenter, JFrame frame) {
		this.presenter = presenter;
		this.frame = frame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
