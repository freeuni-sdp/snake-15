package ge.edu.freeuni.sdp.snake.model;

public class MovingPoisonBeing extends LittleMovingBeing{
	

	public MovingPoisonBeing(Point point) {
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
