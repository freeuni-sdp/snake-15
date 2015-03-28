package ge.edu.freeuni.sdp.snake.model;

/*
 * Base class for any being able to move.
 */
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
	
	@Override
	public boolean isConnected(Object obj){
		return getHead().equals(((Being)obj).getHead()) || (getHead().equals(((Being)obj).getNeck()) && 
				getNeck().equals(((Being)obj).getHead()));
	}
}
