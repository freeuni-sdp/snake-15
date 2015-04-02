package ge.edu.freeuni.sdp.snake.model;

public class WormHoleTopology implements Topology {

	private final RandomWormHole _wormhole;

	public WormHoleTopology(RandomWormHole wormhole) {
		_wormhole = wormhole;
	}

	@Override
	public Point getNextTo(Point point, Direction direction) {
		Point left = _wormhole.getLeft();
		Point right = _wormhole.getRight();
		Point tempPoint;
		if (point.equals(left)) {
			tempPoint = new Point(right.X + 1, right.Y);
		} else if (point.equals(right)) {
			tempPoint = new Point(left.X - 1, left.Y);
		} else {
			tempPoint = new SphericTopology().getNextTo(point, direction);
		}

		return tempPoint;
	}
}
