package ge.edu.freeuni.sdp.snake.model;

/**
 * Base class for all actors in this game: food, snakes etc. 
 * Implements only alive or dead functionality.
 */
public abstract class Being {

	boolean _isAlive = true;

	public abstract BeingKind getKind();

	public final boolean isAlive() {
		return _isAlive;
	}

	public final void kill() {
		_isAlive = false;
	}

	/**
	 * This method will be called by the Universe whenever head of
	 * other actor overlaps with any position occupied by this being
	 * During interaction this being is allowed to kill other being.
	 * @param other
	 */
	public abstract void interactWith(Being other);

	/**
	 * Returns true if given point is occupied by being, false otherwise. 
	 * @param point
	 * @return
	 */
	public abstract boolean contains(Point point);

	/**
	 * Returns head. Only head can eat or kill. 
	 * @return
	 */
	public abstract Point getHead();

	/**
	 * Will be called by universe. Being can change it's position inside this method.
	 * According to moving direction set and topology of the universe. 
	 * @param topology
	 */
	public abstract void move(Topology topology);

	/**
	 * Direction will be set only when being must change it's moving direction.
	 * Otherwise being must remember it's previous direction and continue moving 
	 * in that direction whenever move is called.
	 * @param direction
	 */
	public abstract void setDirection(Direction direction);
	
	/**
	 * Checks if being is connected with another (Being)obj and returns true if so.
	 * This boolean value is used to decide, whether to call interactWith. 
	 * @param obj another Being
	 * @return true or false
	 */
	public abstract boolean isConnected(Object obj);
	
	/**
	 * Returns previous head point before current head value.
	 * @return
	 */
	public abstract Point getNeck();
}
