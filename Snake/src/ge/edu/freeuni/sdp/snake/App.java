package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.swing.SwingViewFactory;

import java.util.ArrayList;
import java.util.List;

public class App{
	
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 400;
	

	public static void main(String[] args) {

		Size size = new Size(GAME_WIDTH, GAME_HEIGHT);

		List<Level> levels = new ArrayList<Level>();

		Level level1 = new Level(
				"Very Simple Level", 
				new SphericTopology(),
				new SingleMousePopulator());

		//TODO Add other levels here
		levels.add(level1);

		Configuration.init(size, levels);
		
		
		SwingViewFactory viewFactory = new SwingViewFactory();
		ViewController controller = new ViewController(viewFactory);
		controller.run();
		
	}
}