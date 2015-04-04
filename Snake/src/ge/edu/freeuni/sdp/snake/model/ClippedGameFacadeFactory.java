package ge.edu.freeuni.sdp.snake.model;

public class ClippedGameFacadeFactory implements GameFacadeFactory {

	private Size clipSize;
	
	public ClippedGameFacadeFactory(Size clipSize) {
		this.clipSize = clipSize;
	}

	@Override
	public GameFacade getGameFacade() {
		return new ClippedGameFacade(clipSize);
	}

}
