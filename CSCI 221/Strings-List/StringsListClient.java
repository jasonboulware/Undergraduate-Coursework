
/**
 * Test Client for StringsList Class.
 * 
 * @author Jason Boulware 
 * @version 1.0
 */
public class StringsListClient
{
    public static void main (String[]args){
        StringsList tess = new StringsList();
        
        System.out.println("Empty Array");
        tess.displayList();
        tess.add("One");
        tess.add("Boo");
        tess.add("Mew");
        tess.add("Two");
        tess.add("");
        
        System.out.println("After adding five elements including an empty string");
        tess.displayList();
        
        tess.add("Sour");
        tess.add("Janie");
        tess.add("Fleep");
        tess.add("Greep");
        tess.add("Sleep");
        
        
        System.out.println("After inserting five more elements");
        tess.displayList();
       
        tess.add("Voo");
        
        System.out.println("After adding the string 'Voo' to end of array");
        tess.displayList();
        
        System.out.println("Checking for String 'Drew'. Should be false : " + tess.contains("Drew"));
        System.out.println("Checking for String 'Boo'. Should be true : " + tess.contains("Boo"));
        System.out.println("Checking for String 'Zoo'. Should be false : " + tess.contains("Zoo"));
        System.out.println("Checking for String 'Two'. Should be true : " + tess.contains("Two"));
        System.out.println("Looks for index of 'One'. Should be 1 : " + tess.find("One"));
        System.out.println("Looks for index of 'Mew'. Should be 3 : " + tess.find("Mew"));
        System.out.println("Looks for index of 'Voo'. Should be 11 : " + tess.find("Voo"));
        tess.add("Dumb");
        System.out.println();
        
        System.out.println("New Array after a word outside of the original array length is added");
        tess.displayList();
        
        tess.insert("Drew", 5);
        
        System.out.println("Inserted string 'Drew' into location 5");
        tess.displayList();
        
        tess.insert("Glue", 14);
        
        System.out.println("Inserted string 'Glue' into location 14");
        tess.displayList();
        
        System.out.println("Checking for String 'Drew'. Should be true : " + tess.contains("Drew"));
        System.out.println("Looks for index of 'Gar'. Should be -1 : " + tess.find("Gar"));
        System.out.println();
        
        tess.delete("");
        tess.displayList();
        
        
    }
}
