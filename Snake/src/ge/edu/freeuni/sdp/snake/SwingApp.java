package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.PresenterFactory;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.ViewFactory;
import ge.edu.freeuni.sdp.snake.view.swing.SwingViewFactory;
import ge.edu.freeuni.sdp.snake.view.swing.screen.Screen;
import ge.edu.freeuni.sdp.snake.view.swing.screen.SwingBlackScreen;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

public class SwingApp {

	private static final int SIZE = 15;

	public static void main(String[] args) {
		Size size = new Size(50, 30);

		List<Level> levels = LevelRegistry.getLevels();
		
		Configuration.init(size, levels);

		Screen screen = new SwingBlackScreen(size, SIZE);
		screen.setFocusable(true);
		screen.setPreferredSize(
				new Dimension(
						size.getWidth() * SIZE, 
						size.getHeight() * SIZE));

		createFrame(size, screen);
		ViewFactory viewFactory = new SwingViewFactory(screen);
		ViewController controller = new ViewController(viewFactory,
				new PresenterFactory());
		controller.run();
	}

	private static JFrame createFrame(Size size, Component screen) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Snake");
		frame.setLayout(new GridLayout(1, 1, 0, 0));

		frame.add(screen);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;

	}
}