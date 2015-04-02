package ge.edu.freeuni.sdp.snake.model;

public class WormHolePopulator extends RandomPositionPopulator {
	
	private static Point firstHole;
	private static Point secondHole;
	private boolean firstTime = true;
	private MouseBeing _mouse;
	
	
	@Override
	public void populate(Universe universe) {
		// TODO Auto-generated method stub
		if (firstTime){
			firstHole = getRandomUnocupied(universe);
			secondHole = getRandomUnocupied(universe);
			firstTime = false;
			changePoints();
		}
		
		surroundWithPoisons(universe);
			
		if (_mouse == null || !_mouse.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_mouse = new MouseBeing(point);
			universe.addBeing(_mouse);
		}
		
	}
	
	
	private  void changePoints(){
		if(firstHole.X > secondHole.X){
			Point temp = firstHole;
			firstHole = secondHole;
			secondHole = temp;
		}
	}
	
	private void surroundWithPoisons(Universe universe){
		
		PoisonBeing p1 = new PoisonBeing(new Point (firstHole.X+1,firstHole.Y));
		universe.addBeing(p1);
		PoisonBeing p2 = new PoisonBeing(new Point (firstHole.X,firstHole.Y-1));
		universe.addBeing(p2);
		PoisonBeing p3 = new PoisonBeing(new Point (firstHole.X,firstHole.Y + 1));
		universe.addBeing(p3);
		PoisonBeing p4 = new PoisonBeing(new Point (firstHole.X+1,firstHole.Y-1));
		universe.addBeing(p4);
		PoisonBeing p5 = new PoisonBeing(new Point (firstHole.X+1,firstHole.Y+1));
		universe.addBeing(p5);
		PoisonBeing p6 = new PoisonBeing(new Point (secondHole.X-1,secondHole.Y));
		universe.addBeing(p6);
		PoisonBeing p7 = new PoisonBeing(new Point (secondHole.X-1,secondHole.Y-1));
		universe.addBeing(p7);
		PoisonBeing p8 = new PoisonBeing(new Point (secondHole.X-1,secondHole.Y+1));
		universe.addBeing(p8);
		PoisonBeing p9 = new PoisonBeing(new Point (secondHole.X,secondHole.Y-1));
		universe.addBeing(p9);
		PoisonBeing p10 = new PoisonBeing(new Point (secondHole.X,secondHole.Y+1));
		universe.addBeing(p10);
	}
	
	public static Point getFirst(){
		return firstHole;
	}
	
	public static Point getSecond(){
		return secondHole;
	}

}
