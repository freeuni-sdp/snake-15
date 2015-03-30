package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class EvilSnakePopulator extends RandomPositionPopulator{

	private EvilSnake _snake;
	private Direction [] array = {Direction.LEFT,Direction.RIGHT,Direction.UP,Direction.DOWN};
	
	@Override
	public void populate(Universe universe) {
		if (_snake == null || !_snake.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_snake = new EvilSnake(point);
			setRandomDirection();
			universe.addBeing(_snake);
		}
	}
	
	private void setRandomDirection(){
		Random random = new Random();
		int index = random.nextInt(4);
		_snake.setDirection(array[index]);
	}
}
