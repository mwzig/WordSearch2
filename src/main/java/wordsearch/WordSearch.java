package wordsearch;

import java.io.File;

public class WordSearch {

	private String inputFileName;

	public WordSearch(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public static void main(String args[]) {
		
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
