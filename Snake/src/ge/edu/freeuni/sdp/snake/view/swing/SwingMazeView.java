package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.DirectionKey;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.MazeView;
import ge.edu.freeuni.sdp.snake.view.swing.screen.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingMazeView implements MazeView, KeyListener {
	private DirectionKey key;
	private MazePresenter presenter;

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public SwingMazeView(MazePresenter presenter, Screen screen) {
		screen.addKeyListener(this);
		this.presenter = presenter;
		this.key = DirectionKey.None;
		this.presenter.setCellUpdateListener(new SwingMazeViewUpdater(screen));
		this.presenter.setLivesUpdateListener(new SwingLivesViewUpdater());
	}

	@Override
	public void show() {
		while (true) {
			if (presenter.isGameOver())
				return;
			presenter.tick(key);
			key = DirectionKey.None;
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

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
