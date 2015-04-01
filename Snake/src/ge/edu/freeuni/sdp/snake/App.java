package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.BotGreedySnake;
import ge.edu.freeuni.sdp.snake.model.CompositePopulator;
import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.EscapeMousePopulator;
import ge.edu.freeuni.sdp.snake.model.GreedySnakeFactory;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.MovingMousePopulator;
import ge.edu.freeuni.sdp.snake.model.MovingPoisonBeing;
import ge.edu.freeuni.sdp.snake.model.MovingPoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.Populator;
import ge.edu.freeuni.sdp.snake.model.SimpleSnakeFactory;
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
				new SingleMousePopulator(),
				new SimpleSnakeFactory());
		
		Populator[] array = {new MovingMousePopulator(),new MovingPoisonPopulator()};
		Level level2 = new Level(
				"Moving Poison & Mouse Level", 
				new SphericTopology(),
				new CompositePopulator(array),
				new SimpleSnakeFactory());

		//TODO Add other levels here
		
		Level level3 = new Level(
				"Swap sides",
				new SphericTopology(),
				new EscapeMousePopulator(),
				new GreedySnakeFactory());
		
		levels.add(level1);
		levels.add(level2);
		levels.add(level3);

		Configuration.init(size, levels);
		
		
		SwingViewFactory viewFactory = new SwingViewFactory();
		ViewController controller = new ViewController(viewFactory);
		controller.run();
		
	}
}