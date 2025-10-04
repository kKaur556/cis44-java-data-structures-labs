import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedPositionalList <E> implements Iterable<E>{
    
    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        // ... element, prev, next pointers and methods ...
        
        private E element;
        private Node<E> prev;
        private Node<E> next;
        
        public Node(E element, Node<E> prev, Node<E> next)
        {
            this.element = element;
            this.prev = prev;
            this.next = next;
            
        }
        
        @Override
        public E getElement()
        {
            return element;
        }
                
    }
    
    private Node header;
    private Node trailer;
    private int size = 0;

    public LinkedPositionalList() {
        // ... constructor to create sentinel nodes ...
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,null,null);
        header.next = trailer;
    }
    
    // ... Implement all the Positional List methods ...
    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) 
            throw new IllegalArgumentException("Invalid position");
        
        Node<E> node = (Node<E>) p;
        if (node.next == null) 
            throw new IllegalArgumentException("Position is no longer in the list");
        
        return node;
    }
    
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        }
        return node;
    }
    
    
    //get methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.next);
    }

    public Position<E> last() {
        return position(trailer.prev);
    }
    
    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.prev);
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.next);
    }
    
    //set methods

    public Position<E> addFirst(E e) {
        Node<E> newNode = new Node<>(e, header, header.next);
        header.next.prev = newNode;
        header.next = newNode;
        size++;
        return newNode;
    }

    public Position<E> addLast(E e) {
        Node<E> newNode = new Node<>(e, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
        return newNode;
    }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        Node<E> prevNode = node.prev;
        Node<E> newNode = new Node<>(e, prevNode, node);
        prevNode.next = newNode;
        node.prev = newNode;
        size++;
        return newNode;
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        Node<E> nextNode = node.next;
        Node<E> newNode = new Node<>(e, node, nextNode);
        node.next = newNode;
        nextNode.prev = newNode;
        size++;
        return newNode;
    }

    //set(p,e) method
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E oldElement = node.element;
        
        node.element = e;
        
        return oldElement;
    }

    //remove
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        size--;
        
        E oldElement = node.element;
        
        node.next = null; // Mark as removed
        node.prev = null;
        node.element = null;
        
        return oldElement;
    }
    
    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator {
        Position<E> cursor = first(); // Start at the first element
        Position<E> recent = null;
        
        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        
        @Override
        public E next() {
            // Store the element at the current cursor
            // Advance the cursor to the next position using after()
            // Return the stored element
            if (cursor == null) throw new NoSuchElementException("No next element.");
            
            recent = cursor;
            cursor = after(cursor);
            return recent.getElement();
        }
        
        @Override
        public void remove()
        {
            if(recent == null) throw new IllegalStateException("remove() not yet called.");
            
            LinkedPositionalList.this.remove(recent);
            recent = null;
            
        }
    }
    
    @Override
    public Iterator iterator() {
        return new ElementIterator();
    }
}
