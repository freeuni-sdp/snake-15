package ge.edu.freeuni.sdp.snake.presenter;

import static org.junit.Assert.*;

import java.io.File;

import ge.edu.freeuni.sdp.snake.model.BeingKind;
import ge.edu.freeuni.sdp.snake.model.Caretaker;
import ge.edu.freeuni.sdp.snake.model.Direction;
import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.Memento;
import ge.edu.freeuni.sdp.snake.model.Point;
import ge.edu.freeuni.sdp.snake.model.Size;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MazePresenterTest {

	private static File file;
	private static Size size;
	private static Caretaker care;
	private static GameFacade game;
	private static Memento memento;
	private static MazePresenter mazePresenter;

	@Before
	public void setUp() throws Exception {
		file = Mockito.mock(File.class);
		size = Mockito.mock(Size.class);
		care = Mockito.mock(Caretaker.class);
		game = Mockito.mock(GameFacade.class);
		memento = Mockito.mock(Memento.class);

		Mockito.when(size.getHeight()).thenReturn(10);
		Mockito.when(size.getWidth()).thenReturn(10);
		Mockito.when(file.exists()).thenReturn(false);
		Mockito.when(game.getSize()).thenReturn(size);

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
		mazePresenter.saveState();
		Mockito.verify(game).saveState();
	}

	@Test
	public void testRestoreState() {
		mazePresenter.restoreState();
		Mockito.verify(game).restoreState();
	}

}
