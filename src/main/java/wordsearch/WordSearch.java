package wordsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordSearch {

	private String inputFileName;
	private boolean displayInput = false;
	private ArrayList<String> wordsToFind;
	private ArrayList<FoundWord> foundWords;
	private ArrayList<String> wordsNotFound;
	private Grid searchGrid;

	// *********************************************************************************************//
	// * This constructor is the main constructor.
	// *********************************************************************************************//
	public WordSearch(String inputFileName) {
		this.inputFileName = inputFileName;
		this.foundWords = new ArrayList<FoundWord>();
		this.wordsToFind = new ArrayList<String>();
		this.wordsNotFound = new ArrayList<String>();
	}

	// *********************************************************************************************//
	// * This constructor gives the option to print extra data
	// *********************************************************************************************//
	public WordSearch(String inputFileName, boolean displayInput) {
		this(inputFileName);
		this.displayInput = displayInput;
		if (displayInput) {
			System.out.println("displayInput set to True");
		}
	}

	// *********************************************************************************************//
	// * This constructor is used as part of testing
	// * It allows us to hard code a specific letter grid in our tests and pass it
	// * to this constructor.
	// *********************************************************************************************//
	public WordSearch(Grid searchGrid, ArrayList<String> wordsToFind) {
		this(null);
		this.searchGrid = searchGrid;
		this.wordsToFind = wordsToFind;
	}

	public static void main(String[] args) {

		WordSearch wordSearch;
		boolean displayInput = false;

		if (args.length == 0) {
			System.out.println("Please try again and enter an input file name");
		} else {
			if (args.length == 2 && args[1].toLowerCase().equals("true")) {
				displayInput = true;
			}
			wordSearch = new WordSearch(args[0], displayInput);
			if (wordSearch.processInputFile()) {
				wordSearch.findWords();
				for (FoundWord foundWord : wordSearch.getFoundWords()) {
					System.out.println(foundWord.toString());
				}
				for (String wordNotFound : wordSearch.getWordsNotFound()) {
					System.out.println("Not found: " + wordNotFound);
				}
			} else {
				System.out.println("Please try again and enter a valid input file name");
			}
		}
	}

	protected boolean processInputFile() {

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

	// *********************************************************************************************//
	// Assume that the first line (and only one line) of input file contains words
	// to find.
	// This could be modified later to have a parameter of number of lines
	// to read that contain words to find.
	// *********************************************************************************************//
	private boolean readWordsToFind() {

		try {
			FileReader fr = new FileReader(inputFileName);
			BufferedReader br = new BufferedReader(fr);
			String inputWordsToFind;
			inputWordsToFind = br.readLine();
			String[] words = inputWordsToFind.split(",");

			for (int i = 0; i < words.length; i++) {
				wordsToFind.add((words[i]));
			}
			if (displayInput) {
				System.out.println(wordsToFind.toString());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean readSearchGrid() {

		ArrayList<String> gridData = new ArrayList<String>();
		String gridInputString, gridInputStringNoCommas;

		try {
			FileReader fr = new FileReader(inputFileName);
			BufferedReader br = new BufferedReader(fr);
			// read past the first line that contains the words to find
			br.readLine();

			while ((gridInputString = br.readLine()) != null) {
				gridInputStringNoCommas = gridInputString.replaceAll(",", "");
				gridInputStringNoCommas = gridInputStringNoCommas.replaceAll(" ", "");
				if (displayInput) {
					System.out.println(gridInputStringNoCommas);
				}
				gridData.add(gridInputStringNoCommas);
			}
			fr.close();

			searchGrid = new Grid(gridData);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	// *********************************************************************************************//
	// * Checks to see if the file name passed as an argument exists.
	// * If a filename with path name is not passed, then format the path name with
	// * the current directory + /Resources/.
	// *********************************************************************************************//
	protected boolean checkForValidInputFile(String fileName) {

		if (!fileName.contains("/")) {
			String basePath = new File("").getAbsolutePath();
			String inputBasePath = basePath + java.io.File.separator + "Resources" + java.io.File.separator;
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

	protected boolean findWords() {

		for (String wordToFind : wordsToFind) {
			findWord(wordToFind);
		}
		if (wordsToFind.size() == foundWords.size()) {
			return true;
		} else {
			return false;
		}
	}

	private void findWord(String wordToFind) {

		boolean wordFound = false;
		ArrayList<LocCoordinate> locCoordList = new ArrayList<LocCoordinate>();
		GridLine gridLine;
		for (int i = 0; i < searchGrid.getGridLines().size(); i++) {
			gridLine = searchGrid.getGridLines().get(i);
			if (gridLine.getLineString().contains(wordToFind)) {
				ArrayList<LocCoordinate> locList = gridLine.getLocCoordinateList();
				int foundAtIndex = gridLine.getLineString().indexOf(wordToFind);
				locCoordList.add(locList.get(foundAtIndex));
				// need to start at index 1 because we've already
				// got the first coordinate above
				for (int j = 1; j < wordToFind.length(); j++) {
					locCoordList.add(locList.get(foundAtIndex + j));
				}
				foundWords.add(new FoundWord(wordToFind, locCoordList));
				wordFound = true;
			}
		}
		if (!wordFound) {
			wordsNotFound.add(wordToFind);
		}
	}

	public ArrayList<String> getWordsToFind() {
		return wordsToFind;
	}

	public ArrayList<FoundWord> getFoundWords() {
		return foundWords;
	}

	public ArrayList<String> getWordsNotFound() {
		return wordsNotFound;
	}

}
