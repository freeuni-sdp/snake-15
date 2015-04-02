package ge.edu.freeuni.sdp.snake.view.terminal;

import java.util.StringTokenizer;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;

import ge.edu.freeuni.sdp.snake.presenter.HighScorePresenter;
import ge.edu.freeuni.sdp.snake.view.HighScoreView;

public class TerminalHighScoreView implements HighScoreView {

	private Terminal _terminal;
	private HighScorePresenter _presenter;

	public TerminalHighScoreView(HighScorePresenter presenter, Terminal terminal) {
		_presenter = presenter;
		_terminal = terminal;
	}
	
	private void waitForResponse(int x,int y,int score){
		boolean newHighScore = _presenter.checkNewScore(score);
		if(newHighScore){
			writeLine("Please enter your name:");
			String name = "";
			while (true) {
				Key p = _terminal.readInput();
				if (p == null) continue;
				if (p.getKind() == Kind.Enter) break;
				char ch = p.getCharacter();
				_terminal.moveCursor(x, y);
				name = name + ch;
				writeLine(name);
			}
			_presenter.changeHighScoreInfo(name, score);
		} else {
			writeLine("To continue click anything...");
			while (true) {
				Key p = _terminal.readInput();
				if (p != null) break;	
			}
		}
		
	}
	
	@Override
	public void show() {
		_terminal.clearScreen();
		int x = _terminal.getTerminalSize().getColumns() / 2 - 8;
		int y = _terminal.getTerminalSize().getRows() / 2 - 8;
		_terminal.moveCursor(x, y++);
		int score = _presenter.getScore();
		writeLine("Your score: " + score);
		_terminal.moveCursor(x, y++);
		writeLine("High scores:");
		_terminal.moveCursor(x, y);
		String fileContent = _presenter.getHighScoreInfo();
		StringTokenizer st = new StringTokenizer(fileContent, "\n");
		while (st.hasMoreElements()) {
			writeLine(st.nextToken());
			_terminal.moveCursor(x, ++y);
		}
		waitForResponse(x,++y,score);	
	}
	
	private void writeLine(String print) {
		char[] printToChar = print.toCharArray();
		for (int i = 0; i < print.length(); i++) {
			_terminal.putCharacter(printToChar[i]);
		}
	}

}
