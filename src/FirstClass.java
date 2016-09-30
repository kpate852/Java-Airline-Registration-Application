
public class FirstClass {

	private int rows=5;
	private int seats=4;
	private int seatsOccupied;
	private boolean full;
	private int[][] firstClassSeats;
	
	/**
	 * Creates an array of integers for the seating in First Class.
	 * If the value is 0 the seat is empty, if it is 1 the seat is occupied
	 */
	public FirstClass() {
		firstClassSeats=new int[rows][seats];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<seats; j++) {
				firstClassSeats[i][j]=0;
			}
		}
		seatsOccupied=0;
		
	}
	/**
	 * Finds an empty Window Seat
	 * Checks all the rows of the 2D array in column 0 and 3 
	 * Prints out results for the user to select a seat 
	 * If no window seats are found an error message prints
	 * @return true if empty window seats are found, false if they aren't found.
	 */
	public boolean findEmptyWindowSeats() {
		boolean found=false;
		for(int i=0; i<rows; i++) {
			if(firstClassSeats[i][0]==0) {
				System.out.println("The left window seat in Row "+i+" is available.");
				found=true;
			}
			if(firstClassSeats[i][3]==0) {
				System.out.println("The right window seat in Row "+i+" is available.");
				found=true;
			}

		}
		if(!found) {
			System.out.println("Sorry there are no window seats available in first class.  Please make a different selection.");		
		}
		return found;
		
	}
	/**
	 * Finds an empty Aisle Seat
	 * Checks all the rows of the 2D array in column 1 and 2
	 * Prints out results for user to select a seat
	 * If no aisle seats are found an error message prints
	 * @return true if empty aisle seats are found, false if none are found
	 */
	public boolean findEmptyAisleSeats() {
		boolean found=false;
		for(int i=0; i<rows; i++) {
			if(firstClassSeats[i][1]==0) {
				System.out.println("The left aisle seat in Row "+i+" is available.");
				found=true;
			}
			if(firstClassSeats[i][2]==0) {
				System.out.println("The right aisle seat in Row "+i+" is available.");
				found=true;
			}

			
		}
		if(!found) {
			System.out.println("Sorry, there are no aisle seats available in first class.  Please make a different selection.");
		}
		return found;
	}
	/**
	 * Finds a group of 2 seats together in first class
	 * Checks the left side of the aisle and the right side of the aisle for two consecutive seats
	 * If no two consecutive seats are found, an error message prints
	 * @return true if grouped seats are found, false if they aren't found
	 */
	public boolean findGroupedSeats() {
		boolean found=false;		
		for(int i=0; i<rows; i++) {
			if(firstClassSeats[i][0]==0) {
				if(firstClassSeats[i][1]==0) {
					System.out.println("There are two seats on the left side of row "+i+" available.");
					found=true;
				}
			}
			if(firstClassSeats[i][2]==0) {
				if(firstClassSeats[i][3]==0) {
					System.out.println("There are two seats on the right side of row "+i+" available.");
					found=true;
				}
			}

		}
		if(!found) {
			System.out.println("There are no consecutive seats available in first class.  Please make a different selection.");
			
		}
		return found;
		
	}
	/**
	 * Adds passengers to the first class seats
	 * @param reservation the reservation the user creates
	 */
	public void addPassengers(Reservation reservation) {
		if(reservation.getNumberOfPassengers()==1) {
			int row=reservation.getRow();
			int seat=reservation.getSeat();
			fillSeat(row, seat);
			//firstClassSeats[row][seat]=1;
		}
		else if(reservation.getNumberOfPassengers()==2) {
			int row=reservation.getRow();
			int seat=reservation.getSeat();
			fillSeat(row, seat);
			fillSeat(row, seat+1);
			//firstClassSeats[row][seat]=1;
			//firstClassSeats[row][seat+1]=1;
		}
		
	}
	/**
	 * Changes the seat from unoccupied to occupied 
	 * @param row the row of the seat
	 * @param seat the seat the passenger reserved in that row
	 */
	public void fillSeat(int row, int seat) {
		firstClassSeats[row][seat]=1;
		seatsOccupied++;
	}
	/**
	 * Checks to see if a seat is empty
	 * @param row the row chosen by the user
	 * @param seat the seat chosen by the user
	 * @return true if the seat is empty, false if it is reserved
	 */
	public boolean isEmpty(int row, int seat) {
		boolean empty=true;
		if(firstClassSeats[row][seat]==1) {
			empty=false;
		}
		return empty;
	}
	/**
	 * Checks to see if the 2D array of seats in first class is full
	 * @return true if occupied seats is equal to the number of seats in first class, false if they don't equal
	 */
	public boolean isFull() {
		if(seatsOccupied==rows*seats) {
			full=true;
		}
		else {
			full=false;
		}
		return full;
	}
	/**
	 * Creates a String of the 2D array of seats in first class
	 * Prints an X if the seat is occupied, nothing if the seat is free
	 */
	public String toString() {
		System.out.println("First Class Seating");
		String x="";
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<seats; j++) {
				x+="[";
				if(firstClassSeats[i][j]==1) {
					x+="X] ";
				}
				else {
					x+=" ] ";
				}
				
			}
			x+="\n";
		}
		return x;
	}
	
	

}
