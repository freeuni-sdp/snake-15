package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.Configuration;

import java.util.Random;

public abstract class RandomPositionPopulator implements Populator {

	private Random _random;

	public RandomPositionPopulator() {
		this(new Random());
	}

	public RandomPositionPopulator(Random random) {
		_random = random;
	}

	@Override
	public abstract void populate(Universe universe);

	protected Point getRandomUnocupied(Universe universe) {
		while (true) {
			Configuration config = Configuration.getInstance();
			int randomX = _random.nextInt(config.getWidth());
			int randomY = _random.nextInt(config.getHeight());
			Point candidate = new Point(randomX, randomY);
			if (universe.getBeingAt(candidate) == null)
				return candidate;
		}
	}
}