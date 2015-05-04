import ge.edu.freeuni.sdp.snake.model.Clock;
import ge.edu.freeuni.sdp.snake.model.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import static org.junit.Assert.*;

public class EvilSnakeTest {
	private Clock clock;
	private MyRandom rand;
	private EvilSnake target;
	private Topology top;
	private Configuration config;
	
	@Before
	public void setUp(){
		top = mock(SphericTopology.class);
		clock = mock(Clock.class);
		rand = mock(MyRandom.class);
		config = mock(Configuration.class);
		target = new EvilSnake(new Point(2,2), 1, config, rand,clock);
	}

	//EvilSnake Is Going Left and than still going Left . Doesn't Change Direction
	@Test
	public void notChangeDirection(){
		when(top.getNextTo(new Point(2,2),Direction.LEFT)).thenReturn(new Point(1, 2));
		when(top.getNextTo(new Point(1, 2), Direction.LEFT)).thenReturn(new Point(0, 2));
		when(clock.currentTimeMillis()).thenReturn(4000L);
		target.move(top);
		target.move(top);
		Point head = target.getHead();
		assertEquals(0,head.X);
		assertEquals(2,head.Y);
	}

	//EvilSnake Is Going Left and then Down. Changes Direction
	@Test
	public void changesDirectionToDown(){
		when(rand.nextInt(4)).thenReturn(3);
		when(top.getNextTo(new Point(2, 2), Direction.LEFT)).thenReturn(new Point(1, 2));
		when(top.getNextTo(new Point(1,2),Direction.DOWN)).thenReturn(new Point(1, 3));
		when(clock.currentTimeMillis()).thenReturn(6000L);
		target.move(top);
		target.move(top);
		Point head = target.getHead();
		assertEquals(1,head.X);
		assertEquals(3,head.Y);
	}

	@Test
	public void constructorSetsHead() {
		Point point = mock(Point.class);
		EvilSnake target = new EvilSnake(point, 1, config, rand,clock);
		assertEquals(point, target.getHead());
	}
}
