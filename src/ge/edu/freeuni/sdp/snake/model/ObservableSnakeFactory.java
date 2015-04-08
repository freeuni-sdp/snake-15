package ge.edu.freeuni.sdp.snake.model;

public class ObservableSnakeFactory implements SnakeFactory {

	private Snake instance; 
	
	@Override
	public Snake createSnake(Point head) {
		if (instance == null) {
			instance = new ObservableSnakeAdapter(head);
		}
		return instance;
	}
}
