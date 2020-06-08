package management;

import java.util.List;

public class Flight {

	private String flightNo;
	private Date Flightdate;

	private Date boardingTime;
	private Date arrivalTime;
	private String from;
	private String to;
	private Plane plane;

	private Pilot pilot;
	private List<Employee> fAttendants;

	public Flight(String flightNo, Date boardingTime, Date arrivalTime, String from, String to) {
		super();
		this.flightNo = flightNo;
		this.boardingTime = boardingTime;
		this.arrivalTime = arrivalTime;
		this.from = from;
		this.to = to;
	}

	public Flight(String flightNo, Date boardingTime, String from, String to, Plane plane, Pilot pilot,
			List<Employee> fAttendants) {
		super();
		this.flightNo = flightNo;
		this.boardingTime = boardingTime;
		this.from = from;
		this.to = to;
		this.plane = plane;
		this.pilot = pilot;
		this.fAttendants = fAttendants;
	}

	public Flight(String flightNo, Date boardingTime, Date arrivalTime, String from, String to, Plane plane,
			Pilot pilot, List<Employee> fAttendants) {
		super();
		this.flightNo = flightNo;
		this.boardingTime = boardingTime;
		this.arrivalTime = arrivalTime;
		this.from = from;
		this.to = to;
		this.plane = plane;
		this.pilot = pilot;
		this.fAttendants = fAttendants;
	}
	public Flight(String flightNo,Date Flightdate, Date boardingTime, Date arrivalTime, String from, String to, Plane plane,
			Pilot pilot, List<Employee> fAttendants) {
		super();
		this.Flightdate = Flightdate;
		this.flightNo = flightNo;
		this.boardingTime = boardingTime;
		this.arrivalTime = arrivalTime;
		this.from = from;
		this.to = to;
		this.plane = plane;
		this.pilot = pilot;
		this.fAttendants = fAttendants;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Date getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(Date boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public Date getFlightdate() {
		return Flightdate;
	}

	public void setFlightdate(Date Flightdate) {
		this.Flightdate =Flightdate;
	}


	public String toString() {
		return "Boarding:" + this.boardingTime.HourtoString() + "  From:" + this.from + " Destination:" + this.to
				+ "  Flight No:" + this.flightNo;
	}

	public void displayCrew() {
		for (Employee fAttendant : this.fAttendants) {
			System.out.println(fAttendant.toString());
		}
		System.out.println(this.pilot.toString());
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void changeCrewFlightTime() {

		int totalTime = this.arrivalTime.toMinute() - this.boardingTime.toMinute();

		this.pilot.setFlightTime(totalTime);
		this.pilot.calculateSalary();
		for (Employee fAttendant : this.fAttendants) {
			// (FlightAttendant) fAttendant.setFlightTime();
		}
	}
}