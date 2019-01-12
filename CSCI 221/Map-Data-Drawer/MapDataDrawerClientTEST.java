import java.util.Random;
/**
 * Write a description of class DrawingPanelTestClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapDataDrawerClientTEST{
    public static void main(String[]args){
        Random rn = new Random();
        
        for (int i = 0; i < 99; i++){
            System.out.println(rn.nextInt(2));
        }
    }
}
