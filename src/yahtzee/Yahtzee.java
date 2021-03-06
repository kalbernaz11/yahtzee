package yahtzee;

import java.util.Random;
import java.util.Scanner;
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
        
        boolean keepPlaying = true;
        boolean validation;
        
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
                
                checkForYahtzee(dieArray);
                numOfAKind(dieArray);
                
                // Used for testing purposes...
                //try {
                //        Thread.sleep(1000);
                //    } catch (InterruptedException ex) {
                //        Thread.currentThread().interrupt();
                //    }
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
                    System.out.println("\nThank you for playing!");
                } else {
                    System.out.println("\nThat is not a valid entry. Please try again.");
                }
            }
        }
    }// main
    
    public static void /*boolean*/ checkForYahtzee (int [] dieArray){
        boolean yahtzee = true;
        
        for (int i = 0; i < dieArray.length; i++){
            for (int k = i + 1; k < dieArray.length; k++){
                if (dieArray[i] != dieArray[k]){
                    yahtzee = false;
                }
            }
        }
        
        if (yahtzee == true){
            System.out.println("\nYahtzee!");
        }
        
        //return yahtzee;
    }// checkForYahtzee
    
    // NOTE: Could delete yahtzee method and merge it into below method, since 
    // HashMap can check for a value of 5.
    public static void /*boolean*/ numOfAKind(int [] dieArray){
        
        int twoOfAKind = 2;
        int threeOfAKind = 3;
        int fourOfAKind = 4;
        HashMap<Integer, Integer> elementCountMap = new HashMap<>(); 
        
        // Check every element in dieArray.
        for (int position: dieArray){
            // If element is in elementCountMap, increase count by 1.
            if (elementCountMap.containsKey(position)){
                elementCountMap.put(position, elementCountMap.get(position) + 1);
            // If element is not in elementCountMap, 
            // add to elementCountMap with a value of 1.
            } else {
                elementCountMap.put(position, 1);
            }
        }
        
        // Get a set of entries
        Set set = elementCountMap.entrySet();
        
        // Get an iterator
        Iterator iterator = set.iterator();
        
        while (iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            
            if (mapEntry.getValue().equals(threeOfAKind)){
                System.out.println("\nThree of a Kind!");
            } else if (mapEntry.getValue().equals(fourOfAKind)){
                System.out.println("\nFour of a Kind!");
            } else if (mapEntry.getValue().equals(threeOfAKind)
                    && mapEntry.getValue().equals(twoOfAKind)){
                System.out.println("\nFull House!");
            }
        }
        
    }// numOfAKind
    
}// class Yahtzee
