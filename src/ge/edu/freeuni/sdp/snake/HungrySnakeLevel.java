package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.*;

import com.googlecode.lanterna.terminal.Terminal;

public class HungrySnakeLevel extends Level {

	public HungrySnakeLevel(Terminal terminal) {
		super(terminal);
	}
	
	@Override
	protected void configure() {
		super.configure();
		
		bind(GameFacade.class).to(CommonGameFacade.class);
		
		bind(Topology.class).to(SphericTopology.class);
		bind(Populator.class).to(SingleMousePopulator.class);
		bind(Snake.class).to(HungrySnake.class);

	}

}
