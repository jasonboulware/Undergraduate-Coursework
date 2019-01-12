import java.text.DecimalFormat;
/**
 * This is subclass of Advance Ticket. Student advance ticket charges students half the price of 
 * normal advance tickets. The toString also tells the user that an ID is required to purchase the 
 * ticket
 * 
 * @author Jason Boulware 
 * @due date 4/7/2017
 */
public class StudentAdvanceTicket extends AdvanceTicket{
    
    DecimalFormat df = new DecimalFormat("#.00");//Formats decimal space to two to show dollar amount
    
    /*
     * Student Advance Ticket constructor. Recieves a ticket number and days purchased prior 
     * to the event
     * Precondition: Enters non-negative integers
     */
    public StudentAdvanceTicket(int number, int days)throws BadTicketNumberException, 
    BadDaysRangeException{
        super(number, days);
        getPrice();
    }

    /*
     * This method takes half of the normal advance tickets pricing for students.
     */
    public double getPrice(){
        return super.getPrice()/2;
    }
    
    /*
     * Shows a ticket number and price while telling the user ID is required to purchase
     * the ticket
     */
    public String toString(){
        return super.toString() + "(ID required)";
    }
}
