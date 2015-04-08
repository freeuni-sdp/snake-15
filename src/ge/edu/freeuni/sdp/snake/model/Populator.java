package ge.edu.freeuni.sdp.snake.model;

/*
 * Classes implementing this interface are responsible for
 * creation of beings at appropriate move and putting them into universe.
 */
public interface Populator {
	/*
	 * This method will be called during every move.
	 * In this method a populator can create a being at put it into universe.
	 */
	void populate(Universe universe);
}