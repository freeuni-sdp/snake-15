package ge.edu.freeuni.sdp.snake.model;

import java.util.LinkedList;

public class Snake extends MovingBeing {

	protected LinkedList<Point> _body;
	protected int _length;

	public Snake(Point head) {
		this(head, 1);
	}
	
	public Snake(Point head, int lives) {
		super(lives);
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

	protected void grow() {
		_length++;
	}

	protected void trim() {
		while (_body.size() > _length)
			_body.removeLast();
	}
	
	public int getLength(){
		return _length;
	}
	
}