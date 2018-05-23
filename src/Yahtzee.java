package yahtzee;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kalbernaz
 */
public class Yahtzee {
    public static void main (String[] argv){
        Random rand = new Random();
        Scanner reader = new Scanner(System.in);
        Category yahtzeeCategory = new Category.checkForYahtzee();
        Category numOfAKindCategory = new Category.numOfAKind();

        boolean keepPlaying = true;
        boolean validation = true;
        
        int[] dieArray;
        dieArray = new int[5];
        
        String userInputKeepPlaying;
        
        while (keepPlaying == true){
            validation = true;
            //Possible Refactor: change entire for loop below into a method.
            for(int i = 1; i <= 13; i++){
                int dieNum = 1;
                System.out.println("\nRound " + i);
                
                for (int position = 0; position <= 4; position++){
                    
                    dieArray[position] = rand.nextInt(6) + 1;
                    System.out.println("Die #" + dieNum + " = " + dieArray[position]);
                    
                    dieNum++;
                }
                
                yahtzeeCategory(dieArray);
                numOfAKindCategory(dieArray);
                
                try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
            }
            
            while (validation == true){
                System.out.println("\nWould you like to play again? >> ");
                userInputKeepPlaying = reader.nextLine();

                //Possible Refactor: change entire if statement into a validation method
                if(userInputKeepPlaying.equalsIgnoreCase("y") || userInputKeepPlaying.equalsIgnoreCase("yes")){
                    keepPlaying = true;
                    validation = false;
                } else if (userInputKeepPlaying.equalsIgnoreCase("n") || userInputKeepPlaying.equalsIgnoreCase("no")){
                    keepPlaying = false;
                    validation = false;
                    System.out.println("\nThank your for playing!");
                } else {
                    System.out.println("\nThat is not a valid entry. Please try again.");
                }
            }
        }
    }// main
}// class Yahtzee
