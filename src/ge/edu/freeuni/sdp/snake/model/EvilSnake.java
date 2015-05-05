package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.BoardSize;

import java.util.Random;

import com.google.inject.Inject;

public class EvilSnake extends Snake {

	protected long lastMove;
	
	private Random _random;
	
	private Clock _clock;
	
	@Inject
	public EvilSnake(@BoardSize Size size, Random random, Clock clock) {
		super(size);
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