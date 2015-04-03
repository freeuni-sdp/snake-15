package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.view.LevelView;

public class SwingLevelView implements LevelView {
	private LevelPresenter presenter;

	public SwingLevelView(LevelPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void show() {
		if (!(presenter.setSelection(0))) {
			System.out.println("Some error occured!");
		}
	}

	@Override
	public void showDescription(String description) {
		// TODO Auto-generated method stub
		
	}

}
