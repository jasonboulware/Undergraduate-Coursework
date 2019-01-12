import java.text.DecimalFormat;
/**
 * This is a concrete class of the Ticket class. The price of the ticket is determined by how many
 * days prior to the event the ticket is purchased. The toString displays the ticket number and 
 * price.
 * 
 * @author Jason Boulware    
 * @due date 4/14/2017
 */
public class AdvanceTicket extends Ticket{

    private final double EARLY_PRICE = 30.00;//Reflects price of ticket if ordered 10 or more days
    private final double REGULAR_PRICE = 40.00;//Reflects price of ticket if ordered less than 10 days
    private int days;//stores the amount of days BEFORE the event the ticket was purchased
    DecimalFormat df = new DecimalFormat("#.00");//Formats decimal space to two

    /*
     * Advance Ticket constructor. Recieves a ticket number and days purchased prior to the event
     * Precondition: None
     */
    public AdvanceTicket(int number, int days)throws BadTicketNumberException, BadDaysRangeException{
        super(number);
        if (days < 0 ){
            throw new BadDaysRangeException(days);
        }
        else if (days > 180){
            throw new BadDaysRangeException("Exception: Cannot sell a ticket with " + days + 
            " days in advance.");
        }
        else{
            this.days = days;
        }
        getPrice();
    }

    /*
     * Gets the price of the tickets depending on when the ticket was purchased. If the 
     * ticket was purchased 10 days before the event or later, the method returns a lower price 
     * than if the ticket was purchased under 10 days before the event
     */
    public double getPrice(){
        if (getDays() >= 10){
            return EARLY_PRICE;
        } 
        else{
            return REGULAR_PRICE;
        }
    }

    /*
     * Returns the amount of days a ticket was purchased before the event
     */
    public int getDays(){
        return days;
    }

    /*
     * Shows a ticket number and price
     */
    public String toString(){
        return super.toString() + "Price: $" + df.format(getPrice());
    }
}
