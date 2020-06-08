package management;

public class Salesman extends Employee{

	private int ticketSold;
	public Salesman(String name, String surname, Date birthdate, Phone phoneNumber, double salary) {
		super(name, surname, birthdate, phoneNumber, salary);
	}

	public Salesman(String name, String surname, Date birthdate, Phone phoneNumber) {
		super(name, surname, birthdate, phoneNumber);
	} 
	@Override
	public void  calculateSalary() {
		double x = 20;
		this.setSalary(this.getSalary() + (x * this.ticketSold)); 
		
	}

	public int getTicketSold() {
		return ticketSold;
	}

	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

	
}
