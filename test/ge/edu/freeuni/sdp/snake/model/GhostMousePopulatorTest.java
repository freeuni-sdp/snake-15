package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GhostMousePopulatorTest {

	//not finished yet
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void TestVerifyUniverseAddedBeing(){
		Topology topology = mock(SphericTopology.class);
		Random random = mock(Random.class);
		Configuration configuration = mock(Configuration.class);
		when(configuration.getSize()).thenReturn(new Size(10,10));
		when(random.nextInt(10)).thenReturn(6);
		GhostMousePopulator target = new GhostMousePopulator(random, configuration);
		Universe universe = new Universe(topology);
		target.populate(universe);
		Point point = new Point(6,6);
		assertEquals(universe.getBeingAt(point).getKind(), BeingKind.FoodMouse);
	}
	
	//not finished yet
	//@Test
	public void Test(){
		Topology topology = mock(SphericTopology.class);
		Random random = mock(Random.class);
		Configuration configuration = mock(Configuration.class);
		when(configuration.getSize()).thenReturn(new Size(11,11));
		when(random.nextInt(11)).thenReturn(6);
		when(random.nextInt(10)).thenReturn(-6);
		GhostMousePopulator target = new GhostMousePopulator(random, configuration);
		Universe universe = new Universe(topology);
		target.populate(universe);
		Point point = new Point(6,6);
		universe.getBeingAt(point).move(topology);// isAlive Is Now False
	//	assertEquals(universe.getBeingAt(point).isAlive(), false);
	}
	
	
	
}
