
public class Cell {

	private boolean reveal;
	private boolean bomb;
	private boolean empty;
	private boolean scoreCell;
	private int value;

	// Constructor
	public Cell(boolean r, boolean b, boolean e, boolean sc, int v) {
		reveal = r;
		bomb = b;
		empty = e;
		scoreCell = sc;
		value = v;
	}
	
	public void setRevealStatus(boolean r) {
		reveal = r;
	}
	
	public void setBombStatus(boolean b) {
		bomb = b;
	}
	
	public void setEmptyStatus(boolean e) {
		empty = e;
	}
	
	public void setScoreCellStatus(boolean sc) {
		scoreCell = sc;
	}
	
	public void setValue(int v) {
		value = v;
	}

	public boolean getRevealStatus() {
		return reveal;
	}

	public boolean getBombStatus() {
		return bomb;
	}

	public boolean getEmptyStatus() {
		return empty;
	}
	
	public boolean getScoreCellStatus() {
		return scoreCell;
	}

	public int getValue() {
		return value;
	}
}
