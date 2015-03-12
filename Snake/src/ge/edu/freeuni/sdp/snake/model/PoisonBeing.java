package ge.edu.freeuni.sdp.snake.model;

public class PoisonBeing extends FixedBeing {

	public PoisonBeing(Point head) {
		super(head);
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
