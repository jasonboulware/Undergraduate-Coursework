/**
 * Test Driver for AdvanceTicket, StudentAdvanceTicket, and WalkupTicket class. Contains a polymorphic 
 * array to show different ticket types.
 * 
 * @author Jason Boulware    
 * @due date 04/14/2017
 */
public class TestTickets
{
    public static void main(String[]args){
        try{
            Ticket [] tic = new Ticket[15];
            tic[0] = new WalkupTicket(1);
            tic[1] = new WalkupTicket(2);
            tic[2] = new WalkupTicket(3);
            tic[3] = new WalkupTicket(4);
            tic[4] = new WalkupTicket(5);
            tic[5] = new AdvanceTicket(6, 1);
            tic[6] = new AdvanceTicket(7, -5);
            tic[7] = new AdvanceTicket(8, 22);
            tic[8] = new AdvanceTicket(9, 2);
            tic[9] = new AdvanceTicket(10, 44);
            tic[10]= new StudentAdvanceTicket(11, 44);
            tic[11]= new StudentAdvanceTicket(12, 2);
            tic[12] = new StudentAdvanceTicket(13,10);
            tic[13]= new StudentAdvanceTicket(14, 7);
            tic[14]= new StudentAdvanceTicket(15, 28);

            for (Ticket t : tic){
                System.out.println(t);
            }
            System.out.println(tic[0].compareTo(tic[10]));
        }

        catch(BadTicketNumberException e){
            System.out.println(e.getMessage());
        }
        catch(BadDaysRangeException e){
            System.out.println(e.getMessage());
        }
    }
}

