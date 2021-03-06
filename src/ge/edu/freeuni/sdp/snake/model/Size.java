package ge.edu.freeuni.sdp.snake.model;

public class Size  
{
	private int _width;
	private int _height;

	public Size(int width, int height) {
		if (width<0) throw new IllegalArgumentException("width");
		if (height<0) throw new IllegalArgumentException("height");

		_width = width;
		_height = height;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
}
