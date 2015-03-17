package ge.edu.freeuni.sdp.snake.model;

/**
 * Is used to combine two or more poulators so that they appear to outside as one
 * @author George Mamaladze
 *
 */
public class CompositePopulator implements Populator {

	private Populator[] _populators;

	public CompositePopulator(Populator[] populator) {
		_populators = populator;
	}

	@Override
	public void populate(Universe universe) {
		for (int i = 0; i < _populators.length; i++) {
			_populators[i].populate(universe);
		}
	}
}
