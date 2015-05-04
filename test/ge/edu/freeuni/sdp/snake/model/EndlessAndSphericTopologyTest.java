package ge.edu.freeuni.sdp.snake.model;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class EndlessAndSphericTopologyTest {
	
	private Configuration conf;
	private SphericTopology topology; 
	private Size size;

	
	@Before
	public void setUp(){ 
		conf = mock(Configuration.class);
		size = mock(Size.class); 
		when(conf.getSize()).thenReturn(size);
		when(size.getWidth()).thenReturn(100);
		when(size.getHeight()).thenReturn(30);
		topology = new SphericTopology(conf);
	}
	
	@Test
	public void testWestWallIntersection(){
		Point testPoint = new Point(0, 16);
		Direction leftDir = Direction.LEFT;
		
		Point actualResult = new Point(99,16);
		
		
		Point result =  topology.getNextTo(testPoint, leftDir);
		
		Assert.assertEquals(actualResult.X, result.X);
		Assert.assertEquals(actualResult.Y, result.Y);
	}
	
	@Test
	public void testEastWallIntersection(){
		
		Point testPoint = new Point(99,15);
		Direction rightDir = Direction.RIGHT;
		
		Point actualResult = new Point(0,15);
		
		Point result =  topology.getNextTo(testPoint, rightDir);
		
		Assert.assertEquals(actualResult.X, result.X);
		Assert.assertEquals(actualResult.Y, result.Y);
	}
	
	@Test
	public void testNorthWallIntersection(){
		Point testPoint = new Point(66,0);
		Direction upDir = Direction.UP;
		
		Point actualResult = new Point(66,29); 
		
		Point result =  topology.getNextTo(testPoint, upDir);
		
		Assert.assertEquals(actualResult.X, result.X);
		Assert.assertEquals(actualResult.Y, result.Y);
	}
	
	@Test
	public void testSouthWallIntersection(){
		Point testPoint = new Point(56,29);
		Direction downDir = Direction.DOWN;
		
		Point actualResult = new Point(56,0);
		
		Point result =  topology.getNextTo(testPoint, downDir);
		
		Assert.assertEquals(actualResult.X, result.X);
		Assert.assertEquals(actualResult.Y, result.Y);	
	}
}
