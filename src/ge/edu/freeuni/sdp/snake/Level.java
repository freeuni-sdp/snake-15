package ge.edu.freeuni.sdp.snake;

import java.util.Random;

import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.view.MazeView;
import ge.edu.freeuni.sdp.snake.view.terminal.TerminalMazeView;

import com.google.inject.AbstractModule;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public abstract class Level extends AbstractModule {

	protected Terminal terminal;

	public Level(Terminal terminal) {
		super();
		this.terminal = terminal;
	}

	@Override
	protected void configure() {
		
		bind(Terminal.class).toInstance(terminal);

		Random random = new Random();
		bind(Random.class).annotatedWith(GameRandomizer.class).toInstance(random);
		
		Size size = getSize();
		bind(Size.class).annotatedWith(BoardSize.class).toInstance(size);
		
		bind(MazeView.class).to(TerminalMazeView.class);
	
	}

	private Size getSize() {
		TerminalSize terminalSize = terminal.getTerminalSize();
		int width = terminalSize.getColumns();
		int height = terminalSize.getRows();
		
		Size size = new Size(width, height);
		return size;
	}

}