package ge.edu.freeuni.sdp.snake.model;

public class Level {

	private final String _name;
	private final Topology _topology;
	private final Populator _generator;

	public Level(String name, Topology topology, Populator generator) {
		_name = name;
		_topology = topology;
		_generator = generator;
	}

	public String getName() {
		return _name;
	}

	public Topology getTopology() {
		return _topology;
	}

	public Populator getFoodGenerator() {
		return _generator;
	}
}
