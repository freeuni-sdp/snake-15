package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.ReverseGameFacade;

public class ReversePresenterFactory extends PresenterFactory {
	
	public MazePresenter getMazePresenter() {
		
		GameFacade game = new ReverseGameFacade();
		return new MazePresenter(game);
	
	}
	
	
}
