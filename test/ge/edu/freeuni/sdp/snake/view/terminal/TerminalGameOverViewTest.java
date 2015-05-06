package ge.edu.freeuni.sdp.snake.view.terminal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

	/*
	 * General setup for tests some of these stubbed methods will be overridden
	 * in the test methods but generally this return values will work.
	 */

	@Before
	public void setUp() throws Exception {
		key = Mockito.mock(Key.class);
		terminal = Mockito.mock(Terminal.class);
		terminalSize = Mockito.mock(TerminalSize.class);
		presenter = Mockito.mock(GameOverPresenter.class);
		gameOver = Mockito.spy(new TerminalGameOverView(presenter, terminal));

		Mockito.when(terminalSize.getRows()).thenReturn(100);
		Mockito.when(terminalSize.getColumns()).thenReturn(100);
		Mockito.when(terminal.getTerminalSize()).thenReturn(terminalSize);
	}

	/*
	 * This method is used mainly for getting information from user after
	 * loosing game. It should change boolean continueGame. I'll test different
	 * cases of getting user input in other methods.
	 */

	@Test
	public void testShowWithUserAsnwerNoCharacter() {
		// First this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
		// Stub key to return no
		Mockito.when(key.getCharacter()).thenReturn('n');
		Mockito.when(terminal.readInput()).thenReturn(key);
		gameOver.show();
		// Second call of this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
	}

	@Test
	public void testShowWithUserAsnwerNoEscape() {
		// First this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
		// Stub key to return no
		Mockito.when(key.getKind()).thenReturn(Kind.Escape);
		Mockito.when(terminal.readInput()).thenReturn(key);
		gameOver.show();
		// Second call of this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
	}

	@Test
	public void testShowWithUserAsnwerStrangeSymbol() {
		// First this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
		// Stub key first returns strange character then no
		Mockito.when(key.getCharacter()).thenReturn('\n').thenReturn('n');
		Mockito.when(terminal.readInput()).thenReturn(key);
		gameOver.show();
		// Second call of this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
	}

	@Test
	public void testShowWithTerminalSizeChanges() {
		// First this boolean should be false
		assertFalse(gameOver.continueGameOrNot());
		// Prepare stub for terminal size
		Mockito.when(terminalSize.getRows()).thenReturn(0).thenReturn(10);
		Mockito.when(terminalSize.getColumns()).thenReturn(0).thenReturn(10);
		// Stub key to return yes
		Mockito.when(key.getCharacter()).thenReturn('y');
		Mockito.when(terminal.getTerminalSize()).thenReturn(terminalSize);
		Mockito.when(terminal.readInput()).thenReturn(null).thenReturn(key);
		gameOver.show();
		assertTrue(gameOver.continueGameOrNot());
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
	 * 
	 * (P.S doesn't work on upper case 'Y')
	 */

	@Test
	public void testContinueGameOrNotTrue() {
		// Stub key to return 'y'
		Mockito.when(key.getCharacter()).thenReturn('y');
		Mockito.when(terminal.readInput()).thenReturn(key);
		// Call necessary methods in this case show
		gameOver.show();
		// Verify method calls occurrence
		Mockito.verify(key).getCharacter();
		Mockito.verify(terminal).readInput();
		Mockito.verify(terminal).getTerminalSize();
		Mockito.verify(terminalSize, Mockito.atLeast(1)).getRows();
		Mockito.verify(terminalSize, Mockito.atLeast(1)).getColumns();
		// Check if method worked correctly
		assertTrue(gameOver.continueGameOrNot());
	}

}
