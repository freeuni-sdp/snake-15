package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.DirectionKey;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.MazeView;
import ge.edu.freeuni.sdp.snake.view.swing.screen.Screen;
import ge.edu.freeuni.sdp.snake.view.swing.screen.SwingBlackScreen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SwingMazeView implements MazeView, KeyListener {
	
	private DirectionKey key;
	private MazePresenter presenter;
	private JFrame frame;

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
	}
		
	@Override
	public void show() {

		Size size = Configuration.getInstance().getSize();
		Screen screen = new SwingBlackScreen(size, 15);
		frame.addKeyListener(this);
		frame.add(screen);
		frame.pack();
		center();
		frame.setVisible(true);
		
		
		this.presenter.setCellUpdateListener(new SwingMazeViewUpdater(screen));
		this.presenter.setLivesUpdateListener(new SwingLivesViewUpdater());

		
		while (true) {
			if (presenter.isGameOver())
				break;
			presenter.tick(key);
			key = DirectionKey.None;
			this.sleep();
		}
		
		frame.setVisible(false);
	}

	public void center() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(
				dim.width/2-frame.getSize().width/2, 
				dim.height/2-frame.getSize().height/2);
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
