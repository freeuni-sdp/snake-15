package ge.edu.freeuni.sdp.snake.model;

public class MovingPoisonPopulator extends RandomPositionPopulator{
	private MovingPoisonBeing poison;
	
	@Override
	public void populate(Universe universe) {
		if (poison == null) {
			Point point = getRandomUnocupied(universe);
			poison = new MovingPoisonBeing(point);
			universe.addBeing(poison);
		}
	}

}
