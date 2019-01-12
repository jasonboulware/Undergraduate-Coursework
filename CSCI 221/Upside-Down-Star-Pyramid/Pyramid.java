import java.util.Scanner;

/**
 * Draw the figure shown on the Lab4 sheet with base width provided by user.
 * 
 * @author (Jason Boulware)  
 * @version (February 3, 2017)
 */
public class Pyramid
{
   public static void main(String [] args)
   {
       
       Scanner keyboard = new Scanner(System.in); 
       int space, ast, i, row;
       
       // Prompt user for an odd number, & keep asking until 
       // an odd number is provided.
       do{
           System.out.print("Please enter an odd number: ");
           row = keyboard.nextInt();
        }while (row%2 == 0); 
       
        // Print triangle
        for (i = row;  i >= 1; i-=2)
        {
            for (space = 0; space <= row - i; space++)
            {
                System.out.print(" ");
            }
                for(ast = 0; ast != i; ast++)
                {
                    System.out.print(" *");
                }       
            System.out.println();
        }
       
   }
 }
