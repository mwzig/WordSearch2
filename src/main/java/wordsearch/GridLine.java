package wordsearch;
import java.util.ArrayList;

//*********************************************************************************************//
//*  The GridLine class represents a line in the Grid which can be horizontal, vertical or    *//
//*  diagonal (or the reverse horizontal, vertical or diagonal line).                         *//
//*  It contains a String object named "lineString" that represents the String of all of the  *//
//*  chars on a particular row, column, or diagonal line in the Grid.                         *//
//*  It also contains an ArrayList of LocCoordinate objects for each of the letters on that   *//
//*  line.                                                                                    *//
//*********************************************************************************************//
public class GridLine {

	private String lineString;
	private ArrayList<LocCoordinate> locCoordinateList;

	public GridLine(String gridCharString, ArrayList<LocCoordinate> locCoordinateList) {
		this.lineString = gridCharString;
		this.locCoordinateList = locCoordinateList;
	}
	
	public GridLine getReverseLine() {

		ArrayList<LocCoordinate> revLocCoordinateList = new ArrayList<LocCoordinate>();
		String reverseLineString = new StringBuilder(lineString).reverse().toString();
		for (int i = reverseLineString.length()-1; i >=0  ;i--) {
			revLocCoordinateList.add(locCoordinateList.get(i));
		}
		GridLine reverseGridLine = new GridLine(reverseLineString, revLocCoordinateList);
		return reverseGridLine;
	}

	public String getLineString() {
		return lineString;
	}

	public ArrayList<LocCoordinate> getLocCoordinateList() {
		return locCoordinateList;
	}

	@Override
	public String toString() {
		return "GridLine [gridCharString=" + lineString + ", locCoordinateList=" + locCoordinateList + "]";
	}

}
