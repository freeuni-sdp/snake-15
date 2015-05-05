package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.BoardSize;

import com.google.inject.Inject;


public class SphericTopology extends EndlessTopology {

	@Inject @BoardSize
	private Size _size;

	@Override
	public Point getNextTo(Point point, Direction direction) {
		Point result = super.getNextTo(point, direction);
		return new Point(
				mod(result.X, _size.getWidth()), 
				mod(result.Y, _size.getHeight()));
	}

	private static int mod(int x, int n) {
		int r = x % n;
		if (r < 0) {
			r += n;
		}
		return r;
	}
}
