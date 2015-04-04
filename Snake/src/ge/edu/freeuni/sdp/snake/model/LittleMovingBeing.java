package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public abstract class LittleMovingBeing extends MovingBeing{
	private Point point;
	private long lastChange;
	
	public LittleMovingBeing(Point point) {
		this.point = point;
		setRandomDirection();
		lastChange = System.currentTimeMillis();
	}
	
	private void setRandomDirection() {
		Random random = new Random();
		Direction [] array = {Direction.LEFT,Direction.RIGHT,Direction.UP,Direction.DOWN};
		int index = random.nextInt(4);
	    setDirection(array[index]);
	}
	
	@Override
	protected void moveTo(Point point) {
		this.point = point;
		long currentTime = System.currentTimeMillis();
		if (currentTime-lastChange >= 5*1000){
			setRandomDirection();
			lastChange = currentTime;
		}
	}

	@Override
	public boolean contains(Point point) {
		return this.point.equals(point);
	}

	@Override
	public Point getHead() {
		return this.point;
	}
}
