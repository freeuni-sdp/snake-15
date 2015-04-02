package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.CompositePopulator;
import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.HungrySnakeFactory;
import ge.edu.freeuni.sdp.snake.model.GhostMousePopulator;
import ge.edu.freeuni.sdp.snake.model.GhostPoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.Populator;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.SinglePoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.model.ThreeLivesSnakeFactory;
import ge.edu.freeuni.sdp.snake.model.WormHolePopulator;
import ge.edu.freeuni.sdp.snake.model.WormHoleTopology;
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
				"Very simple", 
				new SphericTopology(),
				new SingleMousePopulator());
		
		Level level2 = new Level(
				"Poison food", 
				new SphericTopology(),
				new SinglePoisonPopulator(),
				new ThreeLivesSnakeFactory());

		Level level3 = new Level(
				"Hungry snake", 
				new SphericTopology(),
				new SingleMousePopulator(),
				new HungrySnakeFactory() );

		Populator[] populators = {new GhostMousePopulator(), new GhostPoisonPopulator()};
		Level level4 = new Level(
				"Ghost mouse and poison", 
				new SphericTopology(),
				new CompositePopulator(populators));

		Level level5 = new Level(
				"Wormhole", 
				new WormHoleTopology(),
				new WormHolePopulator());
		
		levels.add(level1);
		levels.add(level2);
		levels.add(level3);
		levels.add(level4);
		levels.add(level5);

		
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