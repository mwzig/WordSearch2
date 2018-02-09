package wordsearch;

public class LocCoordinate {

	private int xCoordinate;
	private int yCoordinate;
	
	public LocCoordinate(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	@Override 
	public String toString() {
		return "(" + xCoordinate + "," + yCoordinate + ")";
	}
}
