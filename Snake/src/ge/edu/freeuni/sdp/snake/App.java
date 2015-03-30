package ge.edu.freeuni.sdp.snake;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.SingleMousePopulator;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.model.SphericTopology;
import ge.edu.freeuni.sdp.snake.presenter.PresenterFactory;
import ge.edu.freeuni.sdp.snake.view.ViewController;
import ge.edu.freeuni.sdp.snake.view.ViewFactory;
import ge.edu.freeuni.sdp.snake.view.swing.SwingViewFactory;

import java.awt.GridLayout;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class App {

	public static void main(String[] args) {

		Terminal terminal = getTerminal();
		Size size = getSize(terminal);

		List<Level> levels = new ArrayList<Level>();

		Level level1 = new Level("Very Simple Level", new SphericTopology(),
				new SingleMousePopulator());

		// TODO Add other levels here
		levels.add(level1);

		Configuration.init(size, levels);

		// ViewFactory viewFactory = new TerminalViewFactory(terminal);
		ViewFactory viewFactory = new SwingViewFactory(createFrame());
		ViewController controller = new ViewController(viewFactory,
				new PresenterFactory());
		controller.run();

		System.out.println("Hello");

		terminal.exitPrivateMode();

		// createFrame();
	}

	private static JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Snake");
		frame.setLayout(new GridLayout(10, 10, 0, 0));

		// Screen screen = new Screen();
		// frame.add(screen);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;

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