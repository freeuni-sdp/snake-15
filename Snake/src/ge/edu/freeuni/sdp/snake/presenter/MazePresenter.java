package ge.edu.freeuni.sdp.snake.presenter;


public interface MazePresenter {

	void setCellUpdateListener(CellUpdateListener listener);

	boolean isGameOver();

	void tick(DirectionKey key);

}