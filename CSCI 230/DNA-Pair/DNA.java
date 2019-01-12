/*
 * This program is a double-strand DNA pattern checking and correcting
 * application. The user enters two sets of strings and the output is
 * determined by this input. 
 * 
 * Jason Boulware
 * 8/29/17
 * 
 */

package edu.cofc.csci230;

import java.util.Scanner;

public class DNA {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String upperDNA; // String for upper DNA strand.
		String lowerDNA; // String for lower DNA strand.
		String fixedLower = "";// Used to show corrections for the lower strand.
		char checkUpper;// Used to compare characters of the upper strand.
		char checkLower;// Used to compare characters of the lower strand.
		int compare = 0;// Counter used to compare characters of either strand.
		int flip = 0;// Switch counter set to 0. Changes for certain conditions.
		// Prompt user to enter upper DNA strand.
		System.out.print("Enter upper DNA strand: ");
		// Reads user input looking A,G,C,T.
		upperDNA = input.nextLine().toUpperCase();
		// Prompt user to enter lower DNA strand.
		System.out.print("Enter lower DNA strand: ");
		// Reads user input looking for A,G,C,T.
		lowerDNA = input.nextLine().toUpperCase();
		System.out.println();
		/*
		 * First conditional statement check to see if nothing is entered (Step
		 * 5). If either are empty, a message displays and the program ends.
		 */
		if (upperDNA.isEmpty() || lowerDNA.isEmpty()) {
			System.out.println("The entered upper strand or "
					+ "lower strand is not defined...Exiting program.");
		}
		/*
		 * Second conditional statement comparing the length of inputs entered
		 * (Step 6). If they do not match, a message displays and the program
		 * ends.
		 */
		else if (upperDNA.length() != lowerDNA.length()) {
			System.out.println("The entered upper and lower "
					+ "strands do not have the same "
					+ "number of\nchemical bases...Exiting program");
		}
		/*
		 * If both of these conditions are false, the program begins comparing
		 * characters and correcting issues if needed.
		 */
		else {
			/*
			 * initialize checkUpper to the first character in the upper strand.
			 * This part also checks the first letter to see if is not A,C,G, or
			 * T
			 */
			checkUpper = upperDNA.charAt(compare);
			if (checkUpper != 'A' && checkUpper != 'G' && checkUpper != 'C'
					&& checkUpper != 'T') {
				System.out.println("The entered upper and lower "
						+ "strands must only\n" + "contain combinations of"
						+ " A,G,C, or T...Exiting Program");
				flip++;// Changes this variable from 0 to 1, essentially
						// ending the program
			}
			/*
			 * This loop checks for characters other than A,C,G,T in the upper
			 * strand. If another character is present, a message displays and
			 * the program ends.
			 */
			while ((checkUpper == 'A' || checkUpper == 'G' || checkUpper == 'C' || checkUpper == 'T')
					&& (compare < upperDNA.length())) {
				checkUpper = upperDNA.charAt(compare);
				if (checkUpper != 'A' && checkUpper != 'G' && checkUpper != 'C'
						&& checkUpper != 'T') {
					System.out.println("The entered upper and lower "
							+ "strands must only\n" + "contain combinations of"
							+ " A,G,C, or T...Exiting Program");
					flip++;// Changes this variable from 0 to 1, essentially
							// ending the program
				}
				compare++;
			}
			// Resets compare counter
			compare = 0;
			/*
			 * initialize checkLower to the first character in the lower strand.
			 * This part also checks the first letter to see if is not A,C,G, or
			 * T
			 */
			checkLower = lowerDNA.charAt(compare);
			if ((checkLower != 'A' && checkLower != 'G' && checkLower != 'C' && checkLower != 'T')
					&& flip == 0) {
				System.out.println("The entered upper and lower "
						+ "strands must only\n" + "contain combinations of"
						+ " A,G,C, or T...Exiting Program");
				flip++;// Changes this variable from 0 to 1,
						// essentially ending the program
			}
			/*
			 * This loop checks for characters other than A,C,G,T in the lower
			 * strand. If another character is present, a message displays and
			 * the program ends.
			 */
			while ((checkLower == 'A' || checkLower == 'G' || checkLower == 'C' || checkLower == 'T')
					&& (compare < lowerDNA.length())) {
				checkLower = lowerDNA.charAt(compare);
				if (checkLower != 'A' && checkLower != 'G' && checkLower != 'C'
						&& checkLower != 'T') {
					System.out.println("The entered upper and lower "
							+ "strands must only\n" + "contain combinations of"
							+ " A,G,C, or T...Exiting Program");
					flip++;// Changes this variable from 0 to 1,
							// essentially ending the program
				}
				compare++;
			}
			/*
			 * This final part begins if all of the previous conditions for the
			 * program to work correctly are met (Step 8). The "flip" variable
			 * is not changed so the loop can be started. The loop compares
			 * characters for the upper strand as well as the lower strand in
			 * the same index. If there are corrections this will be displayed
			 * in a new variable called fixedLower as the program will correct
			 * the bottom strand to match correctly with the upper strand.
			 */
			if (flip == 0) {

				for (int i = 0; i < upperDNA.length(); i++) {
					checkUpper = upperDNA.charAt(i);
					checkLower = lowerDNA.charAt(i);
					if (checkUpper == 'A' && checkLower != 'T') {
						if (i == 0) {
							fixedLower = 't' + lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						} else if (i > 0) {
							fixedLower = lowerDNA.substring(0, i) + 't'
									+ lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						}
					}

					else if (checkUpper == 'T' && checkLower != 'A') {
						if (i == 0) {
							fixedLower = 'a' + lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						} else if (i > 0) {
							fixedLower = lowerDNA.substring(0, i) + 'a'
									+ lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						}
					}

					else if (checkUpper == 'G' && checkLower != 'C') {
						if (i == 0) {
							fixedLower = 'c' + lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						} else if (i > 0) {
							fixedLower = lowerDNA.substring(0, i) + 'c'
									+ lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						}
					}

					else if (checkUpper == 'C' && checkLower != 'G') {
						if (i == 0) {
							fixedLower = 'g' + lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						} else if (i > 0) {
							fixedLower = lowerDNA.substring(0, i) + 'g'
									+ lowerDNA.substring(i + 1);
							lowerDNA = fixedLower;
						}
					}
				}

				/*
				 * Final conditional statement (Step 9 and output for step 10).
				 * If fixedLower has not been altered from its original state as
				 * an empty String, then the message showing everything is
				 * correct is displayed, otherwise the other message correcting
				 * the error for the bottom strand is displayed ending the
				 * program.
				 */
				if (fixedLower.equals("")) {
					System.out.println("The entered double-strand DNA "
							+ "pattern is " + "correct...Exiting Program");
				} else {
					System.out
							.println("The entered double-strand DNA pattern had"
									+ " base-pair errors\nand the bottom strand has been"
									+ " corrected: "
									+ upperDNA
									+ " "
									+ fixedLower + "\n\n...Exiting Program");
				}
			}
			input.close();
		}
	}
}
