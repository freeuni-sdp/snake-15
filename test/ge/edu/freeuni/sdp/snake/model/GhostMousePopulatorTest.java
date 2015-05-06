package ge.edu.freeuni.sdp.snake.model;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GhostMousePopulatorTest {

	private Topology topology;
	private Random random;
	private Configuration configuration;
	private Universe universe;
	
	@Before
	public void setUp(){
		topology = mock(SphericTopology.class);
		random = mock(Random.class);
		configuration = mock(Configuration.class);
		universe = new Universe(topology);
	}
	
	@Test
	public void TestVerifyUniverseAddedBeing(){
		
		when(configuration.getSize()).thenReturn(new Size(10,10));
		when(random.nextInt(10)).thenReturn(6);
		GhostMousePopulator target = new GhostMousePopulator(random, configuration);
		target.populate(universe);
		Point point = new Point(6,6);
		assertEquals(universe.getBeingAt(point).getKind(), BeingKind.FoodMouse);
	}
	
	@Test
	public void TestMouseAlreadyExists(){
		
		when(configuration.getSize()).thenReturn(new Size(11,11));
		when(random.nextInt(11)).thenReturn(6);
		Point mousePoint = new Point(5,6);
		GhostMouseBeing mouse = new GhostMouseBeing(mousePoint);
		GhostMousePopulator target = new GhostMousePopulator(random, configuration,mouse);
		target.populate(universe);
		assertEquals(universe.getBeingAt(new Point(6,6)), null);
	}
	
	@Test
	public void TestMouseAlreadyExistsButDead(){
		when(configuration.getSize()).thenReturn(new Size(11,11));
		when(random.nextInt(11)).thenReturn(6);
		Point mousePoint = new Point(5,6);
		GhostMouseBeing mouse = new GhostMouseBeing(mousePoint);
		mouse.kill();
		GhostMousePopulator target = new GhostMousePopulator(random, configuration,mouse);
		target.populate(universe);
		assertEquals(universe.getBeingAt(new Point(6,6)).getKind(), BeingKind.FoodMouse);
	}
	
}
