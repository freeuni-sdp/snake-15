package ge.edu.freeuni.sdp.snake.model;

public class ObservableMouseBeing extends MovingMouseBeing implements DirectionObserver {

	private PositionObserver positionObserver;

	public ObservableMouseBeing(Point point) {
		this(point,Direction.RIGHT);
	}
	
	public ObservableMouseBeing(Point point, Direction direction) {
		super(point);
		setDirection(direction);
	}
	
	@Override
	protected void moveTo(Point point) {
		super.moveTo(point);
		if (positionObserver!=null) {
			positionObserver.notifyMoveTo(point);
		}
	}
	
	public void setPositionObserver(PositionObserver positionObserver) {
		this.positionObserver = positionObserver;
		
	}
	
	@Override
	public void notifyDirectionSet(Direction direction) {
		setDirection(direction);
	}
	
}
