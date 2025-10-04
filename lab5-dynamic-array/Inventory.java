import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 

public class Inventory { 
     private List<Item> items; 
     
     public Inventory() { 
         this.items = new ArrayList<>(); 
     } 
     
     //Adds an item to the inventory.
     public void addItem(Item item) 
     {
         items.add(item);
     } 

     
     //Prints all items in the inventory
     public void display() 
     {
         if(items.isEmpty()) System.out.print("Inventory is empty.");
         else
         {
            System.out.print("{");
            for(int i = 0; i < items.size()-1; i++)
            {
                System.out.print(items.get(i) + " ");
            }
            System.out.print(items.get(items.size()-1) + "}");
         }
     } 

     
     /*This is the core method. It must use an Iterator to search 
       the list for items with names matching name1 and name2. 
       If both are found, they must be removed using the 
       iterator.remove() method, and a new combined item 
       e.g., "Magic Staff") is added to the inventory.
     */
     public void combineItems(String name1, String name2) { 
           boolean found1 = false; 
           boolean found2 = false; 

           Iterator<Item> iter = items.iterator(); 
           
           while (iter.hasNext()) 
           { 
                 Item current = iter.next(); 
                 if (current.getName().equals(name1) && !found1) 
                 { 
                     found1 = true;
                     iter.remove(); 
                     continue;//moves to next iteration
                 } 
                 
                 if (current.getName().equals(name2) && !found2) 
                 { 
                     found2 = true;
                     iter.remove();
                     continue;//moves to next iteration
                 } 
                 
                // If both items have been found and removed, we can stop the loop
                if (found1 && found2) 
                {
                    break;
                }
             } 

             // After the loop, check if both were found. 
             // If so, add the new combined item. 
             if(found1 && found2)
             {
                 addItem(new Item("Magic Stuff"));
                 System.out.println("Combined '" + name1 + "' and '" + name2);
             }else
             {
                 System.out.println("Items not combined. One or more items not found.");
             }
             
             
             // What happens if you add the new item inside the loop? 
             //ConcurrentModificaitonException is thrown because 
             //modifying the list while iterator is still active
        } 
}
 
