import java.util.ArrayList;

class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();
    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    
    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }
    
    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i); 
            return oldValue;
        }
        return null;
    }
    
    // TODO: Complete this method (O(n))
    @Override
    public V put(K key, V value) {
        // 1. Search for existing key.
         int index = findEntryIndex(key);
        
        // 2. If found, update the value and return the old value.
        if(index != -1) return list.get(index).setValue(value);
        
        // 3. If not found, add a new entry and return null.
        list.add(new Entry<>(key,value));
        return null;
        
    }
    
    //implmenting sample output
    public static void main(String[] args){
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();
        
        System.out.println("Put 'A': " + map.put(5, "A")); //expected: null
        System.out.println("Put 'B': " + map.put(7, "B")); //expected: null
        System.out.println("Put 'C': " + map.put(2, "C")); //expected: null
        System.out.println("Put 'E': " + map.put(2, "E")); //expected: C
        System.out.println("Get 7: " + map.get(7)); //expected: B
        System.out.println("Remove 5: " + map.remove(5)); //expected: A
    }
}
