package ge.edu.freeuni.sdp.snake.view.terminal;


import ge.edu.freeuni.sdp.snake.presenter.HighScorePresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import static org.mockito.Mockito.*;

public class TerminalHighScoreViewTest {
	private Terminal terminal;
	private HighScorePresenter presenter;
	private Key key;
	@Before
	public void setUp(){
		terminal=Mockito.mock(Terminal.class);
		presenter = Mockito.mock(HighScorePresenter.class);
		key=Mockito.mock(Key.class);
		when(terminal.getTerminalSize()).thenReturn(new TerminalSize(1000, 1000));
		when(presenter.getHighScoreInfo()).thenReturn("");
		when(terminal.readInput()).thenReturn(key);
		
	}
	//to verify that it will print my new score which is not a high score (presenter.checkNewScore returns false) and it will wait for me to enter a non null key
	@Test
	public void testMyScore() {
		TerminalHighScoreView v=new TerminalHighScoreView(presenter, terminal);
		
		when(presenter.getScore()).thenReturn(100);
		when(presenter.checkNewScore(100)).thenReturn(false);
		//first return null and then return key
		when(terminal.readInput()).thenReturn(null).thenReturn(key);
		v.show();
		Mockito.verify(terminal,atLeastOnce()).putCharacter('1');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('0');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('0');
		//check that it reads the input twice first time it will return null second time it returns a key
		Mockito.verify(terminal, times(2)).readInput();
	}
	//test to verify that the program will print the High Score Info returned by presenter method getHighScoreInfo
	@Test
	public void testHighscores() {
		TerminalHighScoreView v=new TerminalHighScoreView(presenter, terminal);
		when(presenter.getHighScoreInfo()).thenReturn("Me 20");
		v.show();
		Mockito.verify(terminal,atLeastOnce()).putCharacter('M');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('e');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('2');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('0');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('0');
	}
	//test when you have a new highscore(checkScore returns true) and the program should ask for yor name
	@Test
	public void testNewHighScore() {
		TerminalHighScoreView v=new TerminalHighScoreView(presenter, terminal);
		when(presenter.getScore()).thenReturn(100);
		//return normal key kind twice to enter a name containing two characters then retrun Kind.Enter to break
		when(key.getKind()).thenReturn(Kind.NormalKey).thenReturn(Kind.NormalKey).thenReturn(Kind.Enter);
		when(key.getCharacter()).thenReturn('M').thenReturn('E');
		//first return null to check the continue if, then returns key 
		when(terminal.readInput()).thenReturn(null).thenReturn(key);
		when(presenter.checkNewScore(100)).thenReturn(true);
		v.show();
		Mockito.verify(terminal,atLeastOnce()).putCharacter('M');
		Mockito.verify(terminal,atLeastOnce()).putCharacter('E');
	}
	
}
