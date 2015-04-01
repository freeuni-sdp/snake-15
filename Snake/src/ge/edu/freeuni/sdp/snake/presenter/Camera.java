package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.Point;
import ge.edu.freeuni.sdp.snake.model.Size;

public class Camera {
	private Point center;

	private Size camSize;
	private Size boardSize;

	/**
	 * @param center
	 * @param camSize
	 * @param boardSize
	 */
	public Camera(Point center, Size camSize, Size boardSize) {
		this.center = center;
		this.camSize = camSize;
		this.boardSize = boardSize;
	}
	
	
	public void update(Point center){
		//BUG
		this.center = center;
	}
	
	
	public boolean isVisible(Point p){
		int width = camSize.getWidth();
		int height = camSize.getHeight();
		int boardWidth = boardSize.getWidth();
		int boardHeight = boardSize.getHeight();
		
		
		for(int i = center.X - width/2; i < center.X + width/2; i++){
			for(int j = center.Y - height/2; j < center.Y + height/2; j++){
				int x = i < boardWidth ? i : i-boardWidth;
				int y = j < boardHeight ? j : j - boardHeight;
				
				if(x == p.X && y == p.Y) return true;
			}
		}
		return false;

	}
	
	public Point getCenter(){
		return center;
	}
	
	public Size getSize(){
		return camSize;
	}
}
