package ge.edu.freeuni.sdp.snake.model;

public class Memento {

	private int length;
	private String direction;
	private int headX;
	private int headY;
	private int levelIndex;
	
	public Memento(int length, String direction, Point head, int levelIndex){
		this(length,stringToDirection(direction),head, levelIndex);
	}
	
	public Memento(int length, Direction direction, Point head, int levelIndex) {
		this.length = length;
		saveDirection(direction);
		headX = head.X;
		headY = head.Y;
		this.levelIndex = levelIndex;
	}

	private void saveDirection(Direction d) {
		if(d.isOppositeTo(Direction.DOWN)) direction = "up";
		if(d.isOppositeTo(Direction.UP)) direction = "down";
		if(d.isOppositeTo(Direction.RIGHT)) direction = "left";
		if(d.isOppositeTo(Direction.LEFT)) direction = "right";
	}


	private static Direction stringToDirection(String direction) {
		switch (direction) {
		case "up":
		 return Direction.UP;
		case "down":
			return Direction.DOWN;
		case "left":
			return Direction.LEFT;
		default:
			return Direction.RIGHT;
		}
	}
	
	public int getLength() {
		return length;
	}

	public Direction getDirection(){
		return stringToDirection(direction);
	}


	public Point getHead() {
		return new Point(headX, headY);
	}

	public int getLevelIndex() {
		return levelIndex;
	}
	
	public String getDirectionString(){
		return direction;
	}
}
