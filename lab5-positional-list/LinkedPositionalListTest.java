import java.util.*;
public class LinkedPositionalListTest {

    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();
        
        //adding items
        Position<String> first = itinerary.addFirst("First in Paris.");
        itinerary.addLast("Last at home.");
        itinerary.addAfter(first, "Visit art galleries.");
        itinerary.addBefore(first, "Watch a fashion show.");
        
        //printing the itinerary
        System.out.println("Original: ");
        for(String eachStop : itinerary)
        {
            System.out.println(eachStop);
        }
        System.out.println();
        
        // Use an explicit iterator to remove an item
        System.out.println("Removing 'Watch a fashion show'.");
        Iterator<String> iter = itinerary.iterator();
        while(iter.hasNext()) {
            String stop = iter.next();
            if (stop.equals("Watch a fashion show")) {
                iter.remove();
                break;
            }
        }
        System.out.println();

        
        System.out.println("Final Itinerary: ");
        for (String eachStop : itinerary) 
            System.out.println(eachStop);
        
    }   
}
