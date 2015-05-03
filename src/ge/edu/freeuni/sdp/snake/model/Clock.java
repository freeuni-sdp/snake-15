package ge.edu.freeuni.sdp.snake.model;


public class Clock {

	public Clock(){}
	public long currentTimeMillis(){
		return System.currentTimeMillis();
	}
	public static Clock getInstance(){
		return new Clock();
	}
}
