package ge.edu.freeuni.sdp.snake.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class HungrySnakeTest {

	
	
	/*
	 * tests if being is Snake
	 */
	@Test
	public void BeingIsSnake(){
		Point point = mock(Point.class);
		HungrySnake target = new HungrySnake(point,1);
		BeingKind actual = target.getKind();
		assertEquals(BeingKind.Snake, actual);
	}

	
	/*
	 * Tests if head is set correctly
	 */
	@Test
	public void ConstructorSetsHead() {
		Point point = mock(Point.class);
		HungrySnake target = new HungrySnake(point,1);
		assertEquals(point, target.getHead());
	}
	
	/*
	 * Tests if head moves correctly
	 */
	@Test
	public void TestMoveToNormal(){
		HungrySnake target = new HungrySnake(new Point(5, 5),2);
		Point point = new Point(4,5);
		target.moveTo(point);
		assertEquals(target.getHead().X,point.X);
		assertEquals(target.getHead().Y,point.Y);
	}
	
	/*
	 * Tests if Limit is Reached and Snake length is Decreased
	 */
	@Test
	public void TestMoveToLimitIsReachedAndLengthDecreases(){
		HungrySnake target = new HungrySnake(new Point(5, 5),1);
		Point point = new Point(4,5);
		target.moveTo(point);
		assertEquals(target.getLength(),2);
	}
	
	
	
	/*
	 * tests if Snake kills other	
	 */
	@Test
	public void TestInteractWithOtherIsKilled(){
		Point point = mock(Point.class);
		HungrySnake target = new HungrySnake(point,1);
		Being other = mock(Being.class);
		target.interactWith(other);
		verify(other).kill();
	}
	
	/*
	 * tests if Snake length is increased	
	 */
	@Test
	public void TestInteractWithLengthIsChanged(){
		Point point = mock(Point.class);
		HungrySnake target = new HungrySnake(point,1);
		Being other = mock(Being.class);
		target.interactWith(other);
		Assert.assertEquals(4, target.getLength());
	}
	
	/*
	 * tests if snake kills someone and move limit isn't reached
	 */
	@Test
	public void TestMoveToAndInteractWith(){
		Point firstPoint = new Point(5,5);
		Point secondPoint = new Point(4,5);
		HungrySnake target = new HungrySnake(firstPoint,2);
		Being other = mock(Being.class);
		target.moveTo(secondPoint);
		target.interactWith(other);
		target.moveTo(firstPoint);
		Assert.assertEquals(4, target.getLength());
	}
	
	
	/*
	 * tests if Snake kills someone but after 2 moves limit
	 * is reached and length is decreased
	 */
	@Test
	public void TestMoveToAndInteractWithTwiceAndDecreasedLength(){
		Point firstPoint = new Point(5,5);
		Point secondPoint = new Point(4,5);
		HungrySnake target = new HungrySnake(firstPoint,2);
		Being other = mock(Being.class);
		target.moveTo(secondPoint);
		target.interactWith(other);
		target.moveTo(firstPoint);
		target.moveTo(secondPoint);
		Assert.assertEquals(3, target.getLength());
	}
	
}

