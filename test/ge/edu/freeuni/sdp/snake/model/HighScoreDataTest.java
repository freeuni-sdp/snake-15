package ge.edu.freeuni.sdp.snake.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HighScoreDataTest {

	@Before
	public void setUp() {
	}
	
	private static List<String> FAKE_INPUT_NOT_FULL = Arrays.asList(
			"1. testUser  - 5000",
			"2. testUser  - 340", 
			"3. testUser  - 130",
			"4. testUser2  - 130");

	private static List<String> FAKE_INPUT_FULL = Arrays.asList(
			"1. MEGAMIND  - 5000",
			"2. testUser  - 340", 
			"3. testUser  - 130",
			"4. testUser2  - 110",
			"5. testUser2  - 100"
			);
	
	private static List<String> FAKE_INPUT_OVER_FULL = Arrays.asList(
			"1. MEGAMIND  - 5000",
			"2. testUser  - 340", 
			"3. testUser  - 130",
			"4. testUser2  - 110",
			"5. testUser2  - 100",
			"6. dumb  - 70",
			"6. dumber  - 55"
			);
	
	
	private static List<String> FAKE_INPUT_SHORT = Arrays.asList(
			"1. testUser  - 200",
			"2. testUser  - 149"
			);
	
	
	@Test
	public void testReadAndGetFileContent() throws IOException {
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_NOT_FULL);

		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();

		assertEquals("1. testUser  - 5000\n" 
					+ "2. testUser  - 340\n"
					+ "3. testUser  - 130\n" 
					+ "3. testUser2  - 130\n",
				highScoreData.getFileContent());
	}

	@Test
	public void testReadDirtyFile() throws Throwable{
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenThrow(new IOException());

		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();
		assertEquals("",highScoreData.getFileContent());
	}
	
	@Test
	public void testCheckIfFileMustBeEdited_1() throws IOException{
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(new ArrayList<String>());
		
		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();
		
		int index = highScoreData.checkIfFileMustBeEdited(1);
		// when empty any score must be added
		assertEquals(0, index);
		
		index = highScoreData.checkIfFileMustBeEdited(100);
		assertEquals(0, index);
		
		// now test if it's full
		// As we know data should be added if it's in top 5
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_NOT_FULL);
		highScoreData.readFile();
		
		index = highScoreData.checkIfFileMustBeEdited(1);
		// when not full , data also should be added
		assertEquals(4, index);
		
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_FULL);
		highScoreData.readFile();
		
		index = highScoreData.checkIfFileMustBeEdited(1);
		// when  full , low data also shouldn't be added
		assertEquals(-1, index);
	}
	
	@Test
	public void testCheckIfFileMustBeEdited_2() throws IOException{
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_FULL);
		
		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();
		
		int index = highScoreData.checkIfFileMustBeEdited(5001);
		// more than first user
		assertEquals(0, index);
		
		index = highScoreData.checkIfFileMustBeEdited(140);
		// more than first user
		assertEquals(2, index);
	}
	
	@Test
	public void testFileEdit_1() throws IOException{
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_FULL);
		
		FileWriter mockFw = mock(FileWriter.class);
		
		when(mockIO.getFileWriter(anyString())).thenReturn(mockFw);
		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();
		
		highScoreData.editFile("Looser", 10);
		// file shouldn't be changed , when looser wins.
		verify(mockIO, times(0)).getFileWriter(anyString());
		
		
		highScoreData.editFile("CleverLikeGuy", 1000);
		verify(mockIO, times(1)).getFileWriter(anyString());
	}
	
	
	@Test
	public void testFileEdit_2() throws IOException{
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_SHORT);
		
		FileWriter mockFw = mock(FileWriter.class);
		
		when(mockIO.getFileWriter(anyString())).thenReturn(mockFw);
		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();
		
		highScoreData.editFile("Looser", 10);
		// file should be changed , when looser wins, beause list is short		
		
		highScoreData.editFile("CleverLikeGuy", 1000);
		
		// check if everything is clear when can't write
		when(mockIO.getFileWriter(anyString()))
				.thenThrow(new IOException());
		highScoreData.editFile("MEGAMIND", 10000);
		
		verify(mockIO, times(3)).getFileWriter(anyString());
	}
	
	
	@Test
	public void testFileEdit_3() throws IOException{
		HighScoreData.FileIOWrapper mockIO = mock(HighScoreData.FileIOWrapper.class);
		when(mockIO.readAllLines(any(Path.class), any(Charset.class)))
				.thenReturn(FAKE_INPUT_OVER_FULL);
		
		FileWriter mockFw = mock(FileWriter.class);
		
		when(mockIO.getFileWriter(anyString())).thenReturn(mockFw);
		HighScoreData highScoreData = new HighScoreData(mockIO);
		highScoreData.readFile();
		
		highScoreData.editFile("JohnTheMiddlet", 101);
		verify(mockIO, times(1)).getFileWriter(anyString());
	}
	
	
	
}
