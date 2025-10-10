import java.util.*;
public class DynamicArray<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    
    public DynamicArray()
    {
        this.data = (T[]) new Object [INITIAL_CAPACITY];
        this.size = 0;
    }
    
    //Adds an element to the end of the list. If the 
    //internal arrayis full, this method must trigger 
    //a private resize() method before adding the 
    //new element.
    public void add(T element)
    {
        if (size == data.length) {
            resize();
        }
        
        data[size] = element;
        size++;

    }
    
    
    //Returns the element at the specified index. 
    //Throws an IndexOutOfBoundsException if the 
    //index is invalid.
    public T get(int index)
    {
        if(index < 0 || index >= size)//validating index
        {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds.");
        }

        return data[index];
    }
    
    //Removes the element at the specified index. All 
    //subsequent elements must be shifted to the left 
    //to fill the gap. Returns the removed element. 
    //Throws an IndexOutOfBoundsException if the 
    //index is invalid.
    public T remove(int index)
    {
        if(index < 0 || index >= size)//validating index
        {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds.");
        }
        
        T elementRemoved = data[index];
        
        //using for loop to remove
        for(int i = index; i < size-1; i++)
        {
            data[i] = data[i+1];
        }
        data[size] = null;
        
        return elementRemoved;
    }
    
    //Returns the number of elements in the list.
    public int size()
    {
        return this.size;
    }
    
    
    //resizes the array- double capacity
    private void resize()
    {
        data = Arrays.copyOf(data, INITIAL_CAPACITY * 2);
    }
    
    
    //to_string method- to print out the array
    public void to_string()
    {
        System.out.print("[");
        for(int i = 0; i < this.size()-1; i++){
            System.out.print(data[i] + " ");
        }
        System.out.print(data[this.size()-1] + "]");
        System.out.println();
    }
}
