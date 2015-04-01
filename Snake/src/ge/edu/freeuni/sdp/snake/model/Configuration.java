package ge.edu.freeuni.sdp.snake.model;

import java.util.List;

public class Configuration {

	private List<Level> _levels;
	private Level _selectedLevel;
	private Size _size;
	private Size _cameraSize;

	private static Configuration _singleton;

	public static void init(Size size, List<Level> levels) {
		if (_singleton != null)
			throw new IllegalStateException("Can not initialize twice.");
		_singleton = new Configuration(size, levels);
	}
	

	public static Configuration getInstance() {
		if (_singleton == null)
			throw new IllegalStateException("You must call init() first.");
		return _singleton;
	}

	private Configuration(Size size, List<Level> levels) {
		_size = size;
		_levels = levels;
		_cameraSize = new Size(_size.getWidth()/2, _size.getHeight()/2);
	}

	public Size getSize() {
		return _size;
	}
	
	public Size getCameraSize(){
		return _cameraSize;
	}
	public Level getSelectedLevel() {
		return _selectedLevel;
	}

	public void selectLevel(int index) {
		_selectedLevel = _levels.get(index);
	}

	public String[] getLevelNames() {
		String[] result = new String[_levels.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = _levels.get(i).getName();
		}
		return result;
	}
}
