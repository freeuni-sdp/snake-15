package ge.edu.freeuni.sdp.snake.model;

public class WormHoleTopology implements Topology {

	@Override
	public Point getNextTo(Point point, Direction direction) {
		
//		Point result = super.getNextTo(point, direction);
		Point firstHole = WormHolePopulator.getFirst();
		Point secondHole = WormHolePopulator.getSecond();
		Point tempPoint;
		if (point.equals(firstHole)){
			tempPoint = new Point(secondHole.X+1,secondHole.Y);
		}else if(point.equals(secondHole)){
			tempPoint = new Point(firstHole.X-1,firstHole.Y);
		}else{
			tempPoint = new SphericTopology().getNextTo(point , direction);
		}

		return tempPoint;
	}




	
}
