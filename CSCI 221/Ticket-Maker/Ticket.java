import java.util.*;
/**
 * Abstract class Ticket - write a description of the class here
 * 
 * @author Jason Boulware
 * @due date 04/14/2017
 */
public abstract class Ticket 
{
    private int number;//This variable holds a tickets number. 
    private static ArrayList<Integer> tikNum = new ArrayList<Integer>();//Arraylist for tik numbers

    public Ticket(int number) throws BadTicketNumberException{

        if (number < 0){
            throw new BadTicketNumberException(number);
        }
        else if (tikNum.contains(number)){
            throw new BadTicketNumberException("Exception: Cannot sell ticket number " + number +
                ". Ticket number already in use.");
        }
        else{
            this.number = number;
            tikNum.add(number);
        }
    }

    public abstract double getPrice();

    public String toString(){
        return "Ticket Number: " + number + ", ";
    }

    /*
     * This will compare tickets via number, puttig higher ticket numbers ordered higher.
     */
    public int compareTo(Object otherTik){
        int compare = 0;
        if (otherTik != null && otherTik instanceof Ticket){
            Ticket otherTicket = (Ticket)otherTik;
            compare = number - otherTicket.number;
        }
        return compare;
        //return Integer.compare(this.number, other.number);
    }

}
