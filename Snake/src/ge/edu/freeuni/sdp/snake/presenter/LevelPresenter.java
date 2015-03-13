package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.Configuration;

public class LevelPresenter {

	private Configuration _config;
	
	public LevelPresenter() {
		this(Configuration.getInstance());
	}
	
	public LevelPresenter(Configuration config) {
		_config = config;
	}

	public String[] getLevelNames() {
		return _config.getLevelNames();

	}

	public boolean setSelection(int index) {
		if (index<0 || index>=getLevelNames().length) return false;
		_config.selectLevel(index);
		return true;
	}
}
