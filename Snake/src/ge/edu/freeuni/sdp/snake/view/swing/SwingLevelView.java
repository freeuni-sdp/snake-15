package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Size;
import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.view.LevelView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SwingLevelView implements LevelView{
	private LevelPresenter _presenter;
	private JPanel panel;
	private JButton okBtn;
	private boolean isLevelSelected;
	private int selection;
	private JFrame frame;
	private JButton levels[];
	
	public SwingLevelView(LevelPresenter presenter) {
		_presenter = presenter;
		frame = new JFrame();
		init(frame);
	}
	
	private void init(JFrame frame){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Size size = Configuration.getInstance().getSize();
		frame.setPreferredSize(new Dimension(size.getWidth(),size.getHeight()));
		frame.setTitle("Snake Levels");
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JScrollPane scroll = new JScrollPane(panel);
		frame.add(scroll,BorderLayout.CENTER);
		
		okBtn = new JButton();
		okBtn.setText("Start Game");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isLevelSelected = true;
				_presenter.setSelection(selection);
				frame.dispose();
			}
		});
		okBtn.setEnabled(false);
		frame.add(okBtn,BorderLayout.SOUTH);
		
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}
	 
	@Override
	public void show() {
		isLevelSelected = false;		
		String[] names = _presenter.getLevelNames();
		levels = new JButton[names.length];
		for (int i = 0; i < names.length; i++) {
			levels[i] = new JButton();
			levels[i].setText(String.format("%d) %s", i+1,names[i]));
			levels[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(levels[i]);
			levels[i].addActionListener(new Action(i));
		}
		
		frame.pack();
		boolean isAccepted = false;
		while(!isAccepted){
			if(isLevelSelected){
				isAccepted = _presenter.setSelection(selection);
			}
		}
	}
	
	private class Action implements ActionListener{
		private int index;
		public Action(int index) {
			this.index = index;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			levels[selection].setBackground(null);
			selection = index;
			okBtn.setEnabled(true);
			levels[index].setBackground(Color.ORANGE);
		}
		
	}	

}
