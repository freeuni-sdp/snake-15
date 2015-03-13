package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
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

		Terminal terminal = TerminalFacade.createTerminal(System.in,
				System.out, Charset.forName("UTF8"));
		terminal.enterPrivateMode();
		terminal.clearScreen();
		terminal.setCursorVisible(false);

		TerminalSize size = terminal.getTerminalSize();
		int width = size.getColumns();
		int height = size.getRows();

		List<Level> levels = new ArrayList<Level>();

		Level level1 = new Level(
				"Very Simple Level", 
				new SphericTopology(),
				new SingleMousePopulator());

		levels.add(level1);

		Configuration.init(width, height, levels);
		Configuration.getInstance().selectLevel(0);
	
		TerminalViewFactory viewFactory = new TerminalViewFactory(terminal);
		ViewController controller = new ViewController(viewFactory);
		controller.run();
	}
}