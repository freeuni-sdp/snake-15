package ge.edu.freeuni.sdp.snake.model;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class EndlessAndSphericTopologyTest {
	
	private SphericTopology topology; 

	
	@BeforeClass
	public static void setUpClass(){
		Size size = new Size(100, 30); 
		List<Level> levels = mock(List.class);
		Configuration.init(size, levels);
	}
	
	@Before
	public void setUp(){ 
		topology = new SphericTopology();
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
