package management;

public class Pilot extends Employee {

	private double flightTime;

	public Pilot(String name, String surname, Date birthdate, Phone phoneNumber) {
		super(name, surname, birthdate, phoneNumber);
		flightTime = 0.0;
	}

	public Pilot(String name, String surname, Date birthdate, Phone phoneNumber, double salary) {
		super(name, surname, birthdate, phoneNumber, salary); 
		flightTime = 0.0;
	}

	public void calculateSalary() {

		double x = 20; // saat baþý olacaðý para
		this.setSalary(this.getSalary() + (x * this.flightTime)); 

	}

	public double getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(double flightTime) {
		this.flightTime = flightTime;
	}

}
