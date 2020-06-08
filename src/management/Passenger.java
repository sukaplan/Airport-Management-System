package management;

public class Passenger extends Person {

	public class Baggage {

		private int baggageID;
		private int weight;
		private int quantity;

		Baggage(int baggageID, int weight, int quantity) {
			this.weight = weight;
			this.quantity = quantity;
			this.baggageID = baggageID;
		}

		boolean IsAcceptable() {
			return this.weight <= 15 && this.quantity == 1;
		}

		public int getBaggageWeight() {
			return this.weight;
		}

		public void setBaggageWeight(int weight) {
			this.weight = weight;
		}

		public int getQuantity() {
			return this.quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getBaggageID() {
			return baggageID;
		}

		public void setBaggageID(int baggageID) {
			this.baggageID = baggageID;
		}

	}

	private int passengerID;
	private Baggage baggage;

	public Baggage getBaggage() {
		return baggage;
	}

	public Passenger(int passengerID, String name, String surname, Date birthdate, Phone phone) {
		super(name, surname, birthdate, phone);
		this.setPassengerID(passengerID);
		Baggage baggage1 = new Baggage(0, 0, 0);
		this.baggage = baggage1;
		
	}

	public int getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}
}
