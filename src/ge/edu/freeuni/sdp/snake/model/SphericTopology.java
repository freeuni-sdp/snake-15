package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;


public class SphericTopology extends EndlessTopology {

	private Configuration _configuration;

	public SphericTopology() {
		this(null);
	}

	public SphericTopology(Configuration config) {
		_configuration = config;
	}
	
	private Configuration getConfig() {
		if (_configuration == null) {
			return Configuration.getInstance();
		} else {
			return _configuration;
		}
	}
	
	@Override
	public Point getNextTo(Point point, Direction direction) {
		Point result = super.getNextTo(point, direction);
		return new Point(
				mod(result.X, getConfig().getSize().getWidth()), 
				mod(result.Y, getConfig().getSize().getHeight()));
	}

	private static int mod(int x, int n) {
		int r = x % n;
		if (r < 0) {
			r += n;
		}
		return r;
	}
}
