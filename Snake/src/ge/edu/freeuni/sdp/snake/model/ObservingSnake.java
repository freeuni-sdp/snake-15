package ge.edu.freeuni.sdp.snake.model;

public abstract class ObservingSnake extends Snake {

	public ObservingSnake(Point head) {
		
		super(head);
		
	}
	
	public abstract void update(Point point);
	
}
