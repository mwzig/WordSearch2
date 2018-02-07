package wordsearch;

public class GridLetter {
	private char letter;
	private LocCoordinate locCoordinate;

	public GridLetter(char letter, int xCoordinate, int yCoordinate) {
		this.letter = letter;
		this.locCoordinate = new LocCoordinate(xCoordinate, yCoordinate);
	}

	public GridLetter(char letter, LocCoordinate locCoordinate) {
		this.letter = letter;
		this.locCoordinate = locCoordinate;
	}
	
	@Override
	public String toString() {
		return "GridLetter [letter=" + letter + ", locCoordinate=" + locCoordinate + "]";
	}

	public char getLetter() {
		return letter;
	}

	public LocCoordinate getLocCoordinate() {
		return locCoordinate;
	}
	
}
