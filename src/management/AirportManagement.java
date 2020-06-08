package management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class AirportManagement {
	private Manager manager = new Manager("Çaðatay", "Önal", null, null, 0);
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Pilot> pilots = new ArrayList<Pilot>();
	private List<Salesman> salesmans = new ArrayList<Salesman>();
	private List<FlightAttendant> FlightAttendants = new ArrayList<FlightAttendant>();
	private List<Flight> flights = new ArrayList<Flight>();

	public void ManagerOp() {
		Date ManBirtDate = new Date(19, 2, 1998);
		Phone ManPhone = new Phone("+90", "542", "6751324");
		this.getManager().setBirthdate(ManBirtDate);
		this.getManager().setPhoneNumber(ManPhone);
		this.getManager().calculateManagerSalary(getEmployees());
		this.getManager().calculateSalary();
	}

	public void readEmployee() throws IOException {
		FileInputStream fileRead = new FileInputStream("Employees.txt");
		DataInputStream data = new DataInputStream(fileRead);
		BufferedReader read = new BufferedReader(new InputStreamReader(data));

		String line, name = null, surname = null, countrycode = null, areacode = null, number = null;
		Date date;
		Phone phone;
		int day = 0, month = 0, year = 0;
		String[] inputs = null;
		String[] date_inputs = null;
		String[] phone_inputs = null;
		int num = 0;

		while ((line = read.readLine()) != null) {

			// Every line of the file was assigned to 'line' at every turn.
			inputs = line.split(",");

			for (int i = 0; i < inputs.length; i++) {
				switch (i) {
				case 0:
					name = inputs[i];
					break;
				case 1:
					surname = inputs[i];
					break;
				case 2:
					date_inputs = inputs[i].split("/");
					for (int j = 0; j < date_inputs.length; j++) {
						switch (j) {
						case 0:
							day = Integer.parseInt(date_inputs[j]);
							break;
						case 1:
							month = Integer.parseInt(date_inputs[j]);
							break;
						case 2:
							year = Integer.parseInt(date_inputs[j]);
							break;
						}

					}
					break;
				case 3:
					phone_inputs = inputs[i].split(" ");
					for (int j = 0; j < phone_inputs.length; j++) {
						switch (j) {
						case 0:
							countrycode = date_inputs[j];
							break;
						case 1:
							areacode = date_inputs[j];
							break;
						case 2:
							number = date_inputs[j];
							break;
						}

					}
					break;

				}

			}
			date = new Date(day, month, year);
			phone = new Phone(countrycode, areacode, number);
			if (num < 10) {
				Pilot p = new Pilot(name, surname, date, phone,25000);
				getPilots().add(p);
				getEmployees().add(p);
				
				num++;
			} else if (num > 9 && num < 15) {
				Salesman s = new Salesman(name, surname, date, phone,10000);
				getSalesmans().add(s);
				getEmployees().add(s);
				num++;

			} else if (num > 14) {
				FlightAttendant f = new FlightAttendant(name, surname, date, phone,5000);
				getFlightAttendants().add(f);
				getEmployees().add(f);
				num++;

			}

		}

		read.close();
	}

	public void readFlights() throws NumberFormatException, IOException {
		int count = 0;
		int registirationCount = 0;
		int attendantCount = 0;
		File file = new File("flights.txt");
		String[] str = new String[6];
		String[] str2 = new String[3];
		String[] str3 = new String[2];
		String[] str4 = new String[2];

		List<Employee> attendants = new ArrayList<Employee>();

		BufferedReader bre = new BufferedReader(new FileReader(file));
		String stt;

		while ((stt = bre.readLine()) != null) {
			str = stt.split(",");
			str2 = str[1].split("/");
			str3 = str[2].split(":");
			str4 = str[3].split(":");

			for (int i = 0; i < 5; i++) {
				if (attendantCount == getFlightAttendants().size())
					attendantCount = 0;
				attendants.add(i, getFlightAttendants().get(attendantCount));
				attendantCount++;

			}

			Plane plane = new Plane(registirationCount, 144, attendants);
			Date d1 = new Date(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]), Integer.parseInt(str2[2]));  //TARÝH
			Date d3 = new Date(Integer.parseInt(str3[0]), Integer.parseInt(str3[1]));  //BOARDING TIME SAAT
			Date d2 = new Date(Integer.parseInt(str4[0]), Integer.parseInt(str4[1]));  //ARRIVAL TIME SAAT
			Flight flight = new Flight(str[0],d1, d3,d2, str[4], str[5], plane, getPilots().get(count), attendants);
			getFlights().add(flight);			
			count++;
			registirationCount++;

			if (count == getPilots().size()) {
				count = 0;
			}

		}

	}

	public void displayFlights() {

		// flights will be imported from text file
		for (Flight f : getFlights()) {
			System.out.println(f.toString());
			f.changeCrewFlightTime(); // changes flight time of the employees that work in the flight
		}

	}

	public void displayEmployees() {
		// employees will be imported from text file
		for (Employee e : getEmployees()) {
			System.out.println(e.toString());
		}
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<FlightAttendant> getFlightAttendants() {
		return FlightAttendants;
	}

	public void setFlightAttendants(List<FlightAttendant> flightAttendants) {
		FlightAttendants = flightAttendants;
	}

	public List<Salesman> getSalesmans() {
		return salesmans;
	}

	public void setSalesmans(List<Salesman> salesmans) {
		this.salesmans = salesmans;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}