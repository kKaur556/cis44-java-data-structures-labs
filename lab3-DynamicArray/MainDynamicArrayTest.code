import java.util.*;
public class MainDynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray<Integer> intArray = new DynamicArray<>();
        Random rand = new Random();
        
        //adding elements using add
        for(int i = 0; i < 5; i++)
        {
            intArray.add(rand.nextInt());
        }
        
        intArray.to_string();
        System.out.println("Array size: " + intArray.size());
        
        //getting an element at a certain index 
        System.out.println("Element at index 2: " + intArray.get(2));
        
        //removing an element
        intArray.remove(3);
        
        //adding 10 new elements
        for(int i = 0; i < 10; i++)
        {
            intArray.add(rand.nextInt());
        }
        
        //printing new array
        intArray.to_string();
        System.out.println("Array size: " + intArray.size());
        
    }
}
