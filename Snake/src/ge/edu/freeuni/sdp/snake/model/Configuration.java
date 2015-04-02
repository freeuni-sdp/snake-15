package ge.edu.freeuni.sdp.snake.model;

import java.util.List;

public class Configuration {

	private List<Level> _levels;
	private Level _selectedLevel;
	private Size _size;

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
	}

	public Size getSize() {
		return _size;
	}
	
	public Level getSelectedLevel() {
		return _selectedLevel;
	}
	
	public String getSelectedLevelDescription() {
		return _selectedLevel.getDescription();
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
