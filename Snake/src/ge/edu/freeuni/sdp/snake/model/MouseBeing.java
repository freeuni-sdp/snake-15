package ge.edu.freeuni.sdp.snake.model;

public class MouseBeing extends FixedBeing {

	public MouseBeing(Point head) {
		super(head);
	}

	@Override
	public BeingKind getKind() {
		return BeingKind.FoodMouse;
	}

	@Override
	public void interactWith(Being current) {

	}
}
