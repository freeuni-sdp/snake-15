package ge.edu.freeuni.sdp.snake.view.terminal;

import static org.junit.Assert.*;
import ge.edu.freeuni.sdp.snake.presenter.GameOverPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class TerminalGameOverViewTest {

	private static Key key;
	private static Terminal terminal;
	private static TerminalSize terminalSize;
	private static GameOverPresenter presenter;
	private static TerminalGameOverView gameOver;

	@Before
	public void setUp() throws Exception {
		key = Mockito.mock(Key.class);
		terminal = Mockito.mock(Terminal.class);
		terminalSize = Mockito.mock(TerminalSize.class);
		presenter = Mockito.mock(GameOverPresenter.class);
		gameOver = Mockito.spy(new TerminalGameOverView(presenter, terminal));
	}

	/*
	 * 
	 */

	@Test
	public void testShow() {
		Mockito.when(terminalSize.getColumns()).thenReturn(0).thenReturn(1);
		Mockito.when(terminalSize.getRows()).thenReturn(0).thenReturn(7);

		Mockito.when(key.getKind()).thenReturn(Kind.ArrowDown)
				.thenReturn(Kind.Escape);
		Mockito.when(key.getCharacter()).thenReturn('s').thenReturn('y')
				.thenReturn('n');

		Mockito.when(terminal.getTerminalSize()).thenReturn(terminalSize);
		Mockito.when(terminal.readInput()).thenReturn(null).thenReturn(key);

		gameOver.show();
	}

	/*
	 * After construction without interacting to this class first call of method
	 * continueGameOrNot() should return false.
	 */

	@Test
	public void testContinueGameOrNotFalse() {
		assertFalse(gameOver.continueGameOrNot());
	}

	/*
	 * After construction when user will select continue game (Y/y)
	 * continueGameOrNot() should return true.
	 */

	@Test
	public void testContinueGameOrNotTrue() {
		// Stub terminal size
		Mockito.when(terminalSize.getColumns()).thenReturn(10);
		Mockito.when(terminalSize.getRows()).thenReturn(10);
		// Stub key
		Mockito.when(key.getCharacter()).thenReturn('y');
		// Stub terminal
		Mockito.when(terminal.getTerminalSize()).thenReturn(terminalSize);
		Mockito.when(terminal.readInput()).thenReturn(key);
		// Call necessary methods
		gameOver.show();
		// Check if method worked correctly
		assertTrue(gameOver.continueGameOrNot());
	}

}
