package ge.edu.freeuni.sdp.snake.model;

/*
 * Levels differ in their name, topology, and the way their are populated with beeings.
 * Level class aggregates and encapsulates all that. 
 */
public class Level implements GameLevel{

    private final String _name;
    private final Topology _topology;
    private final Populator _populator;
    private final SnakeFactory _snakeFactory;

    public Level(String name, Topology topology, Populator generator, SnakeFactory snakeFactory) {
            _name = name;
            _topology = topology;
            _populator = generator;
            _snakeFactory = snakeFactory;
    }

    @Override
    public String getName() {
            return _name;
    }

    @Override
    public Topology getTopology() {
            return _topology;
    }

    @Override
    public Populator getFoodGenerator() {
            return _populator;
    }

    @Override
    public Snake getSnake(Point head){
        return _snakeFactory.createSnake(head);
    }
}
