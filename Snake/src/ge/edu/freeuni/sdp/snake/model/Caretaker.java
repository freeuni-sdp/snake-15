package ge.edu.freeuni.sdp.snake.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Caretaker {
	private Memento savedState;
	private boolean fileExists;
	File mementoFile = new File("memento.txt");

	public Caretaker() {
		if (mementoFile.exists()) {
			restoreMementoFromFile();
		}
	}

	private void restoreMementoFromFile() {
		int length = 0;
		String direction = null;
		Point head = null;
		int levelIndex = 0;
		try {
            FileReader fileReader = new FileReader(mementoFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            length = Integer.parseInt(bufferedReader.readLine());
            direction = bufferedReader.readLine();
            head = new Point(Integer.parseInt(bufferedReader.readLine()),Integer.parseInt(bufferedReader.readLine()));
            levelIndex = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {               
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
		savedState = new Memento(length, direction, head, levelIndex);
	}

	public Memento getMemento() {
		return savedState;
	}

	public void addMemento(Memento savedState) {
		this.savedState = savedState;
		try {
			mementoFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		saveInFile();
	}

	private void saveInFile() {
		try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(mementoFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(""+savedState.getLength());
            bufferedWriter.newLine();
            bufferedWriter.write(savedState.getDirectionString());
            bufferedWriter.newLine();
            bufferedWriter.write(""+savedState.getHead().X);
            bufferedWriter.newLine();
            bufferedWriter.write(""+savedState.getHead().Y);
            bufferedWriter.newLine();
            bufferedWriter.write(""+savedState.getLevelIndex());
            bufferedWriter.close();
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
//		BufferedWriter writer = null;
//		try {
//			writer = new BufferedWriter(new FileWriter(mementoFile));
//			writer.write(savedState.getLength());
//			writer.newLine();
//			writer.write(savedState.getDirectionString());
//			writer.newLine();
//			writer.write();
//			writer.newLine();
//			writer.write(savedState.getHead().Y);
//			writer.newLine();
//			writer.write(savedState.getLevelIndex());
//
//			writer.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	public boolean hasSavedState() {
		return fileExists;
	}
}
