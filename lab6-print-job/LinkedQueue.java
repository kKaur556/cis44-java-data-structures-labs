import java.util.*;
public class LinkedQueue<E> implements Queue<E>{
    private static class Node<E>{
        E item;
        Node<E> next;
        
        Node(E item){
            this.item = item;
            this.next = null;
        }        
    }
    
    private Node<E> front;
    private Node<E> rear;
    
    public LinkedQueue(){
        this.front = null;
        this.rear = null;
    }
    
    @Override
    public void enqueue(E item)
    {
        Node<E> newNode = new Node<>(item);
        
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else
        {
            rear.next = newNode;
            rear = newNode;
        }
        
    }
    
    @Override
    public E dequeue()
    {
        if(isEmpty()) throw new EmptyStackException();
        
        E item = front.item;
        front = front.next;
        
        if(front == null) rear = null;
        return item;
    }
    
    
    @Override
    public boolean isEmpty()
    {
        return front == null;
    }
}
