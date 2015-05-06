/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.internal.matchers.ArrayEquals;

/**
 *
 * @author user
 */
public class ConfigurationTest {
    
    private static Size size;
    private static List<Level> levels;
    private static Configuration temp;
    private static Level level1;
    
    @BeforeClass
    public static void setUp(){
        size = Mockito.mock(Size.class);
        level1 = Mockito.mock(Level.class);
        levels = new ArrayList<>();
        levels.add(level1);
        
        
        Configuration.init(size, levels);
        temp = Configuration.getInstance();
    }
    
    @Test
    public void testGetSize() {
        
        Size returnSize = temp.getSize();
        assertTrue(returnSize.equals(size));
        
    }
    
    @Test
    public void testGetgetSelectedLevel_And_GetSelectedLevelIndex() {
        
        int levelIndex = 0;
        
        temp.selectLevel(levelIndex);
        
        assertTrue(level1.equals(temp.getSelectedLevel()));
        assertEquals(temp.getSelectedLevelIndex(),levelIndex);
        
    }
    
    @Test
    public void testGetgetSelectedLevelDiscription() {
        
        when(level1.getDescription()).thenReturn("Testing is Ok");
        int levelIndex = 0;
        temp.selectLevel(levelIndex);
        assertTrue(temp.getSelectedLevelDescription().equals("Testing is Ok"));
    }
    
    
    @Test
    public void testGetLevelNames() {
        
        when(level1.getName()).thenReturn("First Name");
        String [] testing = temp.getLevelNames();
        
        assertEquals(1,testing.length);
        assertTrue(testing[0].equals("First Name"));
        
        String[] result = new String[levels.size()];
	for (int i = 0; i < result.length; i++) {
		result[i] = levels.get(i).getName();
	}
        
        assertArrayEquals(result,testing);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testExceptionForSecondInit(){
        
        Configuration.init(size,levels);
        fail("Can`t catch exception");
        
    }
    
    
}
