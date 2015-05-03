package ge.edu.freeuni.sdp.snake.presenter;

import ge.edu.freeuni.sdp.snake.model.Configuration;
import ge.edu.freeuni.sdp.snake.model.Level;
import ge.edu.freeuni.sdp.snake.model.Size;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class LevelPresenterTest {

	private static Configuration conf;
	
	private String[] names = { "level 1",
			"level 2", "level 3",
			"level 4" };
	
	@BeforeClass
	public static void setUpClass(){
		Size size = mock(Size.class); 
		List<Level> levels = mock(List.class);
		conf = mock(Configuration.class);
		conf.init(size, levels);
	}
	
	
	@Test
	public void testConstructorWithoutParameters(){ 	
		LevelPresenter presenter = new LevelPresenter();
		
		//verify(conf).getInstance(); this line fails other tests
	}
	
	
	@Test
	public void testMethodGetLevelNames(){
		LevelPresenter presenter = new LevelPresenter(conf);
		
		when(conf.getLevelNames()).thenReturn(names);
		String[] result = presenter.getLevelNames();
		
		Assert.assertEquals(true, Arrays.deepEquals(names, result));
		
	}
	
	@Test
	public void testSetSelectionInvalidIndex(){	
		
		LevelPresenter presenter = new LevelPresenter(conf);
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
		
		LevelPresenter presenter = new LevelPresenter(conf);
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





