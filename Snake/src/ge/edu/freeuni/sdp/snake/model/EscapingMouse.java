package ge.edu.freeuni.sdp.snake.model;

import java.util.ArrayList;

public class EscapingMouse extends ObservableMovingBeing {
	
	private ArrayList<ObservingSnake> observers;
	private Point position;
	private Point previousPoint;
	
	public EscapingMouse(Point head) {
		
	//	this.setDirection(Direction.RIGHT);
		previousPoint = head;
		position = head;
		observers = new ArrayList<ObservingSnake>();
		
	}
	
	@Override
	protected void moveTo(Point point) {
		
		previousPoint = position;
		position = point;
	//	this.notification();
		
	}

	@Override
	public void register(ObservingSnake observer) {
		
		observers.add(observer);
		
	}

	@Override
	public void unregister(ObservingSnake observer) {
		
		observers.remove(observer);
		
	}

	@Override
	public void notification() {
		
		for (int i=0; i<observers.size(); i++) {
			
			observers.get(i).update(position);
			
		}
		
	}

	@Override
	public BeingKind getKind() {
		
		return BeingKind.FoodMouse;
	
	}

	@Override
	public void interactWith(Being other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Point point) {
		
		if(point.equals(position)) {
			
			return true;
			
		}
		
		return false;
		
	}

	@Override
	public Point getHead() {
	
		return position;
		
	}

	@Override
	public boolean isConnected(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getNeck() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
