import java.util.ArrayList;
class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // Helper methods
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
    
    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    public K removeMin() {
        if (isEmpty()) return null;
        K answer = heap.get(0);
        // Move last element to root
        K last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    private void upheap(int j) {
        // TODO: While j > 0 and parent > child, swap and move up
        while(j > 0)
        {
            int p = parent(j);
            if(heap.get(j).compareTo(heap.get(p)) < 0)
            {
                swap(j,p);
                j = p; //move up to the parent's index
            }else break; //property satisfied
        }
    }

    private void downheap(int j) {
        // TODO: While j has left child...
        // Find smaller child, swap if child < parent, move down
        while( left(j) < heap.size())
        {
            int leftIndex = left(j);
            int smallChild = leftIndex;
            
            //check if has right child and is smaller
            if(right(j) < heap.size())
            {
                int rightIndex = right(j);
                if(heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) 
                    smallChild = rightIndex;
                
            }
            
            //if smaller child less than current parent, move down
            if(heap.get(smallChild).compareTo(heap.get(j)) < 0)
            {
                swap(j, smallChild);
                j = smallChild;
            }else break;//property statisfied
            
        }
    }
}
