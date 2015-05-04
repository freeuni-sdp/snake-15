package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.Configuration;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class LevelPresenterTest {

	private Configuration conf;
	private LevelPresenter presenter;
	private String[] names = { "level 1",
			"level 2", "level 3",
			"level 4" };
	
	@Before
	public void setUpClass(){
		conf = mock(Configuration.class);
		presenter = new LevelPresenter(conf);
	}
	
	@Test
	public void testMethodGetLevelNames(){
		
		when(conf.getLevelNames()).thenReturn(names);
		String[] result = presenter.getLevelNames();
		
		Assert.assertEquals(true, Arrays.deepEquals(names, result));
		
	}
	
	@Test
	public void testSetSelectionInvalidIndex(){	
		
		LevelPresenter presenterSpy = spy(presenter);
		
		when(presenterSpy.getLevelNames()).thenReturn(names);
				
		boolean result = presenter.setSelection(-1);
		Assert.assertEquals(false, result);
		
		result = presenter.setSelection(1);
		Assert.assertEquals(true, result);
		
		result = presenter.setSelection(4);
		Assert.assertEquals(false, result);
		
		result = presenter.setSelection(9);
		Assert.assertEquals(false, result);
			
	}
	
	@Test
	public void testSetSelectionNotifyLevelSelectionOnNull(){	
		
		LevelPresenter presenterSpy = spy(presenter);
				
		when(presenterSpy.getLevelNames()).thenReturn(names);
				
		LevelSelectionListener listen = mock(LevelSelectionListener.class);
		presenter.setLevelSelectionListener(listen);
		
		when(conf.getSelectedLevelDescription()).thenReturn("level 3");
		
		boolean result = presenter.setSelection(2);
		
		verify(conf).selectLevel(2);
		
		verify(listen).updateDescription("level 3");
		
		Assert.assertEquals(true, result);
			
	}
	
}





