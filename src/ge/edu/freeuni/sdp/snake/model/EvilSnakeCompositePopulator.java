package ge.edu.freeuni.sdp.snake.model;

import com.google.inject.Inject;

public class EvilSnakeCompositePopulator extends CompositePopulator {

	@Inject
	public EvilSnakeCompositePopulator(EvilSnakePopulator snakePopulator, SingleMousePopulator mousePopulator) {
		this(new Populator[] {snakePopulator, mousePopulator});
	}
	
	public EvilSnakeCompositePopulator(Populator[] populator) {
		super(populator);
	}

}
