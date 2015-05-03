package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class EvilSnake extends Snake {

	protected long lastMove;
	private Random _random;
	
	public EvilSnake(Point head) {
		this(head, new Random());
	}
	
	public EvilSnake(Point head, Random random) {
		super(head);
		_random = random;
		setDirection(Direction.LEFT);
	}
	
	@Override
	protected void moveTo(Point point){
		boolean isTimeToChangeDirection = Clock.getInstance().currentTimeMillis() - lastMove >= 5*1000;
		if (isTimeToChangeDirection){
			setRandomDirection();
			lastMove = Clock.getInstance().currentTimeMillis();
		}
		super.moveTo(point);
	}

	public void setRandomDirection() {
		Direction currentDirection = this.getDirection();
		Direction newDirection = currentDirection.getNextRandomDirection(_random);
		this.setDirection(newDirection);
	}
}