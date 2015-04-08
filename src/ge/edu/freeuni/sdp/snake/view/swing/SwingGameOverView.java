package ge.edu.freeuni.sdp.snake.view.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ge.edu.freeuni.sdp.snake.view.GameOverView;

public class SwingGameOverView implements GameOverView {

	private final JFrame frame;
	private int result;

	public SwingGameOverView(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void show() {
		result = JOptionPane.showConfirmDialog(
			    frame,
			    "Would you like to play again?",
			    "Game over",
			    JOptionPane.YES_NO_OPTION);
	}

	@Override
	public boolean continueGameOrNot() {
		return result == 0;
	}
}
