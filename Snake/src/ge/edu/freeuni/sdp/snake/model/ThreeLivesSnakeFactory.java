package ge.edu.freeuni.sdp.snake.model;


public class ThreeLivesSnakeFactory implements SnakeFactory {

	@Override
	public Snake createSnake(Point head) {
		return new ThreeLivesSnake(head);
	}

}
