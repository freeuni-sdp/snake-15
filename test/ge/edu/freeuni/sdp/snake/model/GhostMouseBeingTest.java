package ge.edu.freeuni.sdp.snake.model;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

public class GhostMouseBeingTest {

	@Test
	public void testGetKind() {
		Point point = Mockito.mock(Point.class);
		GhostMouseBeing ghostMouse = new GhostMouseBeing(point);
		BeingKind expected = BeingKind.FoodMouse;
		BeingKind actual = ghostMouse.getKind();
		assertEquals(expected, actual);
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testInteractWith() {
		Point point = Mockito.mock(Point.class);
		Being other = spy(Being.class);	
		GhostMouseBeing ghostMouse = new GhostMouseBeing(point);
		ghostMouse.interactWith(other);
		assertTrue(other.isAlive());
	}

	@Test
	public void testGhostMouseBeing() {
		Point point = Mockito.mock(Point.class);
		GhostMouseBeing ghostMouse = new GhostMouseBeing(point);
		assertEquals(point, ghostMouse.getHead());
	}

}
