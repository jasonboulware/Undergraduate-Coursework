
/**
 * The BadDaysRangeException class is an exception thrown if a user enters 
 * a negative day or day above 180.
 * 
 * @author Jason Boulware 
 * @due date 4/14/17
 */
public class BadDaysRangeException extends Exception
{
    /*
     * This constructor takes an int and gives this output. 
     */
    public BadDaysRangeException(int days){
        super("Exception: " + days + " Days in advance specified must be positive.");
    }
    
    /*
     * Constructor used to create custom strings.
     */
    public BadDaysRangeException(String msg){
        super(msg);
    }
}
