import java.text.DecimalFormat;
/**
 * This is a concrete class of the Ticket class. The total price for a walkup ticket is $50. 
 * The toString displays a ticket number and the price.
 * 
 * @author Jason Boulware 
 * @date 04/14/2017
 */
public class WalkupTicket extends Ticket
{
    private final double price = 50.00;//Reflects total price of ticket for walkup sales
    DecimalFormat df = new DecimalFormat("#.00");//Formats decimal space to two to show dollar amount
    
    /*
     * Walkup Ticket constructor. Recieves a ticket number
     * Precondition: Enters non-negative integer
     */
    public WalkupTicket(int number)throws BadTicketNumberException{
        super(number);
        getPrice();
    }
    
    /*
     * This method returns the price of a walkup ticket
     */
    public double getPrice(){
        return price;
    }
    
    /*
     * Shows the ticket number and price for a walkup ticket.
     */
    public String toString(){
        return super.toString() + "Price: $" + df.format(getPrice());
    }
}
