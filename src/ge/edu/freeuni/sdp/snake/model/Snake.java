package ge.edu.freeuni.sdp.snake.model;

import java.util.LinkedList;

public class Snake extends MovingBeing {

	private LinkedList<Point> _body;
	protected int _length;
	private Configuration _configuration;

	public Snake(Point head) {
		this(head, 1);
	}
	
	public Snake(Point head,int lives){
		this(head,lives,Configuration.getInstance());
	}
	
	public Snake(Point head, int lives,Configuration configuration) {
		super(lives);
		_body = new LinkedList<Point>();
		_body.add(head);
		_length = 3;
		_configuration = configuration;
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
	
	public int getLength(){
		return _length;
	}
	
	public Memento saveToMemento(){
		return new Memento(_length,getDirection(),getHead(),_configuration.getSelectedLevelIndex());
	}
	
	public void restoreFromMemento (Memento m){
		_length = m.getLength();
		setDirection(m.getDirection());
		moveTo(m.getHead());
		_configuration.selectLevel(0);
	}
}