package ge.edu.freeuni.sdp.snake.model;

public class GreedySnakeFactory implements SnakeFactory {

	@Override
	public Snake createSnake(Point head) {
	
		return (new BotGreedySnake(head));
		
	}
	
	
	
}
