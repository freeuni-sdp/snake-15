package ge.edu.freeuni.sdp.snake.model;

public class GhostPoisonBeing extends GhostBeing{
	
	public GhostPoisonBeing(Point point){
		super(point);
	}
	
	@Override
	public BeingKind getKind() {
		return BeingKind.FoodPoison;
	}

	@Override
	public void interactWith(Being other) {
		other.kill();
	}
}
