package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;


public class GhostBeingTest {
	final static long CURR_TIME = 1000000;
	final static long PREV_TIME_TO_MOVE = 990000;
	final static long PREV_TIME_NOT_TO_MOVE = 999900;
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
		Size size = Mockito.mock(Size.class);
		when(size.getWidth()).thenReturn(10);
		when(size.getHeight()).thenReturn(10);
		when(config.getSize()).thenReturn(size);
		Mockito.when(random.nextInt(Mockito.anyInt())).thenReturn(1);
		Mockito.when(systemTime.getCurrentTime()).thenReturn(CURR_TIME);
		Mockito.when(systemTime.getPreviousTime()).thenReturn(PREV_TIME_TO_MOVE);
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
		Mockito.when(systemTime.getPreviousTime()).thenReturn(PREV_TIME_TO_MOVE);
		ghostBeing.move(topology, systemTime, config);
		assertEquals(1, ghostBeing.getHead().X);
		assertEquals(1, ghostBeing.getHead().Y);
	}
	
	@Test 
	public void testDontMove() {
		GhostBeing ghostBeing = new GhostBeing(1, point, random, systemTime) {
			
			@Override
			public void interactWith(Being other) {}
			
			@Override
			public BeingKind getKind() { return null; }
		};
		Mockito.when(systemTime.getPreviousTime()).thenReturn(PREV_TIME_NOT_TO_MOVE);
		ghostBeing.move(topology, systemTime, config);
		assertEquals(point, ghostBeing.getHead());
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
		
	}

}