package ge.edu.freeuni.sdp.snake.model;

public interface Topology {
	Point getNextTo(Point point, Direction direction);
}
