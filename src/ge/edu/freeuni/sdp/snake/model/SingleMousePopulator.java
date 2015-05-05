package ge.edu.freeuni.sdp.snake.model;

import ge.edu.freeuni.sdp.snake.BoardSize;

import java.util.Random;

import com.google.inject.Inject;

/*
 * This populator ensures one living mouse at a time at a random point
 */
public class SingleMousePopulator extends RandomPositionPopulator {

	@Inject
	public SingleMousePopulator(@BoardSize Size size, Random random) {
		super(size, random);
	}

	private MouseBeing _mouse;

	@Override
	public void populate(Universe universe) {
		if (_mouse == null || !_mouse.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_mouse = new MouseBeing(point);
			universe.addBeing(_mouse);
		}
	}
}
