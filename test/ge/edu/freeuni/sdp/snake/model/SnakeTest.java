package ge.edu.freeuni.sdp.snake.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SnakeTest {

	private Configuration conf;
	
	@Before
	public void setUp(){
		conf = mock(Configuration.class);
	}
	
	
	@Test
	public void checkTwoParameterConstructor(){
		Being mockBeing = mock(Being.class);
		when(mockBeing.getLives()).thenReturn(6);
				
		Snake target = new Snake(new Point(6,5),6,conf);
		
		Assert.assertEquals(3, target.getLength());
		Assert.assertEquals(6, target.getLives());
		
		Point head = target.getHead();
		Point expected = new Point(6, 5);
		
		Assert.assertEquals(expected.X, head.X);
		Assert.assertEquals(expected.Y, head.Y);
			
	}
	
	
	@Test
	public void testContains(){
		Point point1 = new Point(6, 5);
		Point point2 = new Point(10, 10);
		
		Snake target = new Snake(point1,1,conf);
		
		Assert.assertEquals(true, target.contains(point1));
		Assert.assertEquals(false, target.contains(point2));
	}
	
	@Test
	public void kindIsSnake() {
		Snake target = new Snake(new Point(6, 5),1,conf);
		BeingKind actual = target.getKind();
		Assert.assertEquals(BeingKind.Snake, actual);
	}

	@Test
	public void interactWithOtherMakeSureOtherIsKilledAndCheckGrow() {
		Snake target = new Snake(new Point(6, 5),1,conf);
		Being other = mock(Being.class);
		target.interactWith(other);
		verify(other).kill();
		Assert.assertEquals(4, target.getLength());
	}
	
	
	@Test
	public void testMoveTo(){
		Point point1 = new Point(50, 15);
		Point point2 = new Point(51, 15);
		Point point3 = new Point(52, 15);
		
		Point point4 = new Point(53, 15);
		
		Snake target = new Snake(point1,1,conf);
		target.moveTo(point2);
		target.moveTo(point3);
		
		Assert.assertEquals(true, target.contains(point1));
		Assert.assertEquals(true, target.contains(point2));
		Assert.assertEquals(true, target.contains(point3));
		Assert.assertEquals(false, target.contains(point4));
		
		target.moveTo(point4);
		
		Assert.assertEquals(false, target.contains(point1));
		Assert.assertEquals(true, target.contains(point2));
		Assert.assertEquals(true, target.contains(point3));
		Assert.assertEquals(true, target.contains(point4));
		
	}
	
	
	@Test
	public void testSaveMemento(){
		when(conf.getSelectedLevelIndex()).thenReturn(0);
				
		Snake target = new Snake(new Point(6,5),1,conf);
		
		target.setDirection(Direction.LEFT);
		
		Memento result = target.saveToMemento();
		
		Assert.assertEquals(3, result.getLength());
		Assert.assertEquals("left",result.getDirectionString());
		Assert.assertEquals(6, result.getHead().X);
		Assert.assertEquals(5, result.getHead().Y);
		Assert.assertEquals(0, result.getLevelIndex());			
	}
	
	
	@Test
	public void testRestoreFromMemento(){
		Memento mockMemento = mock(Memento.class);
	
		when(mockMemento.getHead()).thenReturn(new Point(6,5));
		when(mockMemento.getLength()).thenReturn(3);
		
		when(conf.getSelectedLevelIndex()).thenReturn(0);
		
		Snake target = new Snake(new Point(6,5),1,conf);
		
		target.restoreFromMemento(mockMemento);
		
		Assert.assertEquals(3, target.getLength());
		Assert.assertEquals(6, target.getHead().X);
		Assert.assertEquals(5, target.getHead().Y);			
	}
	
}
