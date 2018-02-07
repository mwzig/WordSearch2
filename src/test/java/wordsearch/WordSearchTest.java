package wordsearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private GridLetter[][] inputGrid;

	@Before
	public void setUp() throws Exception {

		GridLetter gridLetter;
		inputGrid = new GridLetter[4][4];

		int xCoordinate = 0;
		gridLetter = new GridLetter('a', xCoordinate, 0);
		inputGrid[xCoordinate][0] = gridLetter;

		gridLetter = new GridLetter('b', xCoordinate, 1);
		inputGrid[xCoordinate][1] = gridLetter;

		gridLetter = new GridLetter('c', xCoordinate, 2);
		inputGrid[xCoordinate][2] = gridLetter;

		gridLetter = new GridLetter('d', xCoordinate, 3);
		inputGrid[xCoordinate][3] = gridLetter;

		xCoordinate = 1;
		gridLetter = new GridLetter('e', xCoordinate, 0);
		inputGrid[xCoordinate][0] = gridLetter;

		gridLetter = new GridLetter('f', xCoordinate, 1);
		inputGrid[xCoordinate][1] = gridLetter;

		gridLetter = new GridLetter('g', xCoordinate, 2);
		inputGrid[xCoordinate][2] = gridLetter;

		gridLetter = new GridLetter('h', xCoordinate, 3);
		inputGrid[xCoordinate][3] = gridLetter;

		xCoordinate = 2;
		gridLetter = new GridLetter('i', xCoordinate, 0);
		inputGrid[xCoordinate][0] = gridLetter;

		gridLetter = new GridLetter('j', xCoordinate, 1);
		inputGrid[xCoordinate][1] = gridLetter;

		gridLetter = new GridLetter('k', xCoordinate, 2);
		inputGrid[xCoordinate][2] = gridLetter;

		gridLetter = new GridLetter('l', xCoordinate, 3);
		inputGrid[xCoordinate][3] = gridLetter;

		xCoordinate = 3;
		gridLetter = new GridLetter('m', xCoordinate, 0);
		inputGrid[xCoordinate][0] = gridLetter;

		gridLetter = new GridLetter('n', xCoordinate, 1);
		inputGrid[xCoordinate][1] = gridLetter;

		gridLetter = new GridLetter('o', xCoordinate, 2);
		inputGrid[xCoordinate][2] = gridLetter;

		gridLetter = new GridLetter('p', xCoordinate, 3);
		inputGrid[xCoordinate][3] = gridLetter;

	}

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

	@Test
	public void findWordsAcross() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("abcd");
		wordsToFind.add("fgh");
		wordsToFind.add("ijk");
		wordsToFind.add("no");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}
	
	
}
