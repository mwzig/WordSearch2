package wordsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

	@Test
	public void testThatWordSearchObjCreated() {
		WordSearch wordSearch = new WordSearch();
		assertNotNull(wordSearch);
	}

}
