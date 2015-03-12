package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Level;

import java.util.List;

public class Configuration {

	private int _width;
	private int _height;
	private List<Level> _levels;
	private Level _selectedLevel;

	private static Configuration _singleton;

	public static void init(int width, int height, List<Level> levels) {
		if (_singleton != null)
			throw new IllegalStateException("Can not initialize twice.");
		_singleton = new Configuration(width, height, levels);
	}

	public static Configuration get() {
		if (_singleton == null)
			throw new IllegalStateException("You must call init() first.");
		return _singleton;
	}

	private Configuration(int width, int height, List<Level> levels) {
		_width = width;
		_height = height;
		_levels = levels;
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
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
