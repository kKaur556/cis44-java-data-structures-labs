class AVLNode {
    int key, height;
    AVLNode left, right;
    
    //constructor
    AVLNode(int key)
    {
        this.key = key;
        height = 1;
        left = null;
        right = null;
    }
}
