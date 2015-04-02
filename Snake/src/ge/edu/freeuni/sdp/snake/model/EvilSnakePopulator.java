package ge.edu.freeuni.sdp.snake.model;

public class EvilSnakePopulator extends RandomPositionPopulator{

	private EvilSnake _snake;
	
	@Override
	public void populate(Universe universe) {
		if (_snake == null || !_snake.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_snake = new EvilSnake(point);
			universe.addBeing(_snake);
		}
	}
}
