
import java.util.Scanner;
public class ReservationSystem {
	public static void main(String [] args) {
		System.out.println("Welcome to our Reservation System");
		System.out.println("Use the menu below to use our Reservation System");
		Scanner keyboard=new Scanner(System.in);
		FirstClass class1=new FirstClass();
		Economy class2=new Economy();
		int choice=0;
		do {
			System.out.println("1: Make a Reservation");
			System.out.println("2: Show Seating");
			System.out.println("3: Quit");
			System.out.println("Please enter your choice.");
			choice=keyboard.nextInt();
			switch(choice) {
			
			case 1: {
				System.out.println("Do you want First Class or Economy Class?");
				System.out.println("Enter 1 for First Class or 2 for Economy.");
				int classChoice=keyboard.nextInt();
				if(classChoice==1) {
					if(class1.isFull()) {
						System.out.println("Sorry, first class is full.  Try in economy or wait for the next flight.");
					}
					else {
					System.out.println("How many passengers are you traveling with? The maximum number is 2.");
					int numberOfPassengers=keyboard.nextInt();
					if(numberOfPassengers==1) {
						System.out.println("Do you want a Window seat or an Aisle seat?");
						String locationChoice=keyboard.next();
						if(locationChoice.equalsIgnoreCase("Window")) {
							System.out.println("Searching for a Window Seat.....");
							if(!class1.findEmptyWindowSeats()) {
								System.out.println("Please try again.");
							}
							else {
							System.out.println("Please enter the row number you want to sit in from the choices above.");
							int rowChoice=keyboard.nextInt();
							if(rowChoice>4||rowChoice<0) {
								System.out.println("Error, please try again.");
							}
							else {
								System.out.println("Please enter the seat you want to sit in from the choices above.");
								System.out.println("Enter 0 for the left window seat or 3 for the right window seat.");
								int seatChoice=keyboard.nextInt();
								if(seatChoice==0||seatChoice==3) {
									Reservation reservation1=new Reservation(numberOfPassengers, classChoice, locationChoice, rowChoice, seatChoice);
									if(class1.isEmpty(reservation1.getRow(), reservation1.getSeat())) {
										class1.addPassengers(reservation1);
										System.out.println("Thank you for your reservation!");
									}
									else {
										System.out.println("Error, that seats are occupied.  Please try again.");
									}
								}
								else {
									System.out.println("Error, please try again.");
									
									
								}
							}
							}
						}
						else if(locationChoice.equalsIgnoreCase("Aisle")) {
							System.out.println("Searching for an Aisle Seat.....");
							if(!class1.findEmptyAisleSeats()) {
								System.out.println("Please try again.");
							}
							else {
							System.out.println("Please enter the row you want to sit in from the choices above.");
							int rowChoice=keyboard.nextInt();
							if(rowChoice>4||rowChoice<0) {
								System.out.println("Error, please try again.");
							}
							else {
								System.out.println("Please enter the seat you want to sit in from the choices above.");
								System.out.println("Enter 1 for the left aisle seat or 2 for the right aisle seat.");
								int seatChoice=keyboard.nextInt();
								if(seatChoice<1||seatChoice>2) {
									System.out.println("Error, please try again.");
								}
								else {
									Reservation reservation2=new Reservation(numberOfPassengers, classChoice, locationChoice, rowChoice, seatChoice);
									if(class1.isEmpty(reservation2.getRow(), reservation2.getSeat())) {
										class1.addPassengers(reservation2);
										System.out.println("Thank you for your reservation.");
									}
									else {
										System.out.println("Error, that seats are occupied.  Please try again.");
									}
								}
								
							}
							}
						}
						else {
							System.out.println("Error, please try again.");
						}
					}
					else if(numberOfPassengers==2) {
						if(!class1.findGroupedSeats()) {
							System.out.println("Please try again.");
						}
						else {
						System.out.println("Please enter the row you want to sit in from the choices above.");
						int rowChoice=keyboard.nextInt();
						if(rowChoice>4||rowChoice<0) {
							System.out.println("Error, please try again.");
						}
						else {
							System.out.println("Please enter the side of the plan you want to sit in, left or right");
							String side=keyboard.next();
							if(side.equalsIgnoreCase("left")||side.equalsIgnoreCase("right")) {
								Reservation reservation3=new Reservation(numberOfPassengers, classChoice, rowChoice, side);
								if(class1.isEmpty(reservation3.getRow(), reservation3.getSeat())&&class1.isEmpty(reservation3.getRow(), reservation3.getSeat()+1)) {
								class1.addPassengers(reservation3);
								System.out.println("Thank you for your reservation.");
								}
								else {
									System.out.println("Error, those seats are occupied.  Please try again.");
								}
							}
							else {
								System.out.println("Error, please try again.");
							}
						}
						}
					}
					else {
						System.out.println("Sorry you entered an invalid number of passengers.  Please try again.");
					}
					
					
					}	
				}
				else if(classChoice==2) {
					if(class2.isFull()) {
						System.out.println("Sorry, Economy class is full.  Try again in first class or wait for the next flight.");
					}
					else {
					System.out.println("How many passengers are you traveling with? The maximum number is 3.");
					int numberOfPassengers=keyboard.nextInt();
					if(numberOfPassengers==1) {
						System.out.println("Do you want a Window seat, an Aisle seat, or a Center seat?");
						String locationChoice=keyboard.next();
						if(locationChoice.equalsIgnoreCase("Window")) {
							System.out.println("Searching for a Window Seat.....");
							if(!class2.findEmptyWindowSeats()) {
								System.out.println("Please try again.");
							}
							else {
							System.out.println("Please enter the row number you want to sit in from the choices above.");
							int rowChoice=keyboard.nextInt();
							if(rowChoice>29||rowChoice<0) {
								System.out.println("Error, please try again.");
							}
							else {
								System.out.println("Please enter the seat you want to sit in from the choices above.");
								System.out.println("Enter 0 for the left window seat or 6 for the right window seat.");
								int seatChoice=keyboard.nextInt();
								if(seatChoice!=0||seatChoice!=6) {
									System.out.println("Error, please try agian.");
								}
								else {
									Reservation reservation1=new Reservation(numberOfPassengers, classChoice, locationChoice, rowChoice, seatChoice);
									if(class2.isEmpty(reservation1.getRow(), reservation1.getSeat())) {
										class2.addPassengers(reservation1);
										System.out.println("Thank you for your reservation.");
									}
									else {
										System.out.println("Sorry, that seat is already occupied.  Please try again.");
									}
								}
							}
							}
						}
						else if(locationChoice.equalsIgnoreCase("Aisle")) {
							System.out.println("Searching for an Aisle Seat.....");
							if(!class2.findEmptyAisleSeats()) {
								System.out.println("Try again.");
							}
							else {
							System.out.println("Please enter the row you want to sit in from the choices above.");
							int rowChoice=keyboard.nextInt();
							if(rowChoice>29||rowChoice<0) {
								System.out.println("Error, please try again.");
							}
							else {
								System.out.println("Please enter the seat you want to sit in from the choices above.");
								System.out.println("Enter 2 for the left aisle seat or 3 for the right aisle seat.");
								int seatChoice=keyboard.nextInt();
								if(seatChoice!=2||seatChoice!=3) {
									System.out.println("Error, please try again.");
								}
								else {
									Reservation reservation2=new Reservation(numberOfPassengers, classChoice, locationChoice, rowChoice, seatChoice);
									if(class2.isEmpty(reservation2.getRow(), reservation2.getSeat())) {
										class2.addPassengers(reservation2);
										System.out.println("Thank you for your reservation!");
									}
									else {
										System.out.println("Error, that seat is occupied.  Please try again.");
									}
								}
							}
							}
						}
						else if(locationChoice.equalsIgnoreCase("Center")) {
							System.out.println("Searching for a Center Seat.....");
							if(!class2.findEmptyCenterSeats()) {
								System.out.println("Try again.");
							}
							else {
							System.out.println("Please enter the row you want to sit in from the choices above.");
							int rowChoice=keyboard.nextInt();
							if(rowChoice>29||rowChoice<0) {
								System.out.println("Error, please try again.");
							}
							else {
								System.out.println("Please enter the seat you want to sit in from the choices above.");
								System.out.println("Enter 1 for the left center seat or 4 for the right center seat.");
								int seatChoice=keyboard.nextInt();
								if(seatChoice!=1||seatChoice!=4) {
									System.out.println("Error please try again");
								}
								else {
									Reservation reservation3=new Reservation(numberOfPassengers, classChoice, locationChoice, rowChoice, seatChoice);
									if(class2.isEmpty(reservation3.getRow(), reservation3.getSeat())) {
										class2.addPassengers(reservation3);
										System.out.println("Thank you for your reservation!");
									}
									else {
										System.out.println("Error, that seat is already occupied.  Please try again.");
									}
								}
							}
							}
						}
						else {
							System.out.println("Error, please try again.");
						}
					}
					else if(numberOfPassengers==2) {
						if(!class2.findDoubleGroupedSeats()) {
							System.out.println("Try again.");
						}
						else {
						System.out.println("Please enter the row you want to sit in from the choices above.");
						int rowChoice=keyboard.nextInt();
						if(rowChoice>29||rowChoice<0) {
							System.out.println("Error, please try again.");
						}
						else {
							System.out.println("Please enter the seats that you want.  Enter 1 for seats 0 and 1, Enter 2 for seats 1 and 2, Enter 3 for seats 3 and 4, Enter 4 for seats 4 and 5");
							int seats=keyboard.nextInt();
							if(seats<1||seats>4) {
								System.out.println("Error, please try again.");
							}
							else {
								Reservation reservation2=new Reservation(numberOfPassengers, classChoice, rowChoice, seats);
								if(class2.isEmpty(reservation2.getRow(), reservation2.getSeat())&&class2.isEmpty(reservation2.getRow(), reservation2.getSeat()+1)) {
									class2.addPassengers(reservation2);
									System.out.println("Thank you for your reservation.");
								}
								else {
									System.out.println("Error, those seats are already occupied.  Please try again.");
								}
							}
						}
						}
					}
						else if(numberOfPassengers==3) {
							if(!class2.findTripleGroupedSeats()) {
								System.out.println("Try again.");
							}
							else {
							System.out.println("Please enter the row you want to sit in from the choices above.");
							int rowChoice=keyboard.nextInt();
							if(rowChoice>29||rowChoice<0) {
								System.out.println("Error, please try again.");
							}
							else {
								System.out.println("Please enter the side of the plane you want to sit in, left or right.");
								String side=keyboard.next();
								if(side.equalsIgnoreCase("left")||side.equalsIgnoreCase("right")) {
									Reservation reservation2=new Reservation(numberOfPassengers, classChoice, rowChoice, side);
									if(class2.isEmpty(reservation2.getRow(), reservation2.getSeat())&&class2.isEmpty(reservation2.getRow(), reservation2.getSeat()+1)&&class2.isEmpty(reservation2.getRow(), reservation2.getSeat()+2)) {
										class2.addPassengers(reservation2);
										System.out.println("Thank you for your reservation.");
									}
									else {
										System.out.println("Error, those seats are already occupied.  Please try again.");
									}
								}
								else {
									System.out.println("Error, please try again.");
								}
							}
							}
					}
						else {
							System.out.println("Error.  Please try again.");
						}
					
					
					}
				}
				else {
					System.out.println("Error.  Please try again.");
				}
					
				break;
			}
			case 2: {
				System.out.println(class1);
				System.out.println(class2);
				break;
			}
			case 3: {
				System.out.println("Goodbye.");
				break;
			}
			default: {
				System.out.println("Please enter another choice.");
				break;
			}
			}
			
		}
		while(choice!=3);

	}

}
