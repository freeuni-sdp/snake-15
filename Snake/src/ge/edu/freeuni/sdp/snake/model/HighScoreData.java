package ge.edu.freeuni.sdp.snake.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HighScoreData {

	private ArrayList<HighScoreDataPair> pairsList;

	public HighScoreData() {
		pairsList = new ArrayList<>();
	}
	
	private String deleteWhiteSpace(String str){
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				result = result + str.charAt(i);
			}
		}
		return result;
	}
	
	public void readFile() {
		try {
			for (String line : Files.readAllLines(
					Paths.get("HighScoresTop5.txt"), Charset.defaultCharset())) {
				int startIndex = line.indexOf('.');
				int index = line.lastIndexOf('-');
				String name = line.substring(startIndex + 1, index);
				String score = line.substring(index + 1);
				name = deleteWhiteSpace(name);
				score = deleteWhiteSpace(score);				
				int number = Integer.parseInt(score);
				HighScoreDataPair pair = new HighScoreDataPair(name, number);
				pairsList.add(pair);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int checkIfFileMustBeEdited(int score) {
		int index = -1;
		for (int i = 0; i < pairsList.size(); i++) {
			if (score >= pairsList.get(i).getHighScore()) {
				index = i;
				break;
			}
		}
		if(index == -1 && pairsList.size() < 5){
			index = pairsList.size();
		}
		return index;
	}

	public String getFileContent() {
		int previous = -1;
		String result = "";
		int place = 0;
		for (int i = 0; i < pairsList.size(); i++) {
			String line = "";
			int temp = pairsList.get(i).getHighScore();
			if (temp != previous) {
				place++;
			}
			previous = temp;
			line = line + place + ". " + pairsList.get(i).getName() + "  - " + temp + "\n";
			result = result + line;
		}
		return result;
	}

	private void writeToFile(String content) {
		File file = new File("HighScoresTop5.txt");
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void removeLastScores(int score) {
		if(pairsList.size() > 4){
			int checker = pairsList.get(4).getHighScore();
			for(int i = pairsList.size() - 1; i > 4; i--){
				if(pairsList.get(i).getHighScore() != checker){
					pairsList.remove(pairsList.size() - 1);
				}
			}
		}
	}
	
	
	public void editFile(String name, int score) {
		int index = checkIfFileMustBeEdited(score);
		if (index != -1) {
			pairsList.add(index, new HighScoreDataPair(name, score));
			removeLastScores(score);
			String content = getFileContent();
			writeToFile(content);
		}
	}
}
