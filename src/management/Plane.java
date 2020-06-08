package management;

import java.util.ArrayList;
import java.util.List;

public class Plane {

	int registrationNo;
	private Seat[][] seats;
	protected Pilot pilot;
	protected List<Employee> employees = new ArrayList<Employee>();
	private int passengerCount;

	public Plane(int registrationNo, int seatcount, List<Employee> employees) {
		super();
		this.registrationNo = registrationNo;
		this.seats = new Seat[seatcount / 6][6];
		for (int i = 0; i < seatcount / 6; i++) {
			for (int j = 0; j < 6; j++) {
				this.seats[i][j] = new Seat("economy", i + 1, Character.toString((char) (j + 65)), false);
			}
		}

		passengerCount = 0;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(String r, int c) {

		int row = 0;
		switch (r) {
		case "A": {
			row = 0;
			break;
		}
		case "B": {
			row = 1;
			break;

		}
		case "C": {
			row = 2;
			break;
		}
		case "D": {
			row = 3;
			break;
		}
		case "E": {
			row = 4;
			break;
		}
		case "F": {
			row = 5;
			break;
		}
		default:
			break;
		}

		this.seats[c - 1][row].setStatus(true);

	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	void displaySeats() {
		for (int i = 0; i < this.seats.length; i++) {
			for (int j = 0; j < this.seats[0].length; j++) {
				System.out.println(seats[i][j].toString());

			}
		}

	}

	void displayEmployees() {
		System.out.println(this.pilot.toString());
		for (int i = 0; i < this.employees.size(); i++) {
			System.out.println((i + 1 + "-" + this.employees.get(i).toString()));

		}
	}
}
