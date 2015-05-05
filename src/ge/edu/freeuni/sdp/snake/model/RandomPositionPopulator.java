package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.BoardSize;

import java.util.Random;

import com.google.inject.Inject;

/*
 * A base class for any populator which requires finding a random empty cell
 * in the universe.
 */
public abstract class RandomPositionPopulator implements Populator {

	private Random _random;
	protected Size _size;

	@Inject
	public RandomPositionPopulator(@BoardSize Size size, Random random) {
		_size = size;
		_random = random;
	}

	@Override
	public abstract void populate(Universe universe);

	/*
	 * Finds by probing a random cell which is unoccupied
	 */
	protected Point getRandomUnocupied(Universe universe) {
		while (true) {
			int randomX = _random.nextInt(_size.getWidth());
			int randomY = _random.nextInt(_size.getHeight());
			Point candidate = new Point(randomX, randomY);
			if (universe.getBeingAt(candidate) == null)
				return candidate;
		}
	}
}