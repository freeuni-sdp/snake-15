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
import static org.mockito.Mockito.verify;

/**
 *
 * @author user
 */
public class CompositePopulatorTest {
    
    @Test
    public void testPopulate(){
        WormHolePopulator wormHolePopulator = Mockito.mock(WormHolePopulator.class);
        SingleMousePopulator singleMousePopulator = Mockito.mock(SingleMousePopulator.class);
        Populator[] populator = new Populator[2];
        populator[0] = wormHolePopulator;
        populator[1] = singleMousePopulator;
        
        CompositePopulator comp = new CompositePopulator(populator);
        
        Universe universe = Mockito.mock(Universe.class);
        
        comp.populate(universe);
        verify(wormHolePopulator).populate(universe);
        verify(singleMousePopulator).populate(universe);
    }
}
