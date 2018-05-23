/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

/**
 *
 * @author moonp
 */
public class Category {

    /*
    TODO:
    1. Determines which categories have not been used yet.
    2. Determine eligibility of category according to dice rolled.
    3. Mark categories as either used or not used.
    */
    
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
        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>(); 
        
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
            }
            /*
            // Testing
            System.out.println(mapEntry.getKey() + ": " );
            System.out.print(mapEntry.getValue());
            */
        }
        
        // Testing
        //System.out.println("\nDie Array: " + Arrays.toString(dieArray));
        //System.out.println("Element Count: " + elementCountMap);
        
    }// numOfAKind
}
