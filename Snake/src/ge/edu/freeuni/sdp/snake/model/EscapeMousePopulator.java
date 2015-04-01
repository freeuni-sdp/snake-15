package ge.edu.freeuni.sdp.snake.model;

public class EscapeMousePopulator extends RandomPositionPopulator {
	
	private EscapingMouse _mouse;

	
	public void populate(Universe universe, ObservableMovingBeing being) {
		
		if (_mouse == null || !_mouse.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_mouse = new EscapingMouse(point);
			being = _mouse;
			universe.addBeing(_mouse);
		}
		
	}


	@Override
	public void populate(Universe universe) {
		
		if (_mouse == null || !_mouse.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_mouse = new EscapingMouse(point);
			universe.addBeing(_mouse);
		}
		
	}

}
