package wordsearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WordSearchTest {

	
	@Test
	public void testThatWordSearchObjCreated() {
		WordSearch wordSearch = new WordSearch(null);
		assertNotNull(wordSearch);
	}

	@Test
	public void testCheckForValidInputFileReturnsFalseWhenNotFound() {
		WordSearch wordSearch = new WordSearch(null);
		boolean bFileFound = wordSearch.checkForValidInputFile("abc");
		assertEquals(false, bFileFound);
	}

	@Test
	public void testCheckForValidInputFileReturnsTrueWhenFoundAndNoPathSpecified() {
		WordSearch wordSearch = new WordSearch(null);
		boolean bFileFound = wordSearch.checkForValidInputFile("PillarExampleWordSearch.txt");
		assertEquals(true, bFileFound);
	}

	@Test
	public void testCheckForValidInputFileReturnsTrueWhenFoundAndPathSpecified() {
		WordSearch wordSearch = new WordSearch(null);
		boolean bFileFound = wordSearch.checkForValidInputFile("c:/Users/Mary"
				+ "/Projects2018/WordSearch2/Resources/PillarExampleWordSearch.txt");
		assertEquals(true, bFileFound);
	}
	
	@Test
	public void testProcessInputFileReturnsTrue() {
		WordSearch wordSearch = new WordSearch("PillarExampleWordSearch.txt", true);
		boolean bFileProcessed = wordSearch.processInputFile();
		assertEquals(true, bFileProcessed);
	} 
	
	@Test
	public void testProcessInputFileReadsWordsToFind() {
		WordSearch wordSearch = new WordSearch("PillarExampleWordSearch.txt", true);
		wordSearch.processInputFile();
		ArrayList<String> checkWordsToFind = new ArrayList<String>();
		checkWordsToFind.add("BONES");
		checkWordsToFind.add("KHAN");
		checkWordsToFind.add("KIRK");
		checkWordsToFind.add("SCOTTY");
		checkWordsToFind.add("SPOCK");
		checkWordsToFind.add("SULU");
		checkWordsToFind.add("UHURA");
				
		assertEquals(checkWordsToFind, wordSearch.getWordsToFind());
	}

	
	
	
}
