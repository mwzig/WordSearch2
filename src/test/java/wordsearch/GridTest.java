package wordsearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GridTest {
	@Test
	public void testThatGridObjCreated() { 		
		ArrayList<String> gridData = new ArrayList<String>();
		Grid searchGrid = new Grid(gridData);
		assertNotNull(searchGrid);
	}
		

}
