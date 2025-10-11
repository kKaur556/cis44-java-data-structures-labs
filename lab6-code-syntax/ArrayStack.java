public class ArrayStack<E> implements Stack<E> {
    private E[] elements;
    private int top;
    
    public ArrayStack(int capacity)
    {
        elements = (E[]) new Object[capacity];
        top = -1;
    }
    
    @Override
    public void push(E item)
    {
        if(top == elements.length-1) throw new IllegalStateException("Stack is full.");
        elements[++top] = item;
    }
    
    @Override
    public E pop()
    {
        if(isEmpty()) throw new java.util.EmptyStackException();
        E item = elements[top];
        elements[top--] = null;
        return item;
    }
    
    @Override
    public E peek()
    {
        if(isEmpty()) throw new java.util.EmptyStackException();
        return elements[top];
    }
    
    @Override
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    @Override
    public int size()
    {
        return top+1;
    }
}
