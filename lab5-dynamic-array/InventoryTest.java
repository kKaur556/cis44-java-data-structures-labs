public class InventoryTest {

    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        
        System.out.println("Adding items..");
        myInventory.addItem(new Item("Tape"));
        myInventory.addItem(new Item("Water"));
        myInventory.addItem(new Item("Chocolate"));
        
        //displaying initial items 
        myInventory.display();
        System.out.println();
        
        //combining two items in the list
        myInventory.combineItems("Tape", "Water");
        
        //displaying final items 
        myInventory.display();
        System.out.println();
        
        //combining two items not in the list
        myInventory.combineItems("Tape", "Glue");
        
        
    }
}
