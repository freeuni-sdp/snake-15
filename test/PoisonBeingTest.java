import ge.edu.freeuni.sdp.snake.model.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import static org.junit.Assert.*;

public class PoisonBeingTest {

	@Test
	public void kind_is_FoodPoison() {
		// Classic
		PoisonBeing target = new PoisonBeing(new Point(0, 0));
		BeingKind actual = target.getKind();
		assertEquals(BeingKind.FoodPoison, actual);
	}

	@Test
	public void interact_with_other__make_sure_other_is_killed() {
		// Using mock
		PoisonBeing target = new PoisonBeing(new Point(0, 0));
		Being other = mock(Being.class);
		target.interactWith(other);
		verify(other).kill();
	}

	@Test
	public void constructor_sets_head() {
		// Using fake + classic
		Point point = mock(Point.class);
		PoisonBeing target = new PoisonBeing(point);
		assertEquals(point, target.getHead());
	}
	
	@Test
	public void asserting_isAlive_value_on_stub_without_mocking_the_method() {
		Being other = spy(Being.class);
		assertTrue(other.isAlive());
		other.kill();
		assertFalse(other.isAlive());
	}

}