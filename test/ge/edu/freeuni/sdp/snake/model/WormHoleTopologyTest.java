/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author user
 */
public class WormHoleTopologyTest {
   
  private Point head;
  private Point randomPoint;
  
  @Before
  public void init(){
      head = new Point (5 ,5 ); 
      randomPoint = new Point (7,10);
  }
    
  @Test
  public void testGetNextToLeft(){
      RandomWormHole test = Mockito.mock(RandomWormHole.class);
      WormHoleTopology target = new WormHoleTopology(test);
      
      when(test.getLeft()).thenReturn(head);
      when(test.getRight()).thenReturn(randomPoint);
      
      Point result = target.getNextTo(head, Direction.RIGHT);
      assertEquals(test.getRight().X + 1, result.X);
      assertEquals(test.getRight().Y , result.Y);
  }
  
  @Test
  public void testGetNextToRight(){
      RandomWormHole test = Mockito.mock(RandomWormHole.class);
      WormHoleTopology target = new WormHoleTopology(test);
      
      when(test.getLeft()).thenReturn(randomPoint);
      when(test.getRight()).thenReturn(head);
      
      Point result = target.getNextTo(head, Direction.LEFT);
      assertEquals(test.getLeft().X - 1, result.X);
      assertEquals(test.getLeft().Y , result.Y);
  }
  
  
  @Test
  public void testGetNextToNoWormHole(){
      RandomWormHole test = Mockito.mock(RandomWormHole.class);
      SphericTopology top = Mockito.mock(SphericTopology.class);
      WormHoleTopology target = new WormHoleTopology(test,top);
      when(top.getNextTo(head, Direction.RIGHT)).thenReturn(new Point(head.X +1, head.Y));
      when(test.getLeft()).thenReturn(randomPoint);
      when(test.getRight()).thenReturn(randomPoint);
      
      Point result = target.getNextTo(head, Direction.RIGHT);
      assertEquals(head.X + 1, result.X);
      assertEquals(head.Y , result.Y);
  }
  
}
