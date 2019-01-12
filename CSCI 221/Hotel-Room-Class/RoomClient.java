
/**
 * CSCI 221, Spring 2017, HW 3
 * This program tests the Room class. 
 * DO NOT MODIFY IT!
 * 
 * @author (McCauley) 
 */
public class RoomClient
{
    public static void main(String [] args)
    {
        System.out.println("Hotel has " + Room.getNumberOfRooms() + ".");
        System.out.println("Hotel capacity is " + Room.getTotalCapacity() + ".");
        System.out.println();
        
        // The following code creates a list (actually, an array) of many rooms
        Room [] room =
        { /* room[0] */ new Room("103", "Gold", 100, 'T', false, null),
          /* room[1] */ new Room("104", "Silver", 50, 'T', false, null), 
          /* room[2] */ new Room("213", null, 200, 'C', true, "CBU"),
          /* room[3] */ new Room("214", null, 100, 'C', true, "CBU"),
          /* room[4] */ new Room("215", null, 100, 'C', true, "CBU"),
          /* room[5] */ new Room("350", "Penthouse Boardroom", 15, 'E',false, null)
        };
        // Set the rooms that can be combined with other rooms
        room[1].updateCanBeCombinedWith(room[0]);
        room[0].updateCanBeCombinedWith(room[1]);
        room[3].updateCanBeCombinedWith(room[2]);
        room[4].updateCanBeCombinedWith(room[3]);
        
        
        // The following goes through all of the rooms in the list of rooms
        System.out.println("Room inventory:");
        for (Room x : room) {
            System.out.println(x); // << implicit call to toString( )
        }
        
        System.out.println("Hotel has " + Room.getNumberOfRooms() + " rooms.");
        System.out.println("Hotel capacity is " + Room.getTotalCapacity() + " people.");
        System.out.println();
        System.out.println("Can room 215 be changed to theatre setup?");
        System.out.println("Before calling reconfigure method, room 215: \n" + room[4]);
        room[4].reconfigure('T');
        System.out.println("After reconfigure request, room 215 should show no change:");
        System.out.println(room[4]);
        System.out.println();
        System.out.println("Can room 215 be changed to U-shape setup?");
        System.out.println("Before calling reconfigure method, room 215: \n" + room[4]);
        room[4].reconfigure('U');
        System.out.println("After reconfigure request, room 215 should show setup change:");
        System.out.println(room[4]);
        System.out.println();
        System.out.println("Is room 215 compatible with room 214?");
        System.out.println("Should be true. It is: " + room[4].isCompatibleWith(room[3]));
        System.out.println();
        System.out.println("Is room 215 compatible with room 103?");
        System.out.println("Should be false. It is: " + room[4].isCompatibleWith(room[0]));
        System.out.println();
    }
}