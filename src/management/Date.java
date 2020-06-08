package management;

public class Date extends Exception {

	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;

	public Date(int day, int month, int year,int hour, int minute) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	} 
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public Date() {
		super();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int toMinute() {
		return this.hour * 60 + this.minute;
	}

	public String HourtoString() {
		return this.hour + ":" + this.minute;
	}

	public String displayDate() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	public Date splitDate(String date) {

		Date d = new Date();
		if (date.contains("/")) {
			String[] split = date.split("/");
			d = new Date(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

		} else if (date.contains(":")) {
			String[] split = date.split(":");
			d = new Date(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

		}

		return d;
	}

}
