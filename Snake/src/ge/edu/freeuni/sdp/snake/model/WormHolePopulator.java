package ge.edu.freeuni.sdp.snake.model;

public class WormHolePopulator extends RandomPositionPopulator {
	
	private final RandomWormHole _wormhole;


	public WormHolePopulator(RandomWormHole wormhole) {
		_wormhole = wormhole;
	}
	
	private boolean _isSurrounded;
	
	
	@Override
	public void populate(Universe universe) {
		if (!_isSurrounded){
			surroundWithPoisons(universe);
			_isSurrounded = true;
		}
	}
	
	private void surroundWithPoisons(Universe universe){
		
		Point left = _wormhole.getLeft();
		Point right = _wormhole.getRight();
		
		PoisonBeing p1 = new PoisonBeing(new Point (left.X+1,left.Y));
		universe.addBeing(p1);
		PoisonBeing p2 = new PoisonBeing(new Point (left.X,left.Y-1));
		universe.addBeing(p2);
		PoisonBeing p3 = new PoisonBeing(new Point (left.X,left.Y + 1));
		universe.addBeing(p3);
		PoisonBeing p4 = new PoisonBeing(new Point (left.X+1,left.Y-1));
		universe.addBeing(p4);
		PoisonBeing p5 = new PoisonBeing(new Point (left.X+1,left.Y+1));
		universe.addBeing(p5);
		PoisonBeing p6 = new PoisonBeing(new Point (right.X-1,right.Y));
		universe.addBeing(p6);
		PoisonBeing p7 = new PoisonBeing(new Point (right.X-1,right.Y-1));
		universe.addBeing(p7);
		PoisonBeing p8 = new PoisonBeing(new Point (right.X-1,right.Y+1));
		universe.addBeing(p8);
		PoisonBeing p9 = new PoisonBeing(new Point (right.X,right.Y-1));
		universe.addBeing(p9);
		PoisonBeing p10 = new PoisonBeing(new Point (right.X,right.Y+1));
		universe.addBeing(p10);
	}
}