package ge.edu.freeuni.sdp.snake.model;

/*
 * Base class for any being able to move.
 */
public abstract class MovingBeing extends Being {

	private Direction _direction;
	
	MovingBeing() {
		this(1);
	}
	
	MovingBeing(int lives) {
		super(lives);
	}

	@Override
	public final void move(Topology topology) {
		Point head = getHead();
		Point target = topology.getNextTo(head, _direction);
		moveTo(target);
	}

	protected abstract void moveTo(Point point);

	@Override
	public final void setDirection(Direction direction) {
		_direction = direction;
	}
	
	protected final Direction getDirection() {
		return _direction;
	}
}
