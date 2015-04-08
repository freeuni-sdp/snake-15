package ge.edu.freeuni.sdp.snake.view.swing;

import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.view.LevelView;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class SwingLevelView extends JDialog implements LevelView{

	private static final long serialVersionUID = -4256335333476990417L;
	private LevelPresenter _presenter;
	
	public SwingLevelView(LevelPresenter presenter, JFrame parent) {
		super(parent);		
		_presenter = presenter;
		init();
	}
	
	private void init() {
		setModal(true);
		setLayout(new GridLayout(8,8,8,8));
		
		String[] names = _presenter.getLevelNames();
		
		
		JButton okButton = new JButton();
		okButton.setText("Start Game");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		
		ActionListener radioButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				int selection = Integer.parseInt(arg.getActionCommand());
				_presenter.setSelection(selection);
			}
		};
		
		for (int i = 0; i < names.length; i++) {
			JRadioButton levelButton = new JRadioButton();
			levelButton.setText(String.format("%d) %s", i+1,names[i]));
			levelButton.addActionListener(radioButtonListener);
			levelButton.setActionCommand(Integer.toString(i));
			group.add(levelButton);
			add(levelButton);
			if (i==0) {
				levelButton.setSelected(true);
				_presenter.setSelection(0);
			}
		}

		add(okButton);
		this.pack();
		center();
	}
	
	public void center() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(
				dim.width/2-getSize().width/2, 
				dim.height/2-getSize().height/2);
	}
	 
	@Override
	public void showDescription(String description) {
		
	}	
}
