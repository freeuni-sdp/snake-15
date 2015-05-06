package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class CommonGameFacadeTest {
	private CommonGameFacade facade;
	private Configuration configuration;
	private Size size;
	private Universe universe;
	private Snake snake;
	private Populator populator;
	
	@Before
	public void setUp(){
		configuration = mock(Configuration.class);
		size = mock(Size.class); 
		when(configuration.getSize()).thenReturn(size);
		when(size.getWidth()).thenReturn(20);
		when(size.getHeight()).thenReturn(20);
	}
	
	@Test
	public void get_lives() {
		// using stub snake
		universe = mock(Universe.class);
		snake = mock(Snake.class);
		when(snake.getLives()).thenReturn(4);
		populator = mock(Populator.class);
		
		facade = new CommonGameFacade(universe, snake, populator);
		
		assertEquals(4, facade.getLives());
		verify(snake, times(1)).getLives();
		
		// using real snake object
		snake = new Snake(new Point(1, 1), 8, configuration);
		snake = spy(snake);
		facade = new CommonGameFacade(universe, snake, populator);
		
		assertEquals(8, facade.getLives());
		snake.kill();
		snake.kill();
		assertEquals(6, facade.getLives());
		verify(snake, times(2)).getLives();
	}
	
	@Test
	public void get_being_kind() {
		// returning no kind
		universe = mock(Universe.class);
		snake = new Snake(new Point(1, 1), 8, configuration);
		populator = mock(Populator.class);
		facade = new CommonGameFacade(universe, snake, populator);
		
		assertEquals(BeingKind.None, facade.getBeingKindAt(mock(Point.class)));
		
		// returning actual kind
		Point point = mock(Point.class);
		Snake sn = mock(Snake.class);
		when(sn.getKind()).thenReturn(BeingKind.Snake);
		when(universe.getBeingAt(point)).thenReturn(sn);
		assertEquals(BeingKind.Snake, facade.getBeingKindAt(point));
		verify(sn).getKind();
		
		verify(universe, times(2)).getBeingAt((Point)any());
	}
	
	@Test
	public void make_move_with_direction() {
		// checking invocations
		universe = mock(Universe.class);
		snake = new Snake(new Point(1, 1), 8, configuration);
		snake = spy(snake);
		populator = mock(Populator.class);
		facade = new CommonGameFacade(universe, snake, populator);
		
		Direction dir = mock(Direction.class);
		facade.makeMove(dir);
		verify(snake).setDirection(dir);
		verify(universe).move();
		verify(universe).interact();
		verify(universe).removeZombies();
		verify(populator).populate(universe);
		
		assertEquals(dir, snake.getDirection());
	}
	
	@Test
	public void is_game_over() {
		universe = mock(Universe.class);
		snake = new Snake(new Point(1, 1), 3, configuration);
		snake = spy(snake);
		populator = mock(Populator.class);
		facade = new CommonGameFacade(universe, snake, populator);
		
		assertFalse(facade.isGameOver());
		assertTrue(snake.isAlive());
		snake.kill();
		snake.kill();
		snake.kill();
		assertTrue(facade.isGameOver());
		assertFalse(snake.isAlive());
	}

	@Test
	public void get_size_from_configuration() {
		universe = mock(Universe.class);
		snake = new Snake(mock(Point.class), 1, configuration);
		populator = mock(Populator.class);
		facade = new CommonGameFacade(universe, snake, populator);
		//assertEquals(size, facade.getSize());
	}
	
	@Test
	public void state_save_restore() {
		universe = mock(Universe.class);
		snake = new Snake(new Point(1, 1), 8, configuration);
		snake.setDirection(Direction.DOWN);
		populator = mock(Populator.class);
		facade = new CommonGameFacade(universe, snake, populator);
		
		facade.saveState();
		facade.restoreState();
	}

}
