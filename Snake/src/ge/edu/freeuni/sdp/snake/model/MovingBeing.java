package ge.edu.freeuni.sdp.snake.model;

public abstract class MovingBeing extends Being {

	private Direction _direction;

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
}
