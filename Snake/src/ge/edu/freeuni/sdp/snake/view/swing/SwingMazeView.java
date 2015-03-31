package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.view.MazeView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingMazeView implements MazeView{
	@SuppressWarnings("unused")
	private MazePresenter _presenter;
	private JPanel panel;
	private JFrame frame;
	
	public SwingMazeView(MazePresenter presenter) {
		_presenter = presenter;
		frame = new JFrame();
		init(frame);
	}
	
	private void init(JFrame frame){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Size size = Configuration.getInstance().getSize();
		frame.setPreferredSize(new Dimension(size.getWidth(),size.getHeight()));
		frame.setTitle("Snake game");
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JScrollPane scroll = new JScrollPane(panel);
		frame.add(scroll,BorderLayout.CENTER);
		
		
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}
	 
	@Override
	public void show() {
		JTextArea text = new JTextArea();
		text.setText("Game is running");
		panel.add(text);
		frame.pack();
	}	

}
