package ge.edu.freeuni.sdp.snake.model;

/**
 * Hides inner structure of model from presenter and provides 
 * simplified interface to it.
 * @author George Mamaladze
 *
 */
public class GameFacade {

	private Universe _universe;
	private Snake _snake;
	private Populator _populator;

	public GameFacade() {
		Configuration config = Configuration.getInstance();
		Level level = Configuration.getInstance().getSelectedLevel();
		Topology topology = level.getTopology();
		_populator = level.getFoodGenerator();
		_universe = new Universe(topology);

		Point snakeHead = new Point(
				config.getSize().getWidth() / 2,
				config.getSize().getHeight() / 2);
		_snake = new ThreeLivesSnake(snakeHead);
		_universe.addBeing(_snake);
	}

	public int getLives(){
		return _snake.getLives();
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
		_populator.populate(_universe);
	}

	public boolean isGameOver() {
		return !_snake.isAlive();
	}
	
	public Size getSize() {
		return Configuration.getInstance().getSize();
	}
}
