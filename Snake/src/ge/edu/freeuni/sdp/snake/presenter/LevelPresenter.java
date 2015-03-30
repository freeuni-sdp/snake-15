package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.Configuration;

public class LevelPresenter {

	private Configuration _config;
	private LevelSelectionListener _listener;
	
	public LevelPresenter() {
		this(Configuration.getInstance());
	}
	
	public LevelPresenter(Configuration config) {
		_config = config;
	}
	
	public void setLevelSelectionListener(LevelSelectionListener listener) {
		_listener = listener;
	}

	public String[] getLevelNames() {
		return _config.getLevelNames();
	}

	public boolean setSelection(int index) {
		if (index<0 || index>=getLevelNames().length) return false;
		_config.selectLevel(index);
		notifyLevelSelection();
		return true;
	}
	
	private void notifyLevelSelection() {
		if (_listener == null)
			return;
		_listener.updateDescription(_config.getSelectedLevelDescription());
	}
	
}
