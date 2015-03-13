package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.Configuration;

public class SphericTopology extends EndlessTopology {

	@Override
	public Point getNextTo(Point point, Direction direction) {
		Configuration config = Configuration.getInstance();
		Point result = super.getNextTo(point, direction);
		return new Point(
				mod(result.X, config.getSize().getWidth()), 
				mod(result.Y, config.getSize().getHeight()));
	}

	private static int mod(int x, int n) {
		int r = x % n;
		if (r < 0) {
			r += n;
		}
		return r;
	}
}
