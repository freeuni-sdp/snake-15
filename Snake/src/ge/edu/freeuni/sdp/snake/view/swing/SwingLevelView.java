package ge.edu.freeuni.sdp.snake.view.swing;

import javax.swing.JFrame;

import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.view.LevelView;

public class SwingLevelView implements LevelView {
	private LevelPresenter presenter;
	@SuppressWarnings("unused")
	private JFrame frame;

	public SwingLevelView(LevelPresenter presenter, JFrame frame) {
		this.presenter = presenter;
		this.frame = frame;
	}

	@Override
	public void show() {
		boolean accepted = presenter.setSelection(0);
		if (!accepted) {
			System.out.println("Some error occured!");
		}
	}

}
