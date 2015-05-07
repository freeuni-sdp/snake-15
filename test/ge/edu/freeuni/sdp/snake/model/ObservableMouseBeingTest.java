package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ObservableMouseBeingTest {

	@Test
	public void testConstructor(){
		Point pointMock = mock(Point.class);
		Direction dirMock = mock(Direction.class);
		
		ObservableMouseBeing target = new ObservableMouseBeing(pointMock);
		Point head = target.getHead();
		assertEquals(pointMock.X, head.X);
		assertEquals(pointMock.Y, head.Y);
		
		target = new ObservableMouseBeing(new Point(0, 0),dirMock);
		Direction targetDir = target.getDirection();
		assertEquals(dirMock, targetDir);
	}
	
	@Test
	public void testMoveTo() {
		Point mockHead = mock(Point.class);
		Point targetHead = mock(Point.class);
		Point targetNext1 = mock(Point.class);
		Point targetNext2 = mock(Point.class);
		ObservableSnakeAdapter mock = new ObservableSnakeAdapter(mockHead);
		ObservableMouseBeing target = new ObservableMouseBeing(targetHead);
		target.moveTo(targetNext1);
		Point actualHead = target.getHead();
		assertEquals(targetHead.X,actualHead.X);
		assertEquals(targetHead.Y,actualHead.Y);
		target.setPositionObserver(mock);
		try{
			target.moveTo(targetNext2);
		}catch (IllegalStateException e) {
			
		}
		assertEquals(Direction.RIGHT,mock.getDirection());
	}
	
	@Test
	public void testNotifyDirectionSet(){
		ObservableMouseBeing target = new ObservableMouseBeing(new Point(0, 0));
		target.notifyDirectionSet(Direction.LEFT);
		assertEquals(Direction.LEFT, target.getDirection());
	}

}
