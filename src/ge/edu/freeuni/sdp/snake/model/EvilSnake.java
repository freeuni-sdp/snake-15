package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class EvilSnake extends Snake {

	protected long lastMove;
	private Random _random;
	private Clock _clock;
	public EvilSnake(Point head) {
		this(head, new Random(),new Clock());
	}

	public EvilSnake(Point head, Random random,Clock clock) {
		super(head);
		_random = random;
		_clock = clock;
		setDirection(Direction.LEFT);
	}
	
	@Override
	protected void moveTo(Point point){
		boolean isTimeToChangeDirection = _clock.currentTimeMillis() - lastMove >= 5*1000;
		if (isTimeToChangeDirection){
			setRandomDirection();
			lastMove = _clock.currentTimeMillis();
		}
		super.moveTo(point);
	}

	public void setRandomDirection() {
		Direction currentDirection = this.getDirection();
		Direction newDirection = currentDirection.getNextRandomDirection(_random);
		this.setDirection(newDirection);
	}
}