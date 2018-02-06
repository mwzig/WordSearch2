package wordsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordSearch {

	private String inputFileName;
	boolean displayInput = false;
	private ArrayList<String> wordsToFind;
	

	public WordSearch(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public WordSearch(String inputFileName, boolean displayInput) {
		this.inputFileName = inputFileName;
		this.displayInput = displayInput;
	}

	public static void main(String args[]) {
		
	}
	
	public boolean processInputFile() {

		boolean fileValid = checkForValidInputFile(this.inputFileName);

		if (!fileValid) {
			System.out.println(this.inputFileName + " does not exist");
			return false;
		}
		
		if (readWordsToFind()) {
			return readSearchGrid();
		} else {
			return false;
		}
	}
	
	private boolean readWordsToFind() {
		return true;
	}
	
	private boolean readSearchGrid() {
		return true;
	}
	
	private boolean saveForLater() {
		
		ArrayList<String> gridData = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(inputFileName);
			BufferedReader br = new BufferedReader(fr);
			String gridInputString, gridInputStringNoCommas, inputWordsToFind;
			inputWordsToFind = br.readLine();
			String[] words = inputWordsToFind.split(",");

			for (int i = 0; i < words.length; i++) {
				wordsToFind.add((words[i]));
			}
			if (displayInput) {
				System.out.println(wordsToFind.toString());
			}

			while ((gridInputString = br.readLine()) != null) {
				gridInputStringNoCommas = gridInputString.replaceAll(",", "");
				gridInputStringNoCommas = gridInputStringNoCommas.replaceAll(" ", "");
				if (displayInput) {
					System.out.println(gridInputStringNoCommas);
				}
				gridData.add(gridInputStringNoCommas);
			}
			fr.close();

			//searchGrid = new Grid(gridData);
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	//*********************************************************************************************//
	//* Checks to see if the file name passed as an argument exists.                              *//
	//* If a filename with path name is not passed, then format the path name with                *//
	//* the current directory + /Resources/.                                                      *//
	//*********************************************************************************************//
	public boolean checkForValidInputFile(String fileName) {

		if (!fileName.contains("/")) {
			String basePath = new File("").getAbsolutePath();
			String inputBasePath = basePath + java.io.File.separator +
					"Resources" + java.io.File.separator;
			this.inputFileName = inputBasePath + fileName;
		} else {
			// need this statement so we can call this method from the test class
			this.inputFileName = fileName;
		}
		
		File file = new File(this.inputFileName);
		boolean fileExists = file.exists(); 
		if (fileExists) {
			return true;
		} else {
			return false;
		}
	}


}
