package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.view.MazeView;

import java.nio.charset.Charset;

import com.google.inject.*;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

public class App {

	public static void main(String[] args) {

		Terminal terminal = getTerminal();
		Level level = 
				new SimpleLevel(terminal);
				//new HungrySnakeLevel(terminal);
				//new EvilSnakeLevel(terminal);
		
		Injector injector = Guice.createInjector(level);
	
		MazeView view = injector.getInstance(MazeView.class);
		view.show();
		terminal.exitPrivateMode();
	}
	
	@Provides
	private static Terminal getTerminal() {
		Terminal terminal = TerminalFacade.createTerminal(System.in,
				System.out, Charset.forName("UTF8"));
		terminal.enterPrivateMode();
		terminal.clearScreen();
		terminal.setCursorVisible(false);
		return terminal;
	}
}