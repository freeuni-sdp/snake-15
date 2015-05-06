package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.GameFacade;
import ge.edu.freeuni.sdp.snake.model.HighScoreData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

public class HighScorePresenterTest {

	@Test
	public void game_is_over(){
		GameFacade game = mock(GameFacade.class);
		when(game.isGameOver()).thenReturn(true);
		HighScoreData data = mock(HighScoreData.class);
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		assertTrue(presenter.isGameOver());
	}
	
	@Test
	public void is_score_correct(){
		GameFacade game = mock(GameFacade.class);
		when(game.getScore()).thenReturn(5);
		HighScoreData data = mock(HighScoreData.class);
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		assertTrue(5==presenter.getScore());
	}
	
	@Test
	public void is_high_score_info_correct(){
		GameFacade game = mock(GameFacade.class);
		HighScoreData data = mock(HighScoreData.class);
		String file = "File";
		when(data.getFileContent()).thenReturn(file);
		
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		assertEquals(file,presenter.getHighScoreInfo());
		verify(data).readFile();
	}
	
	@Test
	public void is_HighScoreData_invocation_order_correct(){
		GameFacade game = mock(GameFacade.class);
		HighScoreData data = mock(HighScoreData.class);
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		presenter.getHighScoreInfo();
		InOrder inOrder = inOrder(data);
		inOrder.verify(data).readFile();
		inOrder.verify(data).getFileContent();
	}
	
	@Test
	public void is_editFile_called(){
		GameFacade game = mock(GameFacade.class);
		HighScoreData data = mock(HighScoreData.class);
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		String name = "Giorgi";
		int score = 100;
		presenter.changeHighScoreInfo(name,score);
		verify(data).editFile(name,score);
	}
	
	@Test
	public void file_must_be_changed(){
		GameFacade game = mock(GameFacade.class);
		HighScoreData data = mock(HighScoreData.class);
		when(data.checkIfFileMustBeEdited(anyInt())).thenReturn(1);
		
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		assertTrue(presenter.checkNewScore(10));
	}
	
	@Test
	public void file_must_not_be_changed(){
		GameFacade game = mock(GameFacade.class);
		HighScoreData data = mock(HighScoreData.class);
		when(data.checkIfFileMustBeEdited(anyInt())).thenReturn(-1);
		
		HighScorePresenter presenter= new HighScorePresenter(data, game);
		assertFalse(presenter.checkNewScore(10));
	}
}
