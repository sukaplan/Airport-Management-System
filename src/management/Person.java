package management;

abstract public class Person {

	String name;
	String surname;
	Date birthdate;
	Phone phoneNumber;

	public Person(String name, String surname, Date birthdate, Phone phoneNumber) {

		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
	}
	public Person(String name, String surname, String birthdate, Phone phoneNumber) {

		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = this.birthdate.splitDate(birthdate);
		this.phoneNumber = phoneNumber;
	}


	public Person(String name, String surname, Date birthdate) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
	}

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Phone getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {

		return "Name : " + this.name + " Surname  " + this.surname + " Birthdate: " + this.birthdate.displayDate()
				+ " Phone: " + this.phoneNumber.displayPhone();
	}

	
}
