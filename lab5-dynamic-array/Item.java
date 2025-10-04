public class Item { 
    String name; 
    // Constructor, getter, toString... 
    public Item(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
}
