package ge.edu.freeuni.sdp.snake.model;

public class SwapSidesPopulator extends RandomPositionPopulator {
	
	private ObservableMouseBeing _mouse;
	private ObservableSnakeFactory snakeFactory;
	private ObservableSnakeAdapter _snake;

	public SwapSidesPopulator(ObservableSnakeFactory snakeFactory) {
		this.snakeFactory = snakeFactory;
		
	}
	
	@Override
	public void populate(Universe universe) {
		if (_mouse == null || !_mouse.isAlive()) {
			Point point = getRandomUnocupied(universe);
			_mouse = new ObservableMouseBeing(point);
			universe.addBeing(_mouse);
			
			ensureSnake(universe);
			_mouse.setPositionObserver(_snake);
			_snake.setDirectionObserver(_mouse);
		}
	}
	
	public void ensureSnake(Universe universe) {
		if (_snake==null) {
			Point point = this.getRandomUnocupied(universe);
			_snake = (ObservableSnakeAdapter)snakeFactory.createSnake(point);
		}
	}

}
