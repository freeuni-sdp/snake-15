package ge.edu.freeuni.sdp.snake.view.terminal;

import ge.edu.freeuni.sdp.snake.presenter.DirectionKey;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;

public class TerminalMazeViewTest {
	private Terminal terminal;
	private MazePresenter presenter;
	private TerminalMazeView mazeView;
	private Key key;

	/*
	 * General setup for tests some of these stubbed methods will be overridden
	 * in the test methods but generally this return values will work.
	 */

	@Before
	public void setUp() throws Exception {

		terminal = Mockito.mock(Terminal.class);
		presenter = Mockito.mock(MazePresenter.class);
//		mazeView = Mockito.spy(new TerminalMazeView(presenter, terminal));
		mazeView = new TerminalMazeView(presenter, terminal);
		key = Mockito.mock(Key.class);
	}

	@Test
	public void testConvertToDirectionNull() {
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		Mockito.when(terminal.readInput()).thenReturn(null);
		mazeView.show();
		Mockito.verify(presenter).tick(DirectionKey.None);
	}

	@Test
	public void testConvertToDirectionDown() {
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		Mockito.when(terminal.readInput()).thenReturn(key);
		Mockito.when(key.getKind()).thenReturn(Kind.ArrowDown);
		
		mazeView.show();
		Mockito.verify(presenter).tick(DirectionKey.Down);
	}
	
	@Test
	public void testConvertToDirectionUp() {
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		Mockito.when(terminal.readInput()).thenReturn(key);
		Mockito.when(key.getKind()).thenReturn(Kind.ArrowUp);
		
		mazeView.show();
		Mockito.verify(presenter).tick(DirectionKey.Up);
	}
	
	@Test
	public void testConvertToDirectionLeft() {
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		Mockito.when(terminal.readInput()).thenReturn(key);
		Mockito.when(key.getKind()).thenReturn(Kind.ArrowLeft);
		
		mazeView.show();
		Mockito.verify(presenter).tick(DirectionKey.Left);
	}
	
	@Test
	public void testConvertToDirectionRight() {
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		Mockito.when(terminal.readInput()).thenReturn(key);
		Mockito.when(key.getKind()).thenReturn(Kind.ArrowRight);
		
		mazeView.show();
		Mockito.verify(presenter).tick(DirectionKey.Right);
	}
	
	@Test
	public void testConvertToDirectionNone() {
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		Mockito.when(terminal.readInput()).thenReturn(key);
		Mockito.when(key.getKind()).thenReturn(Kind.Enter);
		
		mazeView.show();
		Mockito.verify(presenter).tick(DirectionKey.None);

	}
	
	
	@Test
	public void testRestoreState(){
		mazeView.restoreState();
		Mockito.verify(presenter).restoreState();
	}
	
	
	@Test
	public void testGameOverTrue(){
		Mockito.when(presenter.isGameOver()).thenReturn(true);
		mazeView.show();
		Mockito.verify(terminal, Mockito.times(1)).readInput();
	}
	
	@Test
	public void testGameOverFalse(){
		Mockito.when(presenter.isGameOver()).thenReturn(false).thenReturn(true);
		mazeView.show();
		Mockito.verify(terminal, Mockito.times(2)).readInput();
	}
}
