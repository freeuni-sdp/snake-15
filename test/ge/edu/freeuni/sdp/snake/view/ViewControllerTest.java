/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.view;

import ge.edu.freeuni.sdp.snake.presenter.GameOverPresenter;
import ge.edu.freeuni.sdp.snake.presenter.HighScorePresenter;
import ge.edu.freeuni.sdp.snake.presenter.LevelPresenter;
import ge.edu.freeuni.sdp.snake.presenter.MazePresenter;
import ge.edu.freeuni.sdp.snake.presenter.PresenterFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author toka
 */
public class ViewControllerTest {
    
    private ViewFactory _viewFactory;
    private PresenterFactory _presenterRegistry;
    private ViewController _controller;
    
    public ViewControllerTest() {
    }
    
    @Before
    public void setUp() {
        _viewFactory = mock(ViewFactory.class);
        _presenterRegistry = mock(PresenterFactory.class);
        _controller = new ViewController(_viewFactory, _presenterRegistry);
    }
    

    @Test
    public void levelPresenterTest() {
        LevelPresenter levelPresenter = mock(LevelPresenter.class);
        LevelView levelView = mock(LevelView.class);
        when(_presenterRegistry.getLevelPresenter()).thenReturn(levelPresenter);
        when(_viewFactory.getLevelView(levelPresenter)).thenReturn(levelView);
        
        MazePresenter mazePresenter = mock(MazePresenter.class);
        MazeView mazeView = mock(MazeView.class);
        when(_presenterRegistry.getMazePresenter()).thenReturn(mazePresenter);
        when(_viewFactory.getMazeView(mazePresenter)).thenReturn(mazeView);
        
        HighScorePresenter highScorePresenter = mock(HighScorePresenter.class);
        HighScoreView highScoreView = mock(HighScoreView.class);
        when(_presenterRegistry.getHighScorePresenter()).thenReturn(highScorePresenter);
        when(_viewFactory.getHighScoreView(highScorePresenter)).thenReturn(highScoreView); 
        
        GameOverPresenter gameOverPresenter = mock(GameOverPresenter.class);
        GameOverView gameOverView = mock(GameOverView.class);
        when(gameOverView.continueGameOrNot()).thenReturn(Boolean.FALSE);
        when(_presenterRegistry.getGameOverPresenter()).thenReturn(gameOverPresenter);
        when(_viewFactory.getGameOverView(gameOverPresenter)).thenReturn(gameOverView);
        
        _controller.run();
        
        verify(levelView, times(1)).show();
        verify(mazeView, times(1)).show();
        verify(highScoreView, times(1)).show();
        verify(gameOverView, times(1)).show();
    }

}
