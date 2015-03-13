package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.Configuration;

public class GameFacade {

	private Universe _universe;
	private Snake _snake;
	private Populator _foodGenerator;

	public GameFacade() {
		Configuration config = Configuration.getInstance();
		Level level = Configuration.getInstance().getSelectedLevel();
		Topology topology = level.getTopology();
		_foodGenerator = level.getFoodGenerator();
		_universe = new Universe(topology);

		Point snakeHead = new Point(config.getWidth() / 2,
				config.getHeight() / 2);
		_snake = new Snake(snakeHead);
		_universe.addBeing(_snake);
	}

	public BeingKind getBeingKindAt(Point point) {
		Being being = _universe.getBeingAt(point);
		if (being == null)
			return BeingKind.None;
		return being.getKind();
	}

	public void makeMove(Direction direction) {
		_snake.setDirection(direction);
		_universe.move();
		_universe.interact();
		_universe.removeZombies();
		_foodGenerator.populate(_universe);
	}

	public boolean isGameOver() {
		return !_snake.isAlive();
	}
}
