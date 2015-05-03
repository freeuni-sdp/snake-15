import ge.edu.freeuni.sdp.snake.model.Clock;
import ge.edu.freeuni.sdp.snake.model.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import static org.junit.Assert.*;

public class EvilSnakeTest {
	private EvilSnake evilSnake;
	private EvilSnake mockEvilSnake;
	private Clock clock;
	@Before
	public void setUp(){
		clock = mock(Clock.class);
		evilSnake = new EvilSnake(new Point(0,0));
		mockEvilSnake = mock(EvilSnake.class);
	}
//
//	@Test
//	public void setsDirectionToCorrectly(){
//		MyRandom rand = mock(MyRandom.class);
//		EvilSnake target = new EvilSnake(new Point(0,0),rand);
//		when(rand.nextInt(4)).thenReturn(3);
//		target.setRandomDirection();
//		assertEquals(Direction.getDirection(), Direction.DOWN);
//	}

	@Test
	public void constructorSetsHead() {
		Point point = mock(Point.class);
		EvilSnake target = new EvilSnake(point);
		assertEquals(point, target.getHead());
	}
}
