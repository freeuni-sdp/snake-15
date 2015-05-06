package ge.edu.freeuni.sdp.snake.model;

import org.junit.Test;

import org.mockito.Mockito;

import static org.junit.Assert.*;

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
		//nothing to test
	}

	@Test
	public void testGhostMouseBeing() {
		Point point = Mockito.mock(Point.class);
		GhostMouseBeing ghostMouse = new GhostMouseBeing(point);
		assertEquals(point, ghostMouse.getHead());
	}

}
