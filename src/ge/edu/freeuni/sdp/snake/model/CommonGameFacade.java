package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.BoardSize;

import com.google.inject.Inject;

/**
 * Hides inner structure of model from presenter and provides 
 * simplified interface to it.
 * @author George Mamaladze
 *
 */
public class CommonGameFacade implements GameFacade {

	private Universe _universe;
	private Snake _snake;
	private Populator _populator;
	
	@Inject @BoardSize
	private Size _size;

	@Inject
	public CommonGameFacade(Universe universe, Populator populator, Snake snake) {
		_universe = universe;
		_populator = populator;
		_snake = snake;
		_universe.addBeing(_snake);
	}

	/* (non-Javadoc)
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getLives()
	 */
	@Override
	public int getLives(){
		return _snake.getLives();
	}
	
	/* (non-Javadoc)
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getBeingKindAt(ge.edu.freeuni.sdp.snake.model.Point)
	 */
	@Override
	public BeingKind getBeingKindAt(Point point) {
		Being being = _universe.getBeingAt(point);
		if (being == null)
			return BeingKind.None;
		return being.getKind();
	}

	/* (non-Javadoc)
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#makeMove(ge.edu.freeuni.sdp.snake.model.Direction)
	 */
	@Override
	public void makeMove(Direction direction) {
		_snake.setDirection(direction);
		_universe.move();
		_universe.interact();
		_universe.removeZombies();
		_populator.populate(_universe);
	}

	/* (non-Javadoc)
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return !_snake.isAlive();
	}
	
	/* (non-Javadoc)
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getSize()
	 */
	@Override
	public Size getSize() {
		return _size;
	}
	
	/* (non-Javadoc)
	 * @see ge.edu.freeuni.sdp.snake.model.GameFacade#getScore()
	 */
	@Override
	public int getScore(){
		return _snake.getLength();
	}
	
	protected Point getSnakeHead() {
		return _snake.getHead();
	}
}
