/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author toka
 */
public class UniverseTest {
    
    private List<Being> _population;
    private Topology _topology;
    private Universe _universe;
    
    public UniverseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        _topology = mock(Topology.class);
        _population = new ArrayList<>();
        _universe = new Universe(_topology, _population);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void moveTest() {
        fillBeingList(2);
        _universe.move();
        
        for (Being _population1 : _population) {
            verify(_population1, times(1)).move(_topology);
        }

    }
    
    @Test
    public void interactTest(){
        fillBeingList(3);
        Point p = mock(Point.class);
        for (Being pop : _population) {
            when(pop.getHead()).thenReturn(p);
            when(pop.contains(p)).thenReturn(Boolean.TRUE);
        }
        
        _universe.interact();
        
        for (Being being1 : _population)
            for (Being being2 : _population)
                if(being1 != being2)
                    verify(being1, times(1)).interactWith(being2);
    }
    
    @Test
    public void interactUntouchedTest(){
        Being being1 = mock(Being.class);
        Being being2 = mock(Being.class);
        Point head = mock(Point.class);
        
        when(being1.getHead()).thenReturn(head);
        when(being2.getHead()).thenReturn(head);
        
        when(being1.contains(head)).thenReturn(Boolean.FALSE);
        when(being2.contains(head)).thenReturn(Boolean.FALSE);
        
        _population.add(being1);
        _population.add(being2);
        
        _universe.interact();
        
        verify(being1, times(0)).interactWith(being2);
        verify(being2, times(0)).interactWith(being1);
    }
    
    @Test
    public void selfInteractTest(){
        Being being = mock(Being.class);
        when(being.getHead()).thenReturn(mock(Point.class));
        _population.add(being);
        
        _universe.interact();
        
        verify(being, times(0)).interactWith(being);   
    }
    
    @Test
    public void removeZombieTest(){
        Being being1 = spy(Being.class);
        Being being2 = spy(Being.class);
        assertTrue(being1.isAlive());
        assertTrue(being2.isAlive());
        
        being1.kill();
        assertFalse(being1.isAlive());
        
        _population.add(being1);
        _population.add(being2);
        
        _universe.removeZombies();
        
        assertEquals(_population.size(), 1);
        
        assertFalse(_population.contains(being1));
        assertTrue(_population.contains(being2));
        
    }
    
    @Test
    public void getExistingBeingTest(){
        Point p = new Point(0, 0);
        Being being = mock(Being.class);
        when(being.contains(p)).thenReturn(Boolean.TRUE);
        
        _population.add(being);
        
        Being result = _universe.getBeingAt(p);
        
        assertEquals(being, result);
    }
    
    @Test
    public void getMissingBeingTest(){
        Point p = new Point(0, 0);
        fillBeingList(5);
        for(Being being : _population)
            when(being.contains(p)).thenReturn(Boolean.FALSE);
                
        Being result = _universe.getBeingAt(p);

        assertEquals(null, result);
        for(Being being : _population)
            verify(being).contains(p);
    }
    
    @Test
    public void addBeingTest(){        
        Being being = mock(Being.class);
        _universe.addBeing(being);
        
        assertTrue(_population.contains(being));
    }
    
    
    private void fillBeingList(int times){
        for(int i=0; i<times; i++)
            _population.add(mock(Being.class));
    }
}
