package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.BeingKind;
import ge.edu.freeuni.sdp.snake.model.Direction;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.Point;
import ge.edu.freeuni.sdp.snake.model.Size;

public class HugeMazePresenter implements MazePresenter {

	private GameFacade _game;
	private CellUpdateListener _listener;
	private CellContent[][] _cellsCache;
	private Direction _currentDirection;
	private Camera _camera;

	public HugeMazePresenter(GameFacade game) {
		_game = game;
		_currentDirection = Direction.RIGHT;
		_cellsCache = initCells();
		_camera = getCamera();
	}

	public void setCellUpdateListener(CellUpdateListener listener) {
		_listener = listener;
	}

	public boolean isGameOver() {
		return _game.isGameOver();
	}

	public void tick(DirectionKey key) {
		scanAndNotify();
		Direction newDirection = convertToDirection(key);
		tryChangeDirection(newDirection);
		_game.makeMove(_currentDirection);
		_camera.update(_game.getSnakeHead());
	}

	private void tryChangeDirection(Direction newDirection) {
		if (newDirection == null)
			return;
		// Otherwise snake would eat itself
		if (newDirection.isOppositeTo(_currentDirection))
			return;
		_currentDirection = newDirection;
	}

	private void scanAndNotify() {
		for (int i = 0; i < _cellsCache.length; i++) {
			for (int j = 0; j < _cellsCache[i].length; j++) {

				CellContent currentValue = _cellsCache[i][j];
				CellContent newValue = GetNewValue(i, j);

				boolean hasChanged = currentValue != newValue;
				if (hasChanged) {
					_cellsCache[i][j] = newValue;
				}
				if(_camera.isVisible(new Point(i, j))){
					updateListener(i-(_camera.getCenter().X - _camera.getSize().getWidth()/2), j-(_camera.getCenter().Y - _camera.getSize().getHeight()/2), newValue);
					System.out.println(i+"; "+j);
				}
			}
		}
		

					
		
	}

	private CellContent GetNewValue(int i, int j) {
		BeingKind beingKind = _game.getBeingKindAt(new Point(i, j));
		return convertToCellContent(beingKind);
	}

	private void updateListener(int i, int j, CellContent newValue) {
		if (_listener == null)
			return;
		CellPosition position = new CellPosition(i, j);
		_listener.updateCell(position, newValue);
	}

	private CellContent[][] initCells() {
		int width = _game.getSize().getWidth();
		int height = _game.getSize().getHeight();
		CellContent[][] result = new CellContent[width][];
		for (int i = 0; i < width; i++) {
			result[i] = new CellContent[height];
			for (int j = 0; j < height; j++) {
				result[i][j] = CellContent.None;
			}
		}
		return result;
	}

	private Direction convertToDirection(DirectionKey key) {
		switch (key) {
		case Down:
			return Direction.DOWN;
		case Left:
			return Direction.LEFT;
		case Right:
			return Direction.RIGHT;
		case Up:
			return Direction.UP;
		default:
			return null;
		}
	}

	private CellContent convertToCellContent(BeingKind beingKind) {
		switch (beingKind) {
		case FoodMouse:
			return CellContent.FoodMouse;
		case FoodPoison:
			return CellContent.FoodPoison;
		case Snake:
			return CellContent.Snake;
		default:
			return CellContent.None;
		}
	}
	
	private Camera getCamera() {
		//TODO get snake head
//		Point center = new Point(_game.getSize().getWidth()/2, _game.getSize().getHeight()/2);

		//TODO get camera size
		Size camSize = new Size(_game.getSize().getWidth()/5, _game.getSize().getHeight()/5);
		return new Camera(_game.getSnakeHead(), camSize, _game.getSize());
	}
}