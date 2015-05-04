package ge.edu.freeuni.sdp.snake.presenter;

import static org.junit.Assert.*;
import ge.edu.freeuni.sdp.snake.model.BeingKind;
import ge.edu.freeuni.sdp.snake.model.Direction;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.Point;
import ge.edu.freeuni.sdp.snake.model.Size;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MazePresenterTest {

	private static GameFacade game;
	private static MazePresenter mazePresenter;

	@Before
	public void setUp() throws Exception {
		game = Mockito.mock(GameFacade.class);
		Mockito.when(game.getSize()).thenReturn(new Size(10, 10));
		mazePresenter = Mockito.spy(new MazePresenter(game));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetCellUpdateListener() {

	}

	@Test
	public void testIsGameOver() {

	}

	@Test
	public void testTick() {

	}

	@Test
	public void testSetLivesUpdateListener() {

	}

	@Test
	public void testSaveState() {

	}

	@Test
	public void testRestoreState() {

	}

}
