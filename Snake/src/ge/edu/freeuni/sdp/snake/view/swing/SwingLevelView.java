package ge.edu.freeuni.sdp.snake.view.swing;

import javax.swing.JFrame;

import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.view.LevelView;

public class SwingLevelView implements LevelView {
	private LevelPresenter presenter;
	private JFrame frame;

	public SwingLevelView(LevelPresenter presenter, JFrame frame) {
		this.presenter = presenter;
		this.frame = frame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
