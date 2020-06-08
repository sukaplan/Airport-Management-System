package management;

import java.util.List;

public class Manager extends Employee {

	// deðiþti

	static double max;

	public Manager(String name, String surname, Date birthdate, Phone phoneNumber, double salary) {
		super(name, surname, birthdate, phoneNumber, salary);
	}

	public void addEmployee(Employee employee, List<Employee> employees) {
		employees.add(employee);

	}

	public void addEmployee(Pilot pilot, List<Pilot> pilots) {
		pilots.add(pilot);

	}

	public void addEmployee(FlightAttendant flightAttendant, List<FlightAttendant> FlightAttendants) {
		FlightAttendants.add(flightAttendant);

	}

	public void addEmployee(Salesman salesman, List<Salesman> salesmans) {
		salesmans.add(salesman);

	}

	public void deleteEmployee(Employee employee, List<Employee> employees) {
		int index = 0;
		for (Employee e : employees) {
			if (employee.getName().equals(e.getName())) {
				employees.remove(index);
				break;
			}
			index++;
		}
	}

	public void deleteEmployee(Pilot pilot, List<Pilot> pilots) {
		int index = 0;
		for (Employee e : pilots) {
			if (pilot.getName().equals(e.getName())) {
				pilots.remove(index);
				break;
			}
			index++;
		}
	}

	public void deleteEmployee(FlightAttendant flightAttendant, List<FlightAttendant> FlightAttendants) {
		int index = 0;
		for (Employee e : FlightAttendants) {
			if (flightAttendant.getName().equals(e.getName())) {
				FlightAttendants.remove(index);
				break;
			}
			index++;
		}
	}

	public void deleteEmployee(Salesman salesman, List<Salesman> salesmans) {
		int index = 0;
		for (Employee e : salesmans) {
			if (salesman.getName().equals(e.getName())) {
				salesmans.remove(index);
				break;
			}
			index++;
		}
	}

	public void changeSalary(Employee employee, double newsalary) {
		employee.setSalary(newsalary);
	}

	public void calculateManagerSalary(List<Employee> employees) {
		max = 0;
		for (Employee e : employees) {
			if (max < e.getSalary()) {
				max = e.getSalary();
			}
		}

	}

	@Override
	public void calculateSalary() {
		this.setSalary(max + 5000);
	}

}
