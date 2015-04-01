package ge.edu.freeuni.sdp.snake.model;

import java.util.LinkedList;

public class Snake extends MovingBeing {

	private LinkedList<Point> _body;
	private int _length;

	public Snake(Point head) {
		_body = new LinkedList<Point>();
		_body.add(head);
		_length = 3;
	}

	@Override
	public Point getHead() {
		return _body.getFirst();
	};

	@Override
	public boolean contains(Point point) {
		return _body.contains(point);
	};

	@Override
	public BeingKind getKind() {
		return BeingKind.Snake;
	};

	@Override
	public void interactWith(Being other) {
		other.kill();
		grow();
	};

	@Override
	protected void moveTo(Point point) {
		_body.addFirst(point);
		trim();
	};

	private void grow() {
		_length++;
	}

	private void trim() {
		while (_body.size() > _length)
			_body.removeLast();
	}
	
	public Memento saveToMemento(){
		return new Memento(_length,getDirection(),getHead(),Configuration.getInstance().getSelectedLevelIndex());
	}
	
	public void restoreFromMemento (Memento m){
		_length = m.getLength();
		setDirection(m.getDirection());
		moveTo(m.getHead());
		Configuration.getInstance().selectLevel(0);
	}
}