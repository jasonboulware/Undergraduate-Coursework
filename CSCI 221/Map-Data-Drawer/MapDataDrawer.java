import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * This class works with the DrawingPanel class to visualize the "best" possible walking paths of 
 * a set of topographic data using a greedy algorithm. 
 * 
 * Modified by Jason Boulware 
 * Due 3/29/17
 */

public class MapDataDrawer
{
    // store map data in grid array
    private int[][] grid; 

    // Read 2D array into grid. Data in file "filename", grid is rows x cols
    public MapDataDrawer(String filename, int rows, int cols) throws Exception{
        grid = new int[rows][cols]; 
        File file = new File(filename);//Creates a file object from the String location input from user
        Scanner in = new Scanner(file);//Scanner that reads the file

        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                grid[row][col] = in.nextInt();//Reads file into an array
            }
        }
    }

    /**
     * @return the min value in the entire grid
     */
    public int findMin(){
        int min = grid[0][0];

        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (grid[row][col] <= min){
                    min = grid[row][col];
                }
            }
        }

        return min ;  
    }

    /**
     * @return the max value in the entire grid
     */
    public int findMax(){
        int max = Integer.MIN_VALUE;

        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (grid[row][col] > max){
                    max = grid[row][col];
                }
            }
        }

        return max; 
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public  int indexOfMinRow(int col){
        int minIndex = 0;
        int lowest = Integer.MAX_VALUE;
        for (int row = 0; row < grid.length; row++){
            if (lowest > grid[row][0]){
                lowest = grid[row][0];
                minIndex = row;
            }
        }
        return minIndex;  
    }

    /**
     * DON'T CHANGE THIS CODE, except to uncomment it when you instantiate the grid
     * Draws the grid using the given Graphics object. 
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */

    // ******ALERT******
    // Note - until you instantiate a grid, through the constructor, this
    // method will generate a null pointer exception, since there is no grid.length
    // ********************
    public void drawMap(Graphics g){

        int minVal = findMin();
        int maxVal = findMax();
        double range = maxVal - minVal;

        for(int row=0; row < grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                int val = (int)(((grid[row][col]-minVal)/range) * 255);
                g.setColor(new Color(val,255-val,255-val));
                g.setColor(new Color(val,val,val));
                g.fillRect(col,row,1,1);
            }
        }      
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        int hi = 0;//holds change in elevation from current location in the array to grid[row -1][col + 1]
        int mid = 0;//holds change in elevation from current location in the array to grid[row][col + 1]
        int lo = 0;//holds change in elevation from current location in the array to grid[row + 1][col + 1]
        int totalChange = 0;//variable holding number for the total change in elevation for a given path
        int currY = row; // row in grid of step one
        // draw initial step - column 0, current row (sent in as parameter)
        g.fillRect(0,row,1,1);
        // Code to compute next step
        for (int col = 0; col < grid[currY].length - 1; col++){

            if (currY == 0){//Accounts for location being in top row
                lo = grid[currY][col] - grid[currY + 1][col + 1];
                mid = grid[currY][col] - grid[currY][col + 1];
                if(Math.abs(mid) <= Math.abs(lo)){//Paints grid[row][col + 1] and updates totalChange
                    g.fillRect(col + 1 ,currY,1,1);
                    totalChange = totalChange + Math.abs(mid);
                }
                else{//Paints grid[row + 1][col + 1], updates totalChange, and updates currY
                    g.fillRect(col + 1 ,currY + 1,1,1);
                    currY++;
                    totalChange = totalChange + Math.abs(lo);
                }
            }

            else if (currY == grid.length - 1){//Accounts for being in bottom row
                hi = grid[currY][col] - grid[currY - 1][col + 1];
                mid = grid[currY][col] - grid[currY][col + 1];
                if(Math.abs(mid) <= Math.abs(hi)){//Paints grid[row][col + 1] and updates totalChange
                    g.fillRect(col + 1 ,currY,1,1);
                    totalChange = totalChange + Math.abs(mid);
                }
                else{//Paints grid[row - 1][col + 1], updates totalChange, and updates currY
                    g.fillRect(col + 1 ,currY - 1,1,1);
                    totalChange = totalChange + Math.abs(hi);
                    currY--;
                }
            }

            else{//After verifying the location is not either the top or bottom row of the array
                lo = grid[currY][col] - grid[currY + 1][col + 1];
                hi = grid[currY][col] - grid[currY - 1][col + 1];
                mid = grid[currY][col] - grid[currY][col + 1];
                if (((Math.abs(mid)) < Math.abs(lo) && (Math.abs(mid) <= Math.abs(hi)))//If mid is lower than lo and lower than or equal to hi 
                || ((Math.abs(mid) < Math.abs(hi)) && (Math.abs(mid) <= Math.abs(lo)))){//if mid is lower than hi and lower than or equal to lo
                    g.fillRect(col + 1 ,currY,1,1);
                    totalChange = totalChange + Math.abs(mid);
                }
                else if((Math.abs(hi) < Math.abs(mid)) && (Math.abs(hi) < Math.abs(lo))){//Paints grid[row - 1][col + 1], updates totalChange, and updates currY
                    g.fillRect(col + 1 ,currY - 1,1,1);
                    totalChange = totalChange + Math.abs(hi);
                    currY--; 
                }
                else if ((Math.abs(lo) < Math.abs(mid)) && (Math.abs(lo) < Math.abs(hi))){//Paints grid[row + 1][col + 1], updates totalChange, and updates currY
                    g.fillRect(col + 1 ,currY + 1,1,1);
                    totalChange = totalChange + Math.abs(lo);
                    currY++;
                }
                else if ((Math.abs(lo) == Math.abs(hi))){//Assumes grid[row + 1][col + 1] and grid[row - 1][col + 1] are equal and lower than mid
                    Random rn = new Random();
                    if(rn.nextInt(2) == 0){//generates a random number. If number is 0, this will paint grid[row - 1][col + 1], updates totalChange, and updates currY
                        g.fillRect(col + 1 ,currY - 1,1,1); 
                        totalChange = totalChange + Math.abs(lo);
                        currY--;
                    }
                    else if(rn.nextInt(2) == 1){//generates a random number. If number is 1, this will paint grid[row + 1][col + 1], updates totalChange, and updates currY
                        g.fillRect(col + 1 ,currY + 1,1,1);
                        totalChange = totalChange + Math.abs(lo);
                        currY++;
                    }

                }
            }
        }
        return totalChange; // computed change in elevation
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        int lowest = Integer.MAX_VALUE;
        int index = 0;
        int elevation = 0;//holds data for the lowest change in elevation
        for (int row = 0; row < grid.length; row++){
            elevation = drawLowestElevPath(g, row);//calls method to draw path based on current row
            if (lowest > elevation){
                lowest = elevation;
                index = row;
            }
        }     
        return index; // row of path with lowest elevation
    }

}