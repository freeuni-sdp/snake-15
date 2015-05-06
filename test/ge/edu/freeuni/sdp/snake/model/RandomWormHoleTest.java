package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class RandomWormHoleTest {
	// Cases will be tested on 4 different kinds of grids, according to whether they have 
	// odd or even height and width.
	private static Configuration oddHeightEvenWidth;
	private static Configuration evenHeightOddWidth;
	private static Configuration oddSquare;
	private static Configuration evenSquare;
	private static Random random;

	@BeforeClass
	public static void before_test() {
		oddHeightEvenWidth = mock(Configuration.class);
		evenHeightOddWidth = mock(Configuration.class);
		oddSquare = mock(Configuration.class);
		evenSquare = mock(Configuration.class);
		Size size1 = mock(Size.class);
		Size size2 = mock(Size.class);
		Size size3 = mock(Size.class);
		Size size4 = mock(Size.class);
		when(size1.getWidth()).thenReturn(100);
		when(size1.getHeight()).thenReturn(37);
		when(oddHeightEvenWidth.getSize()).thenReturn(size1);
		when(size2.getWidth()).thenReturn(37);
		when(size2.getHeight()).thenReturn(100);
		when(evenHeightOddWidth.getSize()).thenReturn(size2);
		when(size3.getWidth()).thenReturn(37);
		when(size3.getHeight()).thenReturn(37);
		when(oddSquare.getSize()).thenReturn(size3);
		when(size4.getWidth()).thenReturn(100);
		when(size4.getHeight()).thenReturn(100);
		when(evenSquare.getSize()).thenReturn(size4);
		random = mock(Random.class);
		when(random.nextInt(anyInt())).thenReturn(0);
	}
	
	//Following 8 tests are about checking distance from boundary and checking that
	// right point is in the right side and left in the left side.
	@Test
	public void must_be_left_top_point_on_oddHeightEvenWidth(){
		Point point= new RandomWormHole(random,oddHeightEvenWidth).getLeft();
		assertTrue(3 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_left_top_point_on_evenHeightOddWidth(){
		Point point= new RandomWormHole(random,evenHeightOddWidth).getLeft();
		assertTrue(3 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_left_top_point_on_oddSquare(){
		Point point= new RandomWormHole(random,oddSquare).getLeft();
		assertTrue(3 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_left_top_point_on_evenSquare() {
		Point point= new RandomWormHole(random,evenSquare).getLeft();
		assertTrue(3 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_middle_top_point_on_oddHeightEvenWidth(){
		Point point= new RandomWormHole(random,oddHeightEvenWidth).getRight();
		assertTrue(50 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_middle_top_point_on_evenHeightOddWidth() {
		Point point= new RandomWormHole(random,evenHeightOddWidth).getRight();
		assertTrue(18 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_middle_top_point_on_oddSquare(){
		Point point= new RandomWormHole(random,oddSquare).getRight();
		assertTrue(18 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void must_be_middle_top_point_on_evenSquare(){
		Point point= new RandomWormHole(random,evenSquare).getRight();
		assertTrue(50 == point.X);
		assertTrue(3 == point.Y);
	}

	@Test
	public void left_must_be_same_after_first_call(){
		RandomWormHole hole = new RandomWormHole(random,oddHeightEvenWidth);
		Point point=hole.getLeft();
		assertTrue(3 == point.X);
		assertTrue(3 == point.Y);
		point=hole.getLeft();
		assertTrue(3 == point.X);
		assertTrue(3 == point.Y);
	}
	
	@Test
	public void right_must_be_same_after_first_call(){
		RandomWormHole hole = new RandomWormHole(random,oddHeightEvenWidth);
		Point point=hole.getRight();
		assertTrue(50 == point.X);
		assertTrue(3 == point.Y);
		point=hole.getRight();
		assertTrue(50 == point.X);
		assertTrue(3 == point.Y);
	}
}
