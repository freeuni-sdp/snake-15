package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.DirectionKey;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.MazeView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SwingMazeView implements MazeView, KeyListener {
	private JFrame frame;
	private DirectionKey key;
	private MazePresenter presenter;

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public SwingMazeView(MazePresenter presenter, JFrame frame) {
		this.frame = frame;
		this.presenter = presenter;
		this.key = DirectionKey.None;
		this.presenter.setCellUpdateListener(new SwingMazeViewUpdater(
				this.frame));
	}

	@Override
	public void show() {
		while (true) {
			if (presenter.isGameOver())
				return;
			presenter.tick(key);
			this.sleep();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.key = DirectionKey.Up;
			break;

		case KeyEvent.VK_DOWN:
			this.key = DirectionKey.Down;
			break;

		case KeyEvent.VK_LEFT:
			this.key = DirectionKey.Left;
			break;

		case KeyEvent.VK_RIGHT:
			this.key = DirectionKey.Right;
			break;

		default:
			this.key = DirectionKey.None;
			break;
		}
		System.out.println("key pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
	}

}
