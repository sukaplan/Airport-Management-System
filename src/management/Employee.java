package management;

public abstract class Employee extends Person {

	private double salary = 0.0;

	public Employee(String name, String surname, Date birthdate, Phone phoneNumber) {
		super(name, surname, birthdate, phoneNumber);

	}

	public Employee(String name, String surname, Date birthdate, Phone phoneNumber, double salary) {
		super(name, surname, birthdate, phoneNumber);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public abstract void calculateSalary();
}
