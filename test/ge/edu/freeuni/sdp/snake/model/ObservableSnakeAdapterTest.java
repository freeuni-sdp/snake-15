package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ObservableSnakeAdapterTest {
	
	@Test
	public void testConstructor(){
		Point pointMock = mock(Point.class);
		Direction dirMock = mock(Direction.class);
		
		ObservableSnakeAdapter target = new ObservableSnakeAdapter(pointMock);
		Point head = target.getHead();
		assertEquals(pointMock.X, head.X);
		assertEquals(pointMock.Y, head.Y);
		
		target = new ObservableSnakeAdapter(new Point(0, 0),dirMock);
		Direction targetDir = target.getDirection();
		assertEquals(dirMock, targetDir);
	}

	@Test
	public void testSetDirection() {
		ObservableMouseBeing mockObserver = mock(ObservableMouseBeing.class);
		ObservableSnakeAdapter target = new ObservableSnakeAdapter(new Point(2, 2));
		target.setDirection(Direction.LEFT);
		assertNotEquals(Direction.LEFT, target.getDirection());
		target.setDirectionObserver(mockObserver);
		target.setDirection(Direction.LEFT);
		verify(mockObserver).notifyDirectionSet(Direction.LEFT);
	}
	
	@Test
	public void testNotifyMoveTo_Direction_Change() {
		Point point = new Point(2, 2);
		ObservableSnakeAdapter target = new ObservableSnakeAdapter(point);
		target.notifyMoveTo(new Point(1, 2));
		assertEquals(target.getDirection(), Direction.LEFT);
	}
	
	@Test
	public void testNotifyMoveTo_No_Direction_Change() {
		Point point = new Point(2, 2);
		ObservableSnakeAdapter target = new ObservableSnakeAdapter(point);
		target.notifyMoveTo(new Point(3, 2));
		assertEquals(target.getDirection(), Direction.RIGHT);
	}

}
