package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.terminal.TerminalViewFactory;
import ge.edu.freeuni.sdp.snake.model.EvilSnakePopulator;
import ge.edu.freeuni.sdp.snake.model.CompositePopulator;
import ge.edu.freeuni.sdp.snake.model.Populator;

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
				"Very Simple Level", 
				new SphericTopology(),
				new SingleMousePopulator());

		//TODO Add other levels here
		levels.add(level1);
		Populator[] populators = new Populator[2];
		Populator mouse = new SingleMousePopulator();
		Populator snake = new EvilSnakePopulator();
		populators[0] = mouse;
		populators[1] = snake;
		Level level2 = new Level("Evil Snake", new SphericTopology(), new CompositePopulator(populators));
		levels.add(level2);
		Configuration.init(size, levels);
		//interact universe <- gamefacade <- prezenterfactory < mazeprezenter
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