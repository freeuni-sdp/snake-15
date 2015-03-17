package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

/*
 * A base class for any populator which requires finding a random empty cell
 * in the universe.
 */
public abstract class RandomPositionPopulator implements Populator {

	private Random _random;

	public RandomPositionPopulator() {
		this(new Random());
	}

	/*
	 * This constructor is required to avoid randomness in tests
	 */
	public RandomPositionPopulator(Random random) {
		_random = random;
	}

	@Override
	public abstract void populate(Universe universe);

	/*
	 * Finds by probing a random cell which is unoccupied
	 */
	protected Point getRandomUnocupied(Universe universe) {
		while (true) {
			Configuration config = Configuration.getInstance();
			int randomX = _random.nextInt(config.getSize().getWidth());
			int randomY = _random.nextInt(config.getSize().getHeight());
			Point candidate = new Point(randomX, randomY);
			if (universe.getBeingAt(candidate) == null)
				return candidate;
		}
	}
}