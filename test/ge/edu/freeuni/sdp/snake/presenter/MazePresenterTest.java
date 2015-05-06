package ge.edu.freeuni.sdp.snake.presenter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ge.edu.freeuni.sdp.snake.model.BeingKind;
import ge.edu.freeuni.sdp.snake.model.Caretaker;
import ge.edu.freeuni.sdp.snake.model.Direction;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.Memento;
import ge.edu.freeuni.sdp.snake.model.Point;
import ge.edu.freeuni.sdp.snake.model.Size;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MazePresenterTest {

	private static int lives;
	private static File file;
	private static Size size;
	private static Caretaker care;
	private static GameFacade game;
	private static Memento memento;
	private static MazePresenter mazePresenter;
	private static CellUpdateListener cellUpdateListener;
	private static LivesUpdateListener livesUpdateListener;

	@Before
	public void setUp() throws Exception {
		lives = 7;
		file = Mockito.mock(File.class);
		size = Mockito.mock(Size.class);
		care = Mockito.mock(Caretaker.class);
		game = Mockito.mock(GameFacade.class);
		memento = Mockito.mock(Memento.class);
		cellUpdateListener = Mockito.mock(CellUpdateListener.class);
		livesUpdateListener = Mockito.mock(LivesUpdateListener.class);

		Mockito.when(size.getHeight()).thenReturn(10);
		Mockito.when(size.getWidth()).thenReturn(10);
		Mockito.when(file.exists()).thenReturn(false);
		Mockito.when(game.getSize()).thenReturn(size);

		Mockito.when(game.getLives()).thenReturn(lives);
		Mockito.when(game.getBeingKindAt((Point) Mockito.any()))
				.thenReturn(BeingKind.FoodMouse)
				.thenReturn(BeingKind.FoodPoison).thenReturn(BeingKind.Snake)
				.thenReturn(BeingKind.None);

		mazePresenter = Mockito.spy(new MazePresenter(game, file, care));
	}

	@Test
	public void testMazePresenterFileExists() {
		Mockito.when(file.exists()).thenReturn(true);
		Mockito.when(care.getMemento()).thenReturn(memento);
		mazePresenter = new MazePresenter(game, file, care);
		Mockito.verify(file, Mockito.atLeastOnce()).exists();
		Mockito.verify(care).getMemento();
	}

	@Test
	public void testMazePresenterFileNotExists() {
		mazePresenter = new MazePresenter(game, file, care);
		Mockito.verify(file, Mockito.atLeastOnce()).exists();
		Mockito.verify(care, Mockito.never()).getMemento();
	}

	@Test
	public void testMazePresenterOld() {
		mazePresenter = new MazePresenter(game);
		Mockito.verify(game, Mockito.atLeastOnce()).getSize();
	}

	@Test
	public void testSetCellUpdateListenerWithNull() {
		mazePresenter.setCellUpdateListener(null);
		Mockito.verify(mazePresenter).setCellUpdateListener(null);
	}

	@Test
	public void testSetCellUpdateListenerWithMock() {
		mazePresenter.setCellUpdateListener(cellUpdateListener);
		Mockito.verify(mazePresenter).setCellUpdateListener(cellUpdateListener);
	}

	@Test
	public void testIsGameOverFase() {
		Mockito.when(game.isGameOver()).thenReturn(false);
		assertFalse(mazePresenter.isGameOver());
		Mockito.verify(game).isGameOver();
	}

	@Test
	public void testIsGameOverTrue() {
		Mockito.when(game.isGameOver()).thenReturn(true);
		assertTrue(mazePresenter.isGameOver());
		Mockito.verify(game).isGameOver();
	}

	@Test
	public void testTickDown() {
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Down);
		Mockito.verify(game).makeMove(Direction.DOWN);
		Mockito.verify(livesUpdateListener).updateLives(lives);
	}

	/*
	 * Case when tick is given direction key is left.
	 */
	@Test
	public void testTickLeft() {
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Left);
		// This is because this test tries to change direction opposite current
		// direction and this is not allowed because snake would eat itself.
		Mockito.verify(game).makeMove(Direction.RIGHT);
		Mockito.verify(livesUpdateListener).updateLives(lives);
	}

	/*
	 * Case when tick is given direction key right.
	 */
	@Test
	public void testTickRight() {
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Right);
		Mockito.verify(game).makeMove(Direction.RIGHT);
		Mockito.verify(livesUpdateListener).updateLives(lives);
	}

	/*
	 * Case when tick is given direction key up.
	 */
	@Test
	public void testTickUp() {
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Up);
		Mockito.verify(game).makeMove(Direction.UP);
		Mockito.verify(livesUpdateListener).updateLives(lives);
	}

	/*
	 * Case when tick is given different direction keys.
	 */
	@Test
	public void testTickChangingDirections() {
		mazePresenter.setCellUpdateListener(cellUpdateListener);
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Up);
		mazePresenter.tick(DirectionKey.Down);
		mazePresenter.tick(DirectionKey.Left);

		Mockito.verify(game).makeMove(Direction.LEFT);
		Mockito.verify(game, Mockito.times(2)).makeMove(Direction.UP);
		Mockito.verify(livesUpdateListener, Mockito.atLeast(3)).updateLives(
				lives);
	}

	/*
	 * Case when tick is given direction key none.
	 */
	@Test
	public void testTickNone() {
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.None);
		// Default direction in the start is right
		Mockito.verify(game).makeMove(Direction.RIGHT);
		Mockito.verify(livesUpdateListener).updateLives(lives);
	}

	/*
	 * Just verifies if correct method is called have no idea how to test
	 * otherwise.
	 */
	@Test
	public void testSetLivesUpdateListenerWithNull() {
		mazePresenter.setLivesUpdateListener(null);
		Mockito.verify(mazePresenter).setLivesUpdateListener(null);
	}

	/*
	 * Just verifies if correct method is called have no idea how to test
	 * otherwise.
	 */
	@Test
	public void testSetLivesUpdateListenerWithMock() {
		mazePresenter.setLivesUpdateListener(livesUpdateListener);
		Mockito.verify(mazePresenter).setLivesUpdateListener(
				livesUpdateListener);
	}

	/*
	 * Just verifies if correct method is called have no idea how to test
	 * otherwise.
	 */
	@Test
	public void testSaveState() {
		mazePresenter.saveState();
		Mockito.verify(game).saveState();
	}

	/*
	 * Just verifies if correct method is called have no idea how to test
	 * otherwise.
	 */
	@Test
	public void testRestoreState() {
		mazePresenter.restoreState();
		Mockito.verify(game).restoreState();
	}

	/*
	 * Changing direction to the opposite should not work and this is test for
	 * that case but only for up and down if this works left and right still
	 * will be working
	 */
	@Test
	public void testTryChangingDirectionToOpposite() {
		mazePresenter.setCellUpdateListener(cellUpdateListener);
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Up);
		mazePresenter.tick(DirectionKey.Down);

		Mockito.verify(game, Mockito.atLeast(2)).makeMove(Direction.UP);
		Mockito.verify(livesUpdateListener, Mockito.atLeast(2)).updateLives(
				lives);
	}

	/*
	 * Case when snake is on full screen
	 */
	@Test
	public void testFullScreenIsSnake() {
		Mockito.when(game.getBeingKindAt((Point) Mockito.any())).thenReturn(
				BeingKind.Snake);
		mazePresenter.setCellUpdateListener(cellUpdateListener);
		mazePresenter.setLivesUpdateListener(livesUpdateListener);

		mazePresenter.tick(DirectionKey.Up);

		Mockito.verify(game).makeMove(Direction.UP);
		Mockito.verify(livesUpdateListener).updateLives(lives);
	}
}
