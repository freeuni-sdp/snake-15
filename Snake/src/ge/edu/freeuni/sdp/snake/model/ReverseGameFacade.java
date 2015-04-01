package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class ReverseGameFacade extends GameFacade{
	
	private Universe _universe;
	private Snake _snake;
	private Populator _populator;
	private ObservableMovingBeing _being;
	private Random _random;
	
	public ReverseGameFacade() {
	//	RandomPositionPopulator rand = new RandomPositionPopulator(new Random());
		_being = new EscapingMouse(new Point(2,2));
		Configuration config = Configuration.getInstance();
		Level level = Configuration.getInstance().getSelectedLevel();
		Topology topology = level.getTopology();
		_populator = level.getFoodGenerator();
		_universe = new Universe(topology);
		Point snakeHead = new Point(
				config.getSize().getWidth() / 2,
				config.getSize().getHeight() / 2);
                _snake = level.getSnake(snakeHead);
		_universe.addBeing(_snake);
		
	}
	
	@Override
	public void makeMove(Direction direction) {
	
		_being.setDirection(direction);	
		_universe.move();
		_universe.interact();
		_universe.removeZombies();
		_populator.populate(_universe);
	
	}
	
	
}
