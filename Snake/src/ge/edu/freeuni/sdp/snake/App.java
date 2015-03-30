package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.terminal.TerminalViewFactory;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class App {

	public static void main(String[] args) {

		Terminal terminal = getTerminal();
		Size size = getSize(terminal);

		List<Level> levels = new ArrayList<Level>();

		Level level1 = new Level(
				"Level A",
				"Very simple level", 
				new SphericTopology(),
				new SingleMousePopulator());
		Level level2 = new Level(
				"Level B",
				"Same simple level as above", 
				new SphericTopology(),
				new SingleMousePopulator());
		Level level3 = new Level(
				"Level C",
				"Still the same", 
				new SphericTopology(),
				new SingleMousePopulator());

		//TODO Add other levels here
		levels.add(level1);
		levels.add(level2);
		levels.add(level3);

		Configuration.init(size, levels);
		
		TerminalViewFactory viewFactory = new TerminalViewFactory(terminal);
		ViewController controller = new ViewController(viewFactory);
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