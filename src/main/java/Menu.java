import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Menu {
    // this class controls the backend of the menu
    /* should have functions that do:
        shows scores
     */

    // we need to agree to a path to store the file for saving

    public static String[] getScores() throws FileNotFoundException // should be triggered after highscore screen open is clicked
    {
        Scanner scan = new Scanner(new File("users.csv")); // goes to the path to find the file
        
        int index = 0;
        String line;
        String[] scores = new String[7];
        while(index < 7){
            line = scan.next();  // reads the line
            scores[index] = line.split(",")[3]; // extracts the highscore and adds to array
            index += 1;
        }
        
        return scores;
    }
}
