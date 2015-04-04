package ge.edu.freeuni.sdp.snake.model;


public class MovingMouseBeing extends LittleMovingBeing{
	
	public MovingMouseBeing(Point point) {
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
