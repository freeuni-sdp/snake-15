package ge.edu.freeuni.sdp.snake.model;


public class CommonGameFacadeFactory implements GameFacadeFactory {

	@Override
	public GameFacade getGameFacade() {
		return new CommonGameFacade();
	}

}
