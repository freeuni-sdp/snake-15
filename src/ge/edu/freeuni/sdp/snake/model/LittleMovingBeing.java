package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public abstract class LittleMovingBeing extends MovingBeing {
	private Point point;
	protected long lastMove;
	private Random _random;
	private boolean _slowDownTrigger;

	public LittleMovingBeing(Point head) {
		this(head, new Random());
	}

	public LittleMovingBeing(Point head, Random random) {
		super();
		this.point = head;
		_random = random;
		setDirection(Direction.LEFT);
	}

	@Override
	protected void moveTo(Point point) {
		_slowDownTrigger = !_slowDownTrigger;
		if (_slowDownTrigger) return;
		boolean isTimeToChangeDirection = System.currentTimeMillis() - lastMove >= 5 * 1000;
		if (isTimeToChangeDirection) {
			setRandomDirection();
			lastMove = System.currentTimeMillis();
		}
		this.point=point;
	}

	public void setRandomDirection() {
		Direction currentDirection = this.getDirection();
		Direction newDirection = currentDirection
				.getNextRandomDirection(_random);
		this.setDirection(newDirection);
	}

	@Override
	public boolean contains(Point point) {
		return point.equals(this.point);
	}

	@Override
	public Point getHead() {
		return this.point;
	}
}