package ge.edu.freeuni.sdp.snake.model;

public class GhostMousePopulator extends RandomPositionPopulator {
	
	private GhostMouseBeing _poison;
	
	@Override
	public void populate(Universe universe) {
		if (_poison == null || !_poison.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_poison = new GhostMouseBeing(point);
			universe.addBeing(_poison);
		}
	}

}
