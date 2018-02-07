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
	
	@Test
	public void testWordSearchPrintOutput() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("abcd");
		String expectedPrintOutput = "abcd: (0,0),(0,1),(0,2),(0,3)";

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		wordSearch.findWords();
		assertEquals(expectedPrintOutput, wordSearch.getFoundWords().get(0).toString());
	}

	@Test
	public void findWordsAcrossReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("dcba");
		wordsToFind.add("hgf");
		wordsToFind.add("kji");
		wordsToFind.add("on");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void findWordsDown() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("aeim");
		wordsToFind.add("fjn");
		wordsToFind.add("gk");
		wordsToFind.add("dh");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void findWordsDownReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("miea");
		wordsToFind.add("njf");
		wordsToFind.add("kg");
		wordsToFind.add("hd");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void findWordsDiagonalTopLeftBottomRight() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("eb");
		wordsToFind.add("ifc");
		wordsToFind.add("mjgd");
		wordsToFind.add("nkh");
		wordsToFind.add("ol");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void findWordsDiagonalTopLeftBottomRightReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("be");
		wordsToFind.add("cfi");
		wordsToFind.add("dgjm");
		wordsToFind.add("hkn");
		wordsToFind.add("lo");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void findWordsDiagonalBottomLeftTopRight() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("in");
		wordsToFind.add("ejo");
		wordsToFind.add("afkp");
		wordsToFind.add("bgl");
		wordsToFind.add("ch");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void findWordsDiagonalBottomLeftTopRightReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("ni");
		wordsToFind.add("oje");
		wordsToFind.add("pkfa");
		wordsToFind.add("lgb");
		wordsToFind.add("hc");

		Grid searchGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(searchGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}


	
	
}
