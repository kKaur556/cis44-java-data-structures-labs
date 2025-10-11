public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;
        // Node constructor
        public Node(String textState, Node prev, Node next)
        {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        // Create a new node with the updated text.
        // Set its 'prev' to the current node.
        String text = this.currentNode.textState + newText;
        Node newNode = new Node(text, currentNode, null);
        
        // Set the current node's 'next' to this new node.
        // Finally, update currentNode to point to the new node.
        this.currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        // Check if currentNode.prev is not null.
        // If it is, move currentNode back and return the text.
        // Otherwise, you can't undo.
        if(currentNode.prev != null) this.currentNode = this.currentNode.prev;
        return this.currentNode.textState;
    }
    
    public String redo() {
        // Check if currentNode.next is not null.
        // If it is, move currentNode forward and return the text.
        if(currentNode.next != null) this.currentNode = this.currentNode.next;
        return this.currentNode.textState;
    }
    
    public void printCurrent() {
        System.out.println("Current Text: " + currentNode.textState);
    }
}
