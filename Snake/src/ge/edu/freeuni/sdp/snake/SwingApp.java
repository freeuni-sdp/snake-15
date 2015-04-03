package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.PresenterFactory;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.ViewFactory;
import ge.edu.freeuni.sdp.snake.view.swing.SwingViewFactory;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

public class SwingApp {

	public static void main(String[] args) {
		Size size = new Size(50, 30);

		List<Level> levels = LevelRegistry.getLevels();
		
		Configuration.init(size, levels);

		JFrame frame = createFrame(size);
		ViewFactory viewFactory = new SwingViewFactory(frame);
		ViewController controller = 
				new ViewController(
						viewFactory,
						new PresenterFactory());
		controller.run();
	}

	private static JFrame createFrame(Size size) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(
				new Dimension(
						size.getWidth() * 15, 
						size.getHeight() * 15));

		frame.setResizable(false);
		frame.setTitle("Snake Game");
		
		return frame;

	}
}