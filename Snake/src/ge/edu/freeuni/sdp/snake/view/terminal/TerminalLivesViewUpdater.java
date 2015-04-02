package ge.edu.freeuni.sdp.snake.view.terminal;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import ge.edu.freeuni.sdp.snake.presenter.LivesUpdateListener;

public class TerminalLivesViewUpdater implements LivesUpdateListener{

	private Terminal _terminal;
	
	public TerminalLivesViewUpdater(Terminal terminal) {
		_terminal = terminal;
	}

	@Override
	public void updateLives(int newLives) {
		TerminalSize tSize = _terminal.getTerminalSize();
		
		String text = String.format("  lives - %d  ", newLives);
		for(int i=0;i<text.length();i++){
			_terminal.moveCursor(tSize.getColumns()-(text.length() -i),1);
			_terminal.putCharacter(text.charAt(i));
		}
		
	}

}
