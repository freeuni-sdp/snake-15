package ge.edu.freeuni.sdp.snake.model;

public interface GameFacade {

	public abstract int getLives();

	public abstract BeingKind getBeingKindAt(Point point);

	public abstract void makeMove(Direction direction);

	public abstract boolean isGameOver();

	public abstract Size getSize();

	public abstract int getScore();

	public abstract void saveState();

	public abstract void restoreState();

}