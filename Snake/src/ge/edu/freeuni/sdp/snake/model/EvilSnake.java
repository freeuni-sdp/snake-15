package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class EvilSnake extends Snake {

	protected long lastMove;
	private Direction [] array = {Direction.LEFT,Direction.RIGHT,Direction.UP,Direction.DOWN};
	
	public EvilSnake(Point head) {
		super(head);
	}
	
	@Override
	protected void moveTo(Point point){
		_body.addFirst(point);
		trim();
		long currentTime = System.currentTimeMillis();
		if (currentTime-lastMove >= 5*1000){
			setRandomDirection();
			lastMove = currentTime;
		}
	}

	private void setRandomDirection(){
		Random random = new Random();
		int index = random.nextInt(4);
		this.setDirection(array[index]);
	}

}
