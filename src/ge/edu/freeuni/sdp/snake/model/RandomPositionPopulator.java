package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

/*
 * A base class for any populator which requires finding a random empty cell
 * in the universe.
 */
public abstract class RandomPositionPopulator implements Populator {

	private Random _random;
	private Configuration _configuration;
	
	public RandomPositionPopulator() {
		this(new Random());
	}
	

	/*
	 * This constructor is required to avoid randomness in tests
	 */
	public RandomPositionPopulator(Random random) {
		_random = random;
	}
 
	public RandomPositionPopulator(Random random, Configuration configuration){
		_configuration = configuration;
		_random = random;
	}
	
	private Configuration getConfig() {
		if (_configuration==null) {
			return Configuration.getInstance();
		} else {
			return _configuration;
		}
	}
	
	@Override
	public abstract void populate(Universe universe);

	/*
	 * Finds by probing a random cell which is unoccupied
	 */
	protected Point getRandomUnocupied(Universe universe) {
		while (true) {
			Configuration config = getConfig();
			int randomX = _random.nextInt(config.getSize().getWidth());
			int randomY = _random.nextInt(config.getSize().getHeight());
			Point candidate = new Point(randomX, randomY);
			if (universe.getBeingAt(candidate) == null)
				return candidate;
		}
	}
}