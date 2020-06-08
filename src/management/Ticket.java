package management;

public class Ticket {

	private Date flightDate;
	private String from;
	private String to;
	private Seat seat;
	private Date boardingTime;
	private Date arrivalTime;

	public Ticket(Date flightDate, String from, String to, Seat seat) {
		super();
		this.flightDate = flightDate;
		this.from = from;
		this.to = to;
		this.seat = seat;

	}

	public Ticket(Date flightDate, String from, String to, Seat seat, Date boardingTime,

			Date arrivalTime) {
		super();
		this.flightDate = flightDate;
		this.from = from;
		this.to = to;
		this.seat = seat;
		this.boardingTime = boardingTime;
		this.arrivalTime = arrivalTime;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
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

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Date getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(Date boardingTime) {
		this.boardingTime = boardingTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
