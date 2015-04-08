package ge.edu.freeuni.sdp.snake.model;

public class GhostPoisonPopulator extends RandomPositionPopulator {
	
	private GhostPoisonBeing _poison;
	
	@Override
	public void populate(Universe universe) {
		if (_poison == null || !_poison.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_poison = new GhostPoisonBeing(point);
			universe.addBeing(_poison);
		}
	}

}
