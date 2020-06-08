package management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import stack.*;

public class TicketManagement {

	private List<Ticket> tickets;
	private Flight flight;
	private List<Passenger> passengers;
	private Stack baggages;

	public TicketManagement() {
		super();
		passengers = new ArrayList<>();
		tickets = new ArrayList<>();
		baggages = new Stack();
	
	}

	public void readFile() throws NumberFormatException, IOException {

		try {
			FileReader fileReader;
			BufferedReader bReader;

			String line;
			bReader = new BufferedReader(fileReader = new FileReader("passengets.txt"));
			while ((line = bReader.readLine()) != null) {
				Phone phone = new Phone(line.split(",")[3].split(" ")[0], line.split(",")[3].split(" ")[1],
						line.split(",")[3].split(" ")[2]);
				Date date = new Date(Integer.parseInt(line.split(",")[2].split("/")[0]),
						Integer.parseInt(line.split(",")[2].split("/")[1]),
						Integer.parseInt(line.split(",")[2].split("/")[2]));
				Passenger newplayer = new Passenger(0, line.split(",")[0], line.split(",")[1], date, phone);
				passengers.add(newplayer);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void addPassenger(Passenger passenger) {
		setPassengers(passenger);
	}

	public String addBaggage(Passenger passenger) {
		if (passenger.getBaggage().IsAcceptable()) {
			baggages.push(passenger.getBaggage());
			return "Baggage Added";
		} else {
			return "Baggage Unacceptable";
		}

	}

	public void deletePassenger(Passenger passenger) {

		int index = 0;
		for (Passenger p : this.passengers) {
			if (passenger.getName().equals(p.getName())) {
				passengers.remove(index);
				break;
			}
			index++;
		}
	}

	public void sellTicket(Salesman salesman, Passenger passenger, Ticket ticket, Plane p, String row, int column) {

		salesman.setTicketSold(salesman.getTicketSold() + 1);
		this.tickets.add(ticket);
		selectSeat(p, column, row);
		// swing gets the parameters
	}

	public void selectSeat(Plane plane, int column, String row) {

		char c = row.charAt(0);
		int r = (int) c - 65;
		if ((plane.getSeats()[column][r].getRow().equals(row) && (plane.getSeats()[column][r].getColumn() == column)
				&& plane.getSeats()[column][r].isStatus() == false)) {
			plane.getSeats()[column][r].setStatus(true);
		} else if (plane.getSeats()[column][r].getRow().equals(row)
				&& (plane.getSeats()[column][r].getColumn() == column)
				&& plane.getSeats()[column][r].isStatus() == true) {
			// swing
		}

	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Passenger p) {
		this.passengers.add(p);
	}

	public Stack getBaggages() {
		return baggages;
	}

	public void setBaggages(Stack baggages) {
		this.baggages = baggages;
	}

}
