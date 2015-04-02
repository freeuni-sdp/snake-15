package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class GhostMouseBeing extends Being{
	
	private Point _point;
	private long prevTime;
	Random random;
	public GhostMouseBeing(Point point){
		prevTime = System.currentTimeMillis();
		_point = point;
		random = new Random();
	}
	
	@Override
	public BeingKind getKind() {
		// TODO Auto-generated method stub
		return BeingKind.FoodMouse;
	}

	@Override
	public void interactWith(Being other) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return point.equals(_point);
	}

	@Override
	public Point getHead() {
		// TODO Auto-generated method stub
		return _point;
	}

	@Override
	public void move(Topology topology) {
		long currTime = System.currentTimeMillis();
		if(currTime - prevTime >= (random.nextInt(10)+5)*1000){
			Configuration config = Configuration.getInstance();
			int randomX = random.nextInt(config.getSize().getWidth());
			int randomY = random.nextInt(config.getSize().getHeight());
			Point candidate = new Point(randomX, randomY);
			prevTime = currTime;
			setPosition(candidate);
		}
	}

	@Override
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		
	}

	public void setPosition(Point point){
		_point = point;
	}

}
