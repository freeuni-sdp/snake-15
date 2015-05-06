package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;


public class GhostBeingTest {
	final static long CURR_TIME = 1000000;
	static Random random;
	static SystemTime systemTime;
	static Point point;
	static Configuration config;
	static Topology topology;
	
	@BeforeClass
	public static void beforeTestingStarts(){
		topology = Mockito.mock(Topology.class);
		config = Mockito.mock(Configuration.class);
		random = Mockito.mock(Random.class);
		systemTime = Mockito.mock(SystemTime.class);
		point = Mockito.mock(Point.class);
		Mockito.when(random.nextInt(Mockito.anyInt())).thenReturn(1);
		Mockito.when(systemTime.getCurrentTime()).thenReturn(CURR_TIME);
	}

	@Test
	public void testContains() {
		GhostBeing ghostBeing = new GhostBeing(point) {
			
			@Override
			public void interactWith(Being other) {}
			
			@Override
			public BeingKind getKind() { return null; }
		};
		assertTrue(ghostBeing.contains(point));
	}

	@Test
	public void testGetHead() {
		GhostBeing ghostBeing = new GhostBeing(point) {
			
			@Override
			public void interactWith(Being other) {}
			
			@Override
			public BeingKind getKind() { return null; }
		};
		assertEquals(point, ghostBeing.getHead());
	}

	@Test 
	public void testMove() {
		GhostBeing ghostBeing = new GhostBeing(1, point, random, systemTime) {
			
			@Override
			public void interactWith(Being other) {}
			
			@Override
			public BeingKind getKind() { return null; }
		};
		ghostBeing.move(topology, systemTime, config);
		assertEquals(point, ghostBeing.getHead());
		assertEquals(CURR_TIME, ghostBeing.getPreviousTime());
	}

	@Test
	public void testSetDirection() {
		//nothing to test
		assertTrue(true);
	}

	@Test
	public void testGhostBeingPoint() {
		GhostBeing ghostBeing = new GhostBeing(point) {
			
			@Override
			public void interactWith(Being other) {}
			
			@Override
			public BeingKind getKind() { return null; }
		};
		assertEquals(point, ghostBeing.getHead());
		assertEquals(1, ghostBeing.getLives());
	}

	@Test
	public void testGhostBeingIntPointRandomSystemTime() {
		GhostBeing ghostBeing = new GhostBeing(1, point, random, systemTime) {
			
			@Override
			public void interactWith(Being other) {}
			
			@Override
			public BeingKind getKind() { return null; }
		};
		assertEquals(point, ghostBeing.getHead());
		assertEquals(CURR_TIME, ghostBeing.getPreviousTime());
		
	}

}
