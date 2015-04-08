package ge.edu.freeuni.sdp.snake.model;

public class MovingMousePopulator extends RandomPositionPopulator{
	private MovingMouseBeing mouse;

	@Override
	public void populate(Universe universe) {
		if (mouse == null || !mouse.isAlive()) {
			Point point = getRandomUnocupied(universe);
			mouse = new MovingMouseBeing(point);
			universe.addBeing(mouse);
		}
	}

}
