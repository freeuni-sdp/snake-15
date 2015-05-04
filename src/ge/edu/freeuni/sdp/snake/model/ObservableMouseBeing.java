package ge.edu.freeuni.sdp.snake.model;

public class ObservableMouseBeing extends MovingMouseBeing implements DirectionObserver {

	private PositionObserver positionObserver;

	public ObservableMouseBeing(Point point) {
		super(point);
		setDirection(Direction.RIGHT);
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
