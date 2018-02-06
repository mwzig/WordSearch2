package wordsearch;

import static org.junit.Assert.*;

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
}
