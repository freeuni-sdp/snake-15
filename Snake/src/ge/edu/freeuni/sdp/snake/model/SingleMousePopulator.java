package ge.edu.freeuni.sdp.snake.model;

/*
 * This populator ensures one living mouse at a time at a random point
 */
public class SingleMousePopulator extends RandomPositionPopulator {

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
