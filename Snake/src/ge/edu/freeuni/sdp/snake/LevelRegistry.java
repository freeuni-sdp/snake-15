package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.CompositePopulator;
import ge.edu.freeuni.sdp.snake.model.EvilSnakePopulator;
import ge.edu.freeuni.sdp.snake.model.GhostMousePopulator;
import ge.edu.freeuni.sdp.snake.model.GhostPoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.HungrySnakeFactory;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.MovingMousePopulator;
import ge.edu.freeuni.sdp.snake.model.MovingPoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.Populator;
import ge.edu.freeuni.sdp.snake.model.RandomWormHole;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.SinglePoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.model.ThreeLivesSnakeFactory;
import ge.edu.freeuni.sdp.snake.model.WormHolePopulator;
import ge.edu.freeuni.sdp.snake.model.WormHoleTopology;

import java.util.ArrayList;
import java.util.List;

public class LevelRegistry {
	
	public static List<Level> getLevels() {
		List<Level> levels = new ArrayList<Level>();

		Level levelVerySimple = new Level(
				"Very simple",
				"Mice appair one by one on random positions.",
				new SphericTopology(),
				new SingleMousePopulator());

		Populator[] array = {new MovingMousePopulator(),new MovingPoisonPopulator()};
		Level levelMoving = new Level(
					"Moving Poison & Mouse", 
					new SphericTopology(),
					new CompositePopulator(array));		
	
		Level levelPoisonFood = new Level(
				"Poison food", 
				"Snake has three lives.",
				new SphericTopology(),
				new SinglePoisonPopulator(),
				new ThreeLivesSnakeFactory());

		Level levelHungrySnake = new Level(
				"Hungry snake",
				"Snake will shrink if it will get no food during 10 moves.",
				new SphericTopology(),
				new SingleMousePopulator(),
				new HungrySnakeFactory() );

		Level levelGhostMouse = new Level(
				"Ghost mouse and poison", 
				new SphericTopology(),
				new CompositePopulator(
						new Populator[] {
								new GhostMousePopulator(), 
								new GhostPoisonPopulator()}));

		RandomWormHole wormhole = new RandomWormHole();
		Level levelWormhole = new Level(
				"Wormhole", 
				new WormHoleTopology(wormhole),
				new CompositePopulator(
						new Populator[] {
								new SingleMousePopulator(), 
								new WormHolePopulator(wormhole)}));

		Level levelEvilSnake = new Level(
				"Evil snake", 
				new SphericTopology(),
				new CompositePopulator(
						new Populator[] {
								new SingleMousePopulator(), 
								new EvilSnakePopulator()}));

		levels.add(levelVerySimple);
		levels.add(levelMoving);
		levels.add(levelPoisonFood);
		levels.add(levelHungrySnake);
		levels.add(levelGhostMouse);
		levels.add(levelWormhole);
		levels.add(levelEvilSnake);
		return levels;
	}
}
