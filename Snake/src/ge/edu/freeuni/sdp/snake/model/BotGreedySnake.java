package ge.edu.freeuni.sdp.snake.model;

public class BotGreedySnake extends ObservingSnake {

	public BotGreedySnake(Point head) {
		
		super(head);
		
	}

	@Override
	public void update(Point point) {
		
		Point p = this.getHead();
		if(p.X == point.X) {
			if (p.Y < point.Y)
				this.setDirection(Direction.UP);
			else {
				this.setDirection(Direction.DOWN);
			}
		}
		if (p.X < point.X) 
			this.setDirection(Direction.RIGHT);
		else this.setDirection(Direction.LEFT);
		
	}
	

	

}
