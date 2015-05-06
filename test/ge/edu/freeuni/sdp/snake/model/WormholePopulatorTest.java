package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class WormholePopulatorTest {
	private RandomWormHole wormhole;
	private Universe fakeOne;
	Point l;
	Point r;
	@Before
	public void setUp(){
		wormhole=Mockito.mock(RandomWormHole.class);
		fakeOne=Mockito.mock(Universe.class);
		l=new Point(0,0);
		r=new Point(3,3);
		when(wormhole.getLeft()).thenReturn(l);
		when(wormhole.getRight()).thenReturn(r);
		
	}
	@Test(expected = NullPointerException.class)
	public void testUniverseIsNull() {
		WormHolePopulator populator=new WormHolePopulator(wormhole);
		populator.populate(null);
	}
	// test for checking if the populator will populate two different universes
	@Test
	public void testThatItWontPopulateTwoUniverses() {
		WormHolePopulator populator=new WormHolePopulator(wormhole);
		populator.populate(fakeOne);
		Topology t=Mockito.mock(Topology.class);
		Universe notToBePopulated=new Universe(t);
		populator.populate(notToBePopulated);
		assertEquals(null, notToBePopulated.getBeingAt(new Point(l.X+1,l.Y)));
		
	}
	
	//test whether the being added to universe is of correct kind
	@Test
	public void testCorrectPopulation() {
		WormHolePopulator populator=new WormHolePopulator(wormhole);
		Topology t=Mockito.mock(Topology.class);
		Universe uni=new Universe(t);
		populator.populate(uni);
		assertEquals(BeingKind.FoodPoison, uni.getBeingAt(new Point(l.X+1,l.Y)).getKind());
	}
	
	
}
