package ge.edu.freeuni.sdp.snake.model;

public abstract class ObservableMovingBeing extends MovingBeing {
	
	protected abstract void moveTo(Point point);

	public abstract void register(ObservingSnake observer);
	public abstract void unregister(ObservingSnake observer);
	public abstract void notification();
	
}
