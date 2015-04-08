
import ge.edu.freeuni.sdp.snake.model.*;
import static org.easymock.EasyMock.*;

import org.easymock.MockType;
import org.junit.Assert;
import org.junit.Test;

public class TestX {

	@Test
	public void testClassic() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testWithMock() {
		PoisonBeing target = new PoisonBeing(null);
		
		Being mock = createMock(MockType.NICE, MouseBeing.class);
		/* expect */ mock.kill();
		replay(mock);
		
		target.interactWith(mock);
		verify(mock);;
	}

}
