interface Queue<E>{
    void enqueue(E item);
    E dequeue();
    boolean isEmpty();
}
 
