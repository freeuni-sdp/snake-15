package ge.edu.freeuni.sdp.snake.model;

/**
 * Hides inner structure of model from presenter and provides simplified
 * interface to it.
 * 
 * @author George Mamaladze
 *
 */
public class CommonGameFacade implements GameFacade {

	private Universe _universe;
	private Snake _snake;
	private Populator _populator;
	private Configuration _configInstance;

	public CommonGameFacade(Universe universe, Snake snake,
			Populator populator, Configuration configInstance) {
		init(universe, snake, populator, configInstance);
	}

	public CommonGameFacade() {
		Configuration config = Configuration.getInstance();
		Level level = Configuration.getInstance().getSelectedLevel();
		Topology topology = level.getTopology();

		Point snakeHead = new Point(config.getSize().getWidth() / 2, config
				.getSize().getHeight() / 2);

		init(new Universe(topology), level.getSnake(snakeHead),
				level.getFoodGenerator(), config);
	}

	private void init(Universe universe, Snake snake, Populator populator,
			Configuration configInstance) {
		_universe = universe;
		_populator = populator;
		_snake = snake;
		_universe.addBeing(snake);
		_configInstance = configInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getLives()
	 */
	@Override
	public int getLives() {
		return _snake.getLives();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ge.edu.freeuni.sdp.snake.model.GameFacade#getBeingKindAt(ge.edu.freeuni
	 * .sdp.snake.model.Point)
	 */
	@Override
	public BeingKind getBeingKindAt(Point point) {
		Being being = _universe.getBeingAt(point);
		if (being == null)
			return BeingKind.None;
		return being.getKind();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ge.edu.freeuni.sdp.snake.model.GameFacade#makeMove(ge.edu.freeuni.sdp
	 * .snake.model.Direction)
	 */
	@Override
	public void makeMove(Direction direction) {
		_snake.setDirection(direction);
		_universe.move();
		_universe.interact();
		_universe.removeZombies();
		_populator.populate(_universe);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return !_snake.isAlive();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getSize()
	 */
	@Override
	public Size getSize() {
		return _configInstance.getSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getScore()
	 */
	@Override
	public int getScore() {
		return _snake.getLength();
	}

	protected Point getSnakeHead() {
		return _snake.getHead();
	}

	@Override
	public void saveState() {
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(_snake.saveToMemento());
	}

	@Override
	public void restoreState() {
		Caretaker caretaker = new Caretaker();
		_snake.restoreFromMemento(caretaker.getMemento());
	}
}
