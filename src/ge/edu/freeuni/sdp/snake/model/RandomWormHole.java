package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

/*
 * Generates two random points one in the left half of the 
 * board another in the right half. Points are 3 cells away from
 * boundary to allow surrounding them.
 */
public class RandomWormHole {
	
	private Point _left;
	private Point _right;
	private Random _random;
	private Configuration _configuration;

	public RandomWormHole() {
		this(new Random());
	}

	public RandomWormHole(Random random) {
		this(random, null);
	}
	
	public RandomWormHole(Random random, Configuration configuration){
		_random = random;
		_configuration = configuration;
	}

	private void generate() {
		int halfWidth = getConfig().getSize().getWidth() / 2;
		int height = getConfig().getSize().getHeight();

		_left = getRandomInside(3, 3, halfWidth, height-3, _random);
		_right = getRandomInside(halfWidth, 3, 2 * halfWidth -3, height-3, _random);
	}
	
	private Configuration getConfig() {
		if (_configuration==null) {
			return Configuration.getInstance();
		} else {
			return _configuration;
		}
	}
	
	public Point getLeft(){
		if (_left==null) generate();
		return _left;
	}
	
	public Point getRight(){
		if (_right==null) generate();
		return _right;
	}
	
	private static Point getRandomInside(int left, int top, int right, int bottom, Random random) {
		int randomX = left + random.nextInt(right - left);
		int randomY = top + random.nextInt(bottom - top);
		return new Point(randomX, randomY);
	}
}
