
/**
 * CSCI 221 Programming HW 3
 * This class defines the Room object. Rooms may have a name, number, capacity, set up, 
 * and configuration options. The room also may or may not be reconfigurable
 * 
 * @author Jason Boulware 
 * @version 02/19/17
 */
public class Room
{
    private String number;
    private String name;
    private int capacity;
    private char setUp;
    private boolean isReconfigurable;
    private String configureOptions;
    private Room canBeCombinedWith = null;
    private static int numberOfRooms = 0;
    static int totalCapacity = 0;

    /*
     * initializes instance variable number, name, capacity, setUp, isReconfigurable, 
     * configureOptions
     * Precondition: number valid, name null or valid, capacity and setUp are valid
     * isReconfigurable true or false, configureOptions null or valid
     */
    public Room(String number, String name, int capacity, char setUp, boolean
    isReconfigurable, String configureOptions){
        this.number = number;
        this.name = name;
        this.capacity = capacity;
        this.setUp = setUp;
        this.isReconfigurable = isReconfigurable;
        this.configureOptions = configureOptions;
        numberOfRooms++;
        totalCapacity = totalCapacity + capacity;
    }

    /*
     * updates the object canBeCombinedWith
     */
    public void updateCanBeCombinedWith(Room r){
        canBeCombinedWith = r;
    }

    /*
     * returns variable capacity
     */
    public int getRoomCapacity(){
        return capacity;
    }

    /*
     * Loop determines if a room can be configured to a certain setup, it will change.
     */
    public void reconfigure(char option){
        if (isReconfigurable){
            for (int k = 0; k < configureOptions.length(); k++){
                if (configureOptions.charAt(k) == option){          
                    setUp = option;
                }
            }
        }
    }

    /*
     * Checks to see if two room objects are compatible. Returns true if all conditions
     * are met
     */
    public boolean isCompatibleWith(Room other){
        boolean compatible = false;

        if (capacity == other.capacity && isReconfigurable == other.isReconfigurable
        && configureOptions.equals(other.configureOptions))
            compatible = true;

        return compatible;
    }

    /*
     * returns string representation of rooms
     */
    public String toString(){
        String output = "";
        if (canBeCombinedWith != null && isReconfigurable == false && name != null){
            System.out.println("Room number: " + number);
            System.out.println("   Name: " + name);
            System.out.println("   Capacity: " + capacity);
            System.out.println("   Setup : " + getOptionLetter());
            System.out.println("   can be combined with room # " + canBeCombinedWith.getNumber());
        }
        else if (canBeCombinedWith != null && isReconfigurable == true){
            System.out.println("Room number: " + number);
            System.out.println("   Capacity: " + capacity);
            System.out.println("   Setup : " + getOptionLetter());
            System.out.println("   Reconfigure options : " + getConfig());
            System.out.println("   can be combined with room # " + canBeCombinedWith.getNumber());
        }
        else if (canBeCombinedWith == null && isReconfigurable == true){
            System.out.println("Room number: " + number);
            System.out.println("   Capacity: " + capacity);
            System.out.println("   Setup : " + getOptionLetter());
            System.out.println("   Reconfigure options : " + getConfig());
        }
        else if (canBeCombinedWith == null && isReconfigurable == false && name != null){
            System.out.println("Room number: " + number);
            System.out.println("   Name: " + name);
            System.out.println("   Capacity: " + capacity);
            System.out.println("   Setup : " + getOptionLetter());
        }
        return output;
    }

    /*
     * Returns the number of room objects created
     */
    public static int getNumberOfRooms(){
        return numberOfRooms;
    }

    /*
     * Returns the total capacity of the rooms
     */
    public static int getTotalCapacity(){
        return totalCapacity;
    }

    /*
     * The following methods are helper methods
     */
    //Helper method to get string version of setUp options
    public String getOptionLetter(){
        String opt = "";

        if (setUp == 'C')
            opt = "Classroom";
        else if (setUp == 'T')
            opt = "Theatre";
        else if (setUp == 'U')
            opt = "U-shape";
        else if (setUp == 'B')
            opt = "Banquet";
        else if (setUp == 'E')
            opt = "Boardroom";

        return opt;
    }

    /*
     * Helper method to get string version of configureOptions
     */
    public String getConfig(){
        String opt = "";
        if (configureOptions.contains("CBUET")){
            opt = "Classroom, Banquet, U-shape, Boardroom, Theatre";
        }
        else if (configureOptions.contains("CBUE")){
            opt = "Classroom, Banquet, U-shape, Boardroom";
        }
        else if (configureOptions.contains("CBUT")){
            opt = "Classroom, Banquet, U-shape, Theatre";
        }
        else if (configureOptions.contains("CBET")){
            opt = "Classroom, Banquet, Boardroom, Theatre";
        }
        else if (configureOptions.contains("CUET")){
            opt = "Classroom, U-shape, Boardroom, Theatre";
        }
        else if (configureOptions.contains("BUET")){
            opt = "Banquet, U-shape, Boardroom, Theatre";
        }
        else if (configureOptions.contains("CBU")){
            opt = "Classroom, Banquet, U-shape";
        }
        else if (configureOptions.contains("CBE")){
            opt = "Classroom, Banquet, Boardroom";
        }
        else if (configureOptions.contains("CBT")){
            opt = "Classroom, Banquet, Theatre";
        }
        else if (configureOptions.contains("BUT")){
            opt = "Banquet, U-shape, Theatre";
        }
        else if (configureOptions.contains("BUE")){
            opt = "Banquet, U-shape, Boardroom";
        }
        else if (configureOptions.contains("BET")){
            opt = "Banquet, Boardroom, Theatre";
        }
        else if (configureOptions.contains("EUT")){
            opt = "Boardroom, U-shape, Theatre";
        }
        else if (configureOptions.contains("EUB")){
            opt = "Boardroom, U-shape, Banquet";
        }
        else if (configureOptions.contains("CB")){
            opt = "Classroom, Banquet";
        }
        else if (configureOptions.contains("C")){
            opt = "Classroom";
        }
        else if (configureOptions.contains("BT")){
            opt = "Banquet, Theatre";
        }
        else if (configureOptions.contains("B")){
            opt = "Banquet";
        }
        else if (configureOptions.contains("UT")){
            opt = "U-shape, Theatre";
        }
        else if (configureOptions.contains("U")){
            opt = "U-shape";
        }
        else if (configureOptions.contains("ET")){
            opt = "Boardroom, Theatre";
        }
        else if (configureOptions.contains("E")){
            opt = "Boardroom";
        }
        else if (configureOptions.contains("T")){
            opt = "Theatre";
        }
        return opt;
    }
    /*
     * Helper method that returns the String number from the Room object
     */
    public String getNumber(){
        return number;
    }
}

