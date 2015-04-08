package ge.edu.freeuni.sdp.snake.model;

public class GhostMouseBeing extends GhostBeing{
	
	public GhostMouseBeing(Point point){
		super(point);
	}
	
	@Override
	public BeingKind getKind() {
		return BeingKind.FoodMouse;
	}

	@Override
	public void interactWith(Being other) {
	}
}
