package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.*;

import com.googlecode.lanterna.terminal.Terminal;

public class EvilSnakeLevel extends Level {

	public EvilSnakeLevel(Terminal terminal) {
		super(terminal);
	}
	
	@Override
	protected void configure() {
		super.configure();
		
		bind(GameFacade.class).to(CommonGameFacade.class);
		bind(Topology.class).to(SphericTopology.class);
		bind(Populator.class).to(EvilSnakeCompositePopulator.class);
	}
}
