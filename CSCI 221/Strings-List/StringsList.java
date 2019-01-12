
/**
 * Class contains a constructor for StringsList array and methods to manipulate StringsList.
 * A StringsList object stores 0 or more String objects, with many empty locations, if any at
 * the end of the list.
 * 
 * @author Jason Boulware 
 * @due date 3/18/17
 */
public class StringsList
{
    private String [] list; 
    private int size = 0;

    /*
     * Constructor for the an array of Strings at max 10
     * Preconditions: none
     */
    public StringsList(){
        list = new String[10];
    }

    /*
     * holds the int for size, which lists the total number of elements in the array
     */
    public int size(){
        return size;
    }

    /*
     * Adds a String to the end of the list
     * Precondition: user enters a String and non-null
     * Postcondition: list has a appended, size is updated accordingly
     */
    public void add(String a){
        size++;
        enlarge();
        list[size()-1] = a;
    }

    /*
     * Inserts String a into a "location" in the array. If there is a String in this location, 
     * move the rest of the Strings further down the array.
     * Precondition: location is in the range of 1 to size+1
     * Postcondition: contents modified as necessary and size is updated accordingly
     */
    public void insert(String a, int location){
        size++;   
        enlarge();
        int i = list.length - 1;

        while(i >= 0 && i != (location -1)){
            list[i] = list[i-1];
            i--;
        }

        list[location -1] = a;

    }

    /*
     * Returns true if String a is in the list, false otherwise
     */
    public boolean contains(String a){
        boolean has = false;

        for(int i = 0; has == false && i < size; i++){

            if (list[i].equals(a)){
                has = true;
            }            

        }

        return has;
    }
    
    /*
     * Returns the index (a value from 1 to size) of String a in the list, or -1 is String a is
     * not in the list.
     */
    public int find(String a){
        boolean has = false;
        int index = 0;
        int temp = 0;

        for (int i = 0; i < size; i++){

            if (list[i].equals(a)){
                has = true;
                return temp = i + 1;
            }

        }

        if (has == false){
            index = -1;
        }

        return index;
    }
    
    /*
     * Removes the String a, if it is in the list. Any other Strings are moved so there are
     * no holes in the array.
     * Postcondition: contents modified as necessary and size is updated accordingly
     */
    public void delete (String a){
        //System.out.println("Not Implemented");
        for (int counter = 0; counter < size; counter++){

            if (list[counter].equals(a)){

                while (counter < size){
                    list[counter] = list[counter + 1];
                    counter++;
                }
                size--;
            }

        }

    }
    
    /*
     * Prints the contents of the StringsList for every location within the capacity of the list,
     * showing the location of each element. For those locations where no String is stored,
     * print null as the value.
     */
    public void displayList(){
        System.out.println("StringList: capacity " + list.length + ", size " + size());

        for(int i = 0; i < list.length; i++){

            if (list[i] != null){
                System.out.println("[" + (i+1) + "] " + list[i]);
            }
            else{
                System.out.println("[" + (i+1) + "] null");
            }

        }

        System.out.println();
    }

    /*
     * Doubles the capacity of the list, whenever needed. Called by insert and add method when a 
     * user inserts elements into a full list. 
     * Precondition: none
     * Postcondition: instanace variables modified as necessary
     */
    private void enlarge(){
        if (size() > list.length){
            String [] temp = new String [list.length];

            for (int i = 0; i < temp.length; i ++){ 
                temp[i] = list[i];
            }

            list = new String[list.length * 2];

            for (int j = 0; j < temp.length; j++){
                list[j] = temp[j];
            }
            
        }
    }
}