package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.ClippedGameFacadeFactory;
import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.GameFacadeFactory;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.PresenterFactory;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.terminal.TerminalViewFactory;

import java.nio.charset.Charset;
import java.util.List;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class HugeMapApp {

	public static void main(String[] args) {

		Terminal terminal = getTerminal();
		Size size = getSize(terminal);
		Size sizex5 = new Size(size.getWidth()*5, size.getHeight()*5);

		List<Level> levels = LevelRegistry.getLevels();

		Configuration.init(sizex5, levels);
		
		GameFacadeFactory gameFacadeFactory = new ClippedGameFacadeFactory(size);
		PresenterFactory presenterFactory = new PresenterFactory(gameFacadeFactory);
		TerminalViewFactory viewFactory = new TerminalViewFactory(terminal);
		ViewController controller = new ViewController(viewFactory, presenterFactory);
		controller.run();
		terminal.exitPrivateMode();
	}


	private static Terminal getTerminal() {
		Terminal terminal = TerminalFacade.createTerminal(System.in,
				System.out, Charset.forName("UTF8"));
		terminal.enterPrivateMode();
		terminal.clearScreen();
		terminal.setCursorVisible(false);
		return terminal;
	}

	private static Size getSize(Terminal terminal) {
		TerminalSize terminalSize = terminal.getTerminalSize();
		int width = terminalSize.getColumns();
		int height = terminalSize.getRows();
		
		Size size = new Size(width, height);
		return size;
	}
}