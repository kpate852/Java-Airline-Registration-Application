
public class Reservation {
	private int numberOfPassengers;
	private int classChoice;
	private String seatLocation;
	private int assignedRow;
	private int assignedSeat;
	/**
	 * Constructor used when dealing with a one passenger reservation
	 * @param n the number of passengers
	 * @param c the class choice
	 * @param l the seat location (Window or Aisle)
	 * @param r the assigned row
	 * @param s the assigned seat
	 */
	public Reservation(int n, int c, String l, int r, int s) {
		numberOfPassengers=n;
		classChoice=c;
		seatLocation=l;
		assignedRow=r;
		assignedSeat=s;
	}
	/**
	 * Constructor used when dealing with a full row of passengers
	 * @param n the number of passengers
	 * @param c the class choice
	 * @param r the assigned row
	 * @param side the side of the plane (left or right)
	 */
	public Reservation(int n, int c, int r, String side) {
		numberOfPassengers=n;
		classChoice=c;
		assignedRow=r;
		if(side.equalsIgnoreCase("left")) {
			assignedSeat=0;
		}
		else if(side.equalsIgnoreCase("right")) {
			if(classChoice==1) {
				assignedSeat=2;
			}
			else if(classChoice==2) {
				assignedSeat=3;
			}
		}
	}
	/**
	 * Constructor used when dealing with a two passenger reservation in Economy class
	 * @param n the number of passengers
	 * @param c the class choice
	 * @param r the assigned row
	 * @param seats the seats the passenger selects.  There are four possibilities (Seats 0 and 1, Seats 1 and 2, Seats 3 and 4, Seats 4 and 5)
	 */
	public Reservation(int n, int c, int r, int seats) {
		numberOfPassengers=n;
		classChoice=c;
		assignedRow=r;
		if(seats==1) {
			assignedSeat=0;
		}
		else if(seats==2) {
			assignedSeat=1;
		}
		else if(seats==3) {
			assignedSeat=3;
		}
		else if(seats==4) {
			assignedSeat=4;
		}
	}
	/**
	 * Setter method for Seat
	 * @param row sets the row
	 * @param seat sets the seat
	 */
	public void assignSeat(int row, int seat) {
		assignedRow=row;
		assignedSeat=seat;
	}
	/**
	 * Getter method for the row
	 * @return the row the reservation is in
	 */
	public int getRow() {
		return assignedRow;
	}
	/**
	 * Getter method for the seat
	 * @return the seat the reservation is for
	 */
	public int getSeat() {
		return assignedSeat;
	}
	/**
	 * Adds passengers to the reservation
	 * @param n increases the number of passengers by that integer
	 */
	public void addPassengers(int n) {
		numberOfPassengers+=n;
	}
	/**
	 * Setter method
	 * Sets the class choice of the passenger
	 * If they are in first class switch to economy
	 * If they are in economy class switch to first
	 */
	public void setClass() {
		if(classChoice==1) {
			classChoice=2;
		}
		else if(classChoice==2) {
			classChoice=1;
		}
	}
	/**
	 * Setter method
	 * Sets the seat location of the reservation 
	 * @param desiredSeat the seat location (window or aisle) that the passenger wants
	 */
	public void setSeatLocation(String desiredSeat) {
		seatLocation=desiredSeat;
	}
	/**
	 * Getter method
	 * @return the number of passengers on the reservation
	 */
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	/**
	 * Getter method
	 * @return the class the person reserved
	 */
	public int getClassChoice() {
		return classChoice;
	}
	/**
	 * Getter method
	 * @return the seat location (window or aisle)
	 */
	public String getSeatLocation() {
		return seatLocation;
	}
	
	

}
 

