import java.util.Scanner;
/**
 * In class lab 3: Compute the cost of a coffee order. See txt file for details.
 * A rework of the in class lab I did on my own. I was unable to complete in class, so
 * I tried working on it by myself
 * 
 * @author (Jason) 
 * @version (02/05/17)
 */
public class CoffeeOrder
{
    public static void main(String [] args){
        
        Scanner keyboard = new Scanner(System.in);
        
        // Get coffee order
        System.out.print("How many bags of coffee are you ordering? ");
        int bags = keyboard.nextInt();
        
        // Compute cost of coffee
        double coffeeCost = bags * 5.5;
        
        System.out.printf("\nNumber of bags ordered: %d - $%.2f\n",bags, coffeeCost);
        
        // Compute discount
        int discountAmount = 0;
        
        // add code here to compute discount
        if (bags >= 300)
        {
            discountAmount = 30;
        }
        else if (bags >= 150)
        {
            discountAmount = 20;
        }
        else if (bags >= 50)
        {
            discountAmount = 10;
        }
        
        double discount = 0;
        
        // add code here to compute discount
        discount = ((.01 * discountAmount) * coffeeCost);
        
        System.out.printf("Discount: %d%% - $%.2f\n",discountAmount, discount);
        
        // Compute the boxes needed
        int largeBoxes = 0;
        int regularBoxes = 0;
       
        // add code here to compute box counts (use / and %)
        largeBoxes = bags / 20;
        bags = bags % 20;
        regularBoxes = bags / 5;
        bags = bags % 5;
       
        
        // Compute the cost of boxes - ADD CODE to compute box costs
        double costLargeBoxes = largeBoxes * 1.5;
        double costRegularBoxes = regularBoxes * .5;
        
        // Computer cost of total order - ADD CODE to compute totalcost
        double costOfOrder = ((coffeeCost - discount) + costLargeBoxes + costRegularBoxes);
        System.out.println("Boxes Used:");
        System.out.printf("\t"+ largeBoxes +" Large = $%.2f\n", costLargeBoxes);
        System.out.printf("\t"+ regularBoxes +" Regular = $%.2f\n", costRegularBoxes);
        System.out.printf("\nTotal Cost: $%.2f\n",costOfOrder);
     
      
    }
    
}
