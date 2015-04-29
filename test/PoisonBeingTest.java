
import ge.edu.freeuni.sdp.snake.model.*;
import static org.easymock.EasyMock.*;

import org.junit.Assert;
import org.junit.Test;

public class TestX {

	@Test
	public void testClassic() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testWithMock() {
		PoisonBeing targetPoison = new PoisonBeing(new Point(0,0));
		
		Being mockOther = createStrictMock(Being.class);
		/* expect */ mockOther.kill();
		expectLastCall().once();
		replay(mockOther);
		
		targetPoison.interactWith(mockOther);
		verify(mockOther);;
	}

}
