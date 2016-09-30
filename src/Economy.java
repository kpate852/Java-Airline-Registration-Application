
public class Economy {

	private int rows=30;
	private int seats=6;
	private int seatsOccupied;
	private boolean full;
	private int[][] economyClassSeats;
	
	/**
	 * Creates an array of integers for the seating in Economy Class.
	 * If the value is 0 the seat is empty, if it is 1 the seat is occupied
	 */
	public Economy() {
		economyClassSeats=new int[rows][seats];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<seats; j++) {
				economyClassSeats[i][j]=0;
			}
		}
		seatsOccupied=0;
		
	}
	/**
	 * Finds an empty Window Seat
	 * Checks all the rows of the 2D array in column 0 and 3 
	 * Prints out results for the user to select a seat 
	 * If no window seats are found an error message prints
	 */
	public boolean findEmptyWindowSeats() {
		boolean found=false;
		for(int i=0; i<rows; i++) {
			if(economyClassSeats[i][0]==0) {
				System.out.println("The left window seat in Row "+i+" is available.");
				found=true;
			}
			if(economyClassSeats[i][5]==0) {
				System.out.println("The right window seat in Row "+i+" is available.");
				found=true;
			}

		}
		if(!found) {
			System.out.println("Sorry there are no window seats available in economy class.  Please make a different selection.");		
		}
		return found;
	}
	/**
	 * Finds an empty Aisle Seat
	 * Checks all the rows of the 2D array in column 1 and 2
	 * Prints out results for user to select a seat
	 * If no aisle seats are found an error message prints
	 */
	public boolean findEmptyAisleSeats() {
		boolean found=false;
		for(int i=0; i<rows; i++) {
			if(economyClassSeats[i][2]==0) {
				System.out.println("The left aisle seat in Row "+i+" is available.");
				found=true;
			}
			if(economyClassSeats[i][3]==0) {
				System.out.println("The right aisle seat in Row "+i+" is available.");
				found=true;
			}

			
		}
		if(!found) {
			System.out.println("Sorry, there are no aisle seats available in ecomony class.  Please make a different selection.");
		}
		return found;
	}
	
	public boolean findEmptyCenterSeats() {
		boolean found=false;
		for(int i=0; i<rows; i++) {
			if(economyClassSeats[i][1]==0) {
				System.out.println("The left center seat in Row "+i+" is available.");
				found=true;
			}
			if(economyClassSeats[i][4]==0) {
				System.out.println("The right center seat in Row "+i+" is avilable.");
				found=true;
			}
		}
		if(!found) {
			System.out.println("Sorry, there are no center seats available in economy class.  Please make a different selection.");
		}
		return found;
	}
	/**
	 * Finds a group of 2 seats together in economy class
	 * Checks each group of two seats in succession (1 and 2, 2 and 3, 4 and 5, 5 and 6) on each side of the aisle
	 * If no two consecutive seats are found, an error message prints
	 */
	public boolean findDoubleGroupedSeats() {
		boolean found=false;		
		for(int i=0; i<rows; i++) {
			if(economyClassSeats[i][0]==0 && economyClassSeats[i][1]==0) {
					System.out.println("The first and second seats of row "+i+" are available.");
					found=true;
				
			}
			if(economyClassSeats[i][1]==0 && economyClassSeats[i][2]==0) {
				System.out.println("The second and third seats of row "+i+" are available.");
				found=true;
			}
			if(economyClassSeats[i][3]==0 && economyClassSeats[i][4]==0) {
				System.out.println("The fourth and fifth seats of row "+i+" are available.");
				found=true;
			}
			if(economyClassSeats[i][4]==0 && economyClassSeats[i][5]==0) {
				System.out.println("The fifth and sixth seats of row "+i+" are available.");
				found=true;
			}

		}
		if(!found) {
			System.out.println("There are no double consecutive seats available in economy class.  Please make a different selection.");
		}
		return found;
		
	}
	/**
	 * Finds a group of 3 seats together in economy class
	 * Checks the left side of the aisle and the right side of the aisle for three consecutive seats
	 * If no three consecutive seats are found, an error message prints
	 */
	public boolean findTripleGroupedSeats()
	{
		boolean found=false;		
		for(int i=0; i<rows; i++) {
			if(economyClassSeats[i][0]==0 && economyClassSeats[i][1]==0 && economyClassSeats[i][2]==0) {
					System.out.println("There are three seats on the left side of row "+i+" available.");
					found=true;
			}
			if(economyClassSeats[i][3]==0 && economyClassSeats[i][4]==0 && economyClassSeats[i][5]==0) {
					System.out.println("There are three seats on the right side of row "+i+" available.");
					found=true;
			}

		}
		if(!found) {
			System.out.println("There are no triple consecutive seats available in economy class.  Please make a different selection.");
		}
		return found;
	}
	/**
	 * Adds passengers to the economy class seats
	 * @param reservation the reservation the user creates
	 */
	public void addPassengers(Reservation reservation) {
		if(reservation.getNumberOfPassengers()==1) {
			int row=reservation.getRow();
			int seat=reservation.getSeat();
			fillSeat(row, seat);
		}
		else if(reservation.getNumberOfPassengers()==2) {
			int row=reservation.getRow();
			int seat=reservation.getSeat();
			fillSeat(row, seat);
			fillSeat(row, seat+1);
		}
			else if(reservation.getNumberOfPassengers()==3) {
				int row=reservation.getRow();
				int seat=reservation.getSeat();
				fillSeat(row, seat);
				fillSeat(row, seat+1);
				fillSeat(row, seat+2);

		}
		
	}
	/**
	 * Changes the seat from unoccupied to occupied 
	 * @param row the row of the seat
	 * @param seat the seat the passenger reserved in that row
	 */
	public void fillSeat(int row, int seat) {
		economyClassSeats[row][seat]=1;
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
		if(economyClassSeats[row][seat]==1) {
			empty=false;
		}
		return empty;
	}
	/**
	 * Checks to see if the 2D array of seats in economy class is full
	 * @return true if the seats occupied equal the number of seats in economy, false if they don't equal
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
	 * Creates a String of the 2D array of seats in economy class
	 * Prints an X if the seat is occupied, nothing if the seat is free
	 */
	public String toString() {
		
		System.out.println("Economy Seating");
		String x="";
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<seats; j++) {
				x+="[";
				if(economyClassSeats[i][j]==1) {
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
