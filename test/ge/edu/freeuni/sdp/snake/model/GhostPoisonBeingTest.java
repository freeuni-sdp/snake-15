package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import org.junit.Test;
import org.mockito.Mockito;

public class GhostPoisonBeingTest {

	@Test
	public void testGetKind() {
		Point point = Mockito.mock(Point.class);
		GhostPoisonBeing ghostPoison = new GhostPoisonBeing(point);
		BeingKind expected = BeingKind.FoodPoison;
		BeingKind actual = ghostPoison.getKind();
		assertEquals(expected, actual);
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testInteractWith() {
		Point point = Mockito.mock(Point.class);
		Being other = Mockito.mock(Being.class);
		GhostPoisonBeing ghostPoison = new GhostPoisonBeing(point);
		ghostPoison.interactWith(other);
		Mockito.verify(other).kill();
	}
	
	@Test
	public void testInteractWithSpy() {
		Point point = Mockito.mock(Point.class);
		Being other = spy(Being.class);	
		GhostPoisonBeing ghostPoison = new GhostPoisonBeing(point);
		ghostPoison.interactWith(other);
		assertFalse(other.isAlive());
	}

	@Test
	public void testGhostPoisonBeing() {
		Point point = Mockito.mock(Point.class);
		GhostPoisonBeing ghostPoison = new GhostPoisonBeing(point);
		assertEquals(point, ghostPoison.getHead());
	}

}
