package management;

public class Seat {

	private String seatClass;
	private int column;
	private String row;
	private boolean status;

	public Seat(String seatType, int column, String row, boolean status) {
		super();
		this.seatClass = seatType;
		this.row = row;
		this.column = column;
		this.status = status;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatType) {
		this.seatClass = seatType;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String toBox() {
		
		if(this.status) {
			return this.row+this.column+ "[X]";
			
		}
		else {
			return this.row +this.column+"[ ]";
		}
		
	}

	public String toString() {

		return "Class : " + this.seatClass + " Seat: " + this.column + this.row + " Status: " + this.status;

	}

}
