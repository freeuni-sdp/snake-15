package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public abstract class GhostBeing extends Being {

	private Point _point;
	private Random _random;
	private SystemTime systemTime;
	
	public GhostBeing(Point point) {
		this(1, point, new Random(), new SystemTime());
	}
	
	public GhostBeing(int numLives, Point point, Random random, SystemTime systemTime) {
		super(numLives);
		_point = point;
		_random = random;
		this.systemTime = systemTime;
		this.systemTime.setPreviousTime(systemTime.getCurrentTime());
	}

	@Override
	public boolean contains(Point point) {
		return point.equals(_point);
	}

	@Override
	public Point getHead() {
		return _point;
	}

	@Override
	public void move(Topology topology) {
		move(topology, systemTime, Configuration.getInstance());
	}

	public void move(Topology topology, SystemTime systemTime, Configuration config) {
		long currTime = systemTime.getCurrentTime();
		if(currTime - systemTime.getPreviousTime() < (_random.nextInt(10)+5)*1000) {
			return;
		}
		int randomX = _random.nextInt(config.getSize().getWidth());
		int randomY = _random.nextInt(config.getSize().getHeight());
		Point candidate = new Point(randomX, randomY);
		systemTime.setPreviousTime(currTime);
		setPosition(candidate);
	}

	@Override
	public void setDirection(Direction direction) {
	}

	private void setPosition(Point point) {
		_point = point;
	}

}