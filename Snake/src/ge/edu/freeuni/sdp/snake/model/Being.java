package ge.edu.freeuni.sdp.snake.model;

public abstract class Being {

	boolean _isAlive = true;

	public abstract BeingKind getKind();

	public final boolean isAlive() {
		return _isAlive;
	}

	public final void kill() {
		_isAlive = false;
	}

	public abstract void interactWith(Being other);

	public abstract boolean contains(Point point);

	public abstract Point getHead();

	public abstract void move(Topology topology);

	public abstract void setDirection(Direction direction);
}
