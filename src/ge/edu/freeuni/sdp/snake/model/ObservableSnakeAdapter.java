package ge.edu.freeuni.sdp.snake.model;

public class ObservableSnakeAdapter extends Snake implements PositionObserver {

	private DirectionObserver directionObserver;

	public ObservableSnakeAdapter(Point head) {
		this(head,Direction.RIGHT);
	}
	
	public ObservableSnakeAdapter(Point head, Direction direction) {
		super(head);
		super.setDirection(direction);
	}
	
	@Override
	public void setDirection(Direction direction) {
		if (directionObserver!=null) {
			directionObserver.notifyDirectionSet(direction);
		}
	}
	
	public void setDirectionObserver(DirectionObserver directionObserver) {
		this.directionObserver = directionObserver;
	}

	@Override
	public void notifyMoveTo(Point point) {
		Point from = this.getHead();
		Point to = point;
		Direction direction = Direction.getDirection(from, to);
		super.setDirection(direction);
	}

}
 