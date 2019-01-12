import java.io.File; // for use of files
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; // for use of Scanner class

/**
 * TicketTester exercises the Ticket hierarchy and the exception classes in
 * creating an ordered list of Tickets.
 * 
 * Jason Boulware
 */
public class TicketTester {

	public static void main(String[] args) {

		try {

			// the following line will throw a FileNotFoundException if
			// the file specified cannot be found.
			// DO NOT CHANGE FILE NAME when you submit
			File inputFile = new File("inputFile.txt");

			// add the code that reads from the input file and throws
			Scanner input = new Scanner(inputFile);

			// valid tickets will be stored, in order, in list
			ArrayList<Ticket> list = new ArrayList();
			// The following code reads from the file and
			// stores Ticket data into an ordered list

			// The loop to read the data encloses a
			// try-catch block to process input from input file
			// and continue reading until every line from the file
			// is read and processed.

			int line = 0;// variable keeps track of line number in the file.

			/*
			 * This loop ends when there are no more numbers in the file.
			 */
			while (input.hasNextLine()) {
				int x = input.nextInt(); // Checks file for the next int
				line++;// updates line in file
				Ticket tik = null;// Makes Ticket pointing to null, because its
									// an abstract class
				try {

					// if user enters 1, will create new WalkUpTicket with tik
					// number
					if (x == 1) {
						tik = new WalkupTicket(input.nextInt());
					}
					// if user enters 2, will create new AdvanceTicket with tik
					// number and days
					else if (x == 2) {
						tik = new AdvanceTicket(input.nextInt(),
								input.nextInt());
					}
					// if user enters 3, will create new StudentAdvanceTicket
					// with
					// tik number and days
					else if (x == 3) {
						tik = new StudentAdvanceTicket(input.nextInt(),
								input.nextInt());
					}
					// if user enters any other integer besides 1,2, or 3, will
					// throw new
					// BadInputCodeException
					else {
						input.nextLine();
						throw new BadInputCodeException("Bad code " + x
								+ " encountered on line " + line + " of "
								+ inputFile + ". Line ignored.");

					}

					boolean duplicate = false;// this variable will end the loop
												// if a ticket is found
					int index = list.size();// This variable keeps track of the
											// index for insertion
					// This loop determines where the new Ticket should go based
					// on ticket number
					for (int i = 0; i < list.size() && !duplicate; i++) {
						if (tik.compareTo(list.get(i)) <= 0) {
							index = i;
							duplicate = true;
						}
					}

					list.add(index, tik);// Inserts elements into the the
											// arraylist

				}
				// catch block for BadInputCodeException
				catch (BadInputCodeException e) {
					System.out.println(e.getMessage());
				}
				// catch block for BadDaysRangeException
				catch (BadDaysRangeException e) {
					System.out.println(e.getMessage());
				}
				// catch block for BadTicketNumberException
				catch (BadTicketNumberException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("--------------------------------");
			// You may add other methods, as necessary, to solve
			// this problem.

			// This loop displays the elements in the arraylist
			for (Ticket t : list) {
				System.out.println(t);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
			// Program terminates, as there is not input to process
		}
	}
}
