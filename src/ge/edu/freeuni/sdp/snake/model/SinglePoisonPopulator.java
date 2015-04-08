package ge.edu.freeuni.sdp.snake.model;

public class SinglePoisonPopulator extends RandomPositionPopulator {

	private PoisonBeing _poison;

	@Override
	public void populate(Universe universe) {
		if (_poison == null || !_poison.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_poison = new PoisonBeing(point);
			universe.addBeing(_poison);
		}
	}
}