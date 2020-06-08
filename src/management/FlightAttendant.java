package management;

public class FlightAttendant extends Employee {

	private double flightTime;
	
	
	public FlightAttendant(String name, String surname, Date birthdate, Phone phoneNumber, double salary) {
		super(name, surname, birthdate, phoneNumber, salary);
		flightTime = 0.0;
	}

	public FlightAttendant(String name, String surname, Date birthdate, Phone phoneNumber) {
		super(name, surname, birthdate, phoneNumber);
		flightTime = 0.0;
	}

	public double getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(double flightTime) {
		this.flightTime = flightTime;
	}

	@Override
	public void calculateSalary() {
		double x = 20; // saat baþý olacaðý para
		this.setSalary(this.getSalary() + (x * this.flightTime)); 

	}
}
