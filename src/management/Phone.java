package management;

public class Phone {

	private String countrycode;
	private String areacode;
	private String number;
	
	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Phone(String countrycode, String areacode, String number) {
		super();
		this.countrycode = countrycode;
		this.areacode = areacode;
		this.number = number;
	}
	
	public String displayPhone() {
		return this.countrycode + " " + this.areacode + " " + this.number;
	}
	
	
	
}
