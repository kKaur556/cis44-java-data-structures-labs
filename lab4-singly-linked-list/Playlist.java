public class Playlist {
    //nested node class
    private static class Node {
        Song song;
        Node next;
        //Node Constructor
        public Node(Song song){
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }
    
    //Adds a song to the end of the playlist.
    public void addSong(Song song) {
        Node newNode = new Node(song);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            currentNode = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    //Removes the first occurrence of a song with the given title.
    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.
        if(head == null) System.out.println("The playlist is empty.");
        
        //removing head
        if(head.song.getTitle().equals(title))
        {
            head = head.next;
            if(head == null){
                tail = null;
                currentNode = null;
            }else if(currentNode.song.getTitle().equals(title))
            {
                currentNode = head;
            }
            
            System.out.println("Removed: " + title);
            size--;
        }
        else
        {
            Node previous = head;
            Node temp = head.next;
            while(temp != null)
            {
                if (temp.song.getTitle().equals(title))
                {
                    previous.next = temp.next;
                    if(temp == tail) tail = previous;
         
                    if(temp == currentNode) currentNode = (temp.next != null) ? temp.next : head;
                
                }
                previous = temp;
                temp = temp.next;
            }
            System.out.println("Removed: " + title);
            size--;
        }
        
    }
    
    //"Plays" the current song (prints its details) and advances to the
    //next song. This should wrap around to the beginning if the end 
    //is reached (like a circular playlist).
    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.
        if(currentNode == null) System.out.println("The playlist is empty.");
        else
        {
            System.out.println("Now playing: " + currentNode.song);
            currentNode = (currentNode.next != null) ? currentNode.next : head;
        }
        
    }
    
    //Prints all the songs currently in the playlist.
    public void displayPlaylist() {
        // Traverse from the head and print each song.
        if(head == null) System.out.println("The playlist is empty.");
        
        Node temp = head;
        int count = 1;
        while(temp != null)
        {
            System.out.println(count + ". " + temp.song);
            temp = temp.next;
            count++;
        }
    }
}
