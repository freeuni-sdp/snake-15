package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.CompositePopulator;
import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.HungrySnakeFactory;
import ge.edu.freeuni.sdp.snake.model.GhostMousePopulator;
import ge.edu.freeuni.sdp.snake.model.GhostPoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.Populator;
import ge.edu.freeuni.sdp.snake.model.RandomWormHole;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.SinglePoisonPopulator;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.model.ThreeLivesSnakeFactory;
import ge.edu.freeuni.sdp.snake.model.WormHolePopulator;
import ge.edu.freeuni.sdp.snake.model.WormHoleTopology;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.terminal.TerminalViewFactory;
import ge.edu.freeuni.sdp.snake.model.EvilSnakePopulator;

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

		Level levelVerySimple = new Level(
				"Very simple",
				"Mice appair one by one on random positions.",
				new SphericTopology(),
				new SingleMousePopulator());
		
		Level levelPoisonFood = new Level(
				"Poison food", 
				"Snake has three lives.",
				new SphericTopology(),
				new SinglePoisonPopulator(),
				new ThreeLivesSnakeFactory());

		Level levelHungrySnake = new Level(
				"Hungry snake",
				"Snake will shrink if it will get no food during 10 moves.",
				new SphericTopology(),
				new SingleMousePopulator(),
				new HungrySnakeFactory() );

		Level levelGhostMouse = new Level(
				"Ghost mouse and poison", 
				new SphericTopology(),
				new CompositePopulator(
						new Populator[] {
								new GhostMousePopulator(), 
								new GhostPoisonPopulator()}));

		RandomWormHole wormhole = new RandomWormHole();
		Level levelWormhole = new Level(
				"Wormhole", 
				new WormHoleTopology(wormhole),
				new CompositePopulator(
						new Populator[] {
								new SingleMousePopulator(), 
								new WormHolePopulator(wormhole)}));

		Level levelEvilSnake = new Level(
				"Evil snake", 
				new SphericTopology(),
				new CompositePopulator(
						new Populator[] {
								new SingleMousePopulator(), 
								new EvilSnakePopulator()}));

		levels.add(levelVerySimple);
		levels.add(levelPoisonFood);
		levels.add(levelHungrySnake);
		levels.add(levelGhostMouse);
		levels.add(levelWormhole);
		levels.add(levelEvilSnake);

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