package ge.edu.freeuni.sdp.snake.model;

public class SystemTime {
	
	private long previousTime;
	
	public SystemTime(){}
	
	public long getCurrentTime(){
		return System.currentTimeMillis();
	}
	
	public long getPreviousTime(){
		return previousTime;
	}
	
	public void setPreviousTime(long time){
		this.previousTime = time;
	}
	
}
