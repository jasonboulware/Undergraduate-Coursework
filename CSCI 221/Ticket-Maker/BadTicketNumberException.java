
/**
 * The BadTicketNumberException class is an exception thrown if a user enters a negative ticket
 * number or a ticket number already in use.
 * 
 * @author Jason Boulware
 * @date 4/14/17
 */
public class BadTicketNumberException extends Exception
{
    public BadTicketNumberException(int number){
        super("Exception: Cannot sell ticket number " + number + ". Invalid number provided.");
    }

    public BadTicketNumberException (String msg){
        super(msg);
    }
}
