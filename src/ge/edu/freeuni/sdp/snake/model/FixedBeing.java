package ge.edu.freeuni.sdp.snake.model;

/**
 * Being which can not move and has one fixed position whole life
 * @author George Mamaladze
 *
 */
public abstract class FixedBeing extends Being {

	private final Point _head;

	public FixedBeing(Point head) {
		_head = head;
	}

	@Override
	public final Point getHead() {
		return _head;
	}

	@Override
	public boolean contains(Point point) {
		return point.equals(_head);
	}

	@Override
	public final void move(Topology topology) {
	}

	@Override
	public final void setDirection(Direction direction) {
	}
}