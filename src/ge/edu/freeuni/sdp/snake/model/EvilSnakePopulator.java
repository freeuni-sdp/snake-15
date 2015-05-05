package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.BoardSize;

import java.util.Random;

import com.google.inject.Inject;

public class EvilSnakePopulator extends RandomPositionPopulator{

	@Inject
	public EvilSnakePopulator(EvilSnake snake, @BoardSize Size size, Random random) {
		super(size, random);
		_snake = snake;
	}

	private EvilSnake _snake;
	
	@Override
	public void populate(Universe universe) {
		if (_snake == null || !_snake.isAlive()) {
			universe.addBeing(_snake);
		}
	}
}
