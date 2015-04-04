package ge.edu.freeuni.sdp.snake.model;

public class ClippedGameFacade extends CommonGameFacade {

	private Size size;

	public ClippedGameFacade(Size clipSize) {
		super();
		this.size = clipSize;
	}
	
	
	@Override
	public Size getSize() {
		return size;
	}

	@Override
	public BeingKind getBeingKindAt(Point point) {
		Point center = getSnakeHead();
		int realX = (point.X + center.X - size.getWidth() / 2) % super.getSize().getWidth();
		int realY = (point.Y + center.Y - size.getHeight() / 2)  % super.getSize().getHeight();
		
		Point realPoint = new Point(realX, realY);
		return super.getBeingKindAt(realPoint);
	}
}
