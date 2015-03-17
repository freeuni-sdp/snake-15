package ge.edu.freeuni.sdp.snake.model;

/*
 * Mouse can be eaten by snake. This mouse is fixed to it's initial position.
 */
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
