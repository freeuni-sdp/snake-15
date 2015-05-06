package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

public class GhostMousePopulator extends RandomPositionPopulator {
	
	private GhostBeing _poison;
	
	public GhostMousePopulator(){
		super();
	}
	
	public GhostMousePopulator(Random random, Configuration configuration) {
		super(random,configuration);
	}


	@Override
	public void populate(Universe universe) {
		if (_poison == null || !_poison.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_poison = new GhostMouseBeing(point);
			universe.addBeing(_poison);
		}
	}
	
}
