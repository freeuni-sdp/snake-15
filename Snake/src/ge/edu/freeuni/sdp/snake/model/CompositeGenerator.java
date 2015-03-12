package ge.edu.freeuni.sdp.snake.model;

public class CompositeGenerator implements Populator {

	private Populator[] _generators;

	public CompositeGenerator(Populator[] generators) {
		_generators = generators;
	}

	@Override
	public void populate(Universe universe) {
		for (int i = 0; i < _generators.length; i++) {
			_generators[i].populate(universe);
		}
	}
}
