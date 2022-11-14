import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Menu {
    // this class controls the backend of the menu
    /* should have functions that do:
        shows scores
        start a game master..?
     */

    // we need to agree to a path to store the file for saving
    private static String path;

    public static String[] getScores() throws FileNotFoundException // should be triggered after highscore screen open is clicked
    {
        Scanner scan = new Scanner(new File("users")); // goes to the path to find the file
        scan.useDelimiter(",");
        int index = 0;
        String line;
        String[] scores = new String[7];
        while(index <= 7){
            line = scan.next();  // reads the line
            scores[index] = line.split(",")[4]; // extracts the highscore and adds to array
            index += 1;
        }

        scan.close();
        return scores;
    }

    // store highscore (based on the score) (maybe move this to another class later if its easier
    public static void updateScore(User player, int updated){
        User.score = updated;
    }
}
