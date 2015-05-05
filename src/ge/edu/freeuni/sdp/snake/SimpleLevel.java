package ge.edu.freeuni.sdp.snake;

import com.googlecode.lanterna.terminal.Terminal;

import ge.edu.freeuni.sdp.snake.model.*;

public class SimpleLevel extends Level {

	public SimpleLevel(Terminal terminal) {
		super(terminal);
	}

	@Override
	protected void configure() {
		super.configure();
		
		bind(GameFacade.class).to(CommonGameFacade.class);
		
		bind(Topology.class).to(SphericTopology.class);
		bind(Populator.class).to(SingleMousePopulator.class);

	}

}
