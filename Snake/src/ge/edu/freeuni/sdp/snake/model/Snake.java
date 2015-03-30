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
	
	@Override
	public Point getNeck() {
		return _body.get(1);
	}
	
	@Override
	public boolean isConnected(Object obj){
		return (((Being)obj).contains(getHead())|| (getHead().equals(((Being)obj).getNeck()) && 
				getNeck().equals(((Being)obj).getHead())));
	}
}