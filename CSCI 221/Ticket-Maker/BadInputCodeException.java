
/**
 * The BadInputCodeException class is an exception thrown if a user inputs a number that is not between
 * 1-3. 
 * 
 * @author Jason Boulware 
 * @due date 4/14/07
 */
public class BadInputCodeException extends Exception
{    
    /*
     * Constructor used to create custom strings.
     */
    public BadInputCodeException(String msg){
        super(msg);
    }
}