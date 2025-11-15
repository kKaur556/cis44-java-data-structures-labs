public class AVLTree {
    AVLNode root;
     // TODO: Return height of a node
    int height(AVLNode N) {
        if(N == null) return 0;
        return N.height;
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        
        //performing rotation
        x.right = y;
        y.left = T2;
        
        //height update
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        
        return x; //new root
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        
        //performing rotation
        y.left = x;
        x.right = T2;
        
        //height update
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        
        return y; //new root
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        if(node == null) return new AVLNode(key);
        
        if(key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node;//no duplicate
        
        //height update
        node.height = 1 + max(height(node.left), height(node.right));
        
        //balance factor for imbalance
        int balance = getBalance(node);
        
        //unbalanced- perform rotations
        //Left Left Case
        if(balance > 1 && key < node.left.key) return rightRotate(node);
        
        //right right case
        if(balance < -1 && key > node.right.key) return leftRotate(node);
        
        //left right case
        if(balance > 1 && key > node.left.key) return leftRightRotate(node);
        
        //right left case
        if(balance < -1 && key < node.right.key) return rightLeftRotate(node);
        
        return node;//returning node pointer(rotated or unchanged)
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if(node!= null)
        {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
            
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if(node!= null)
        {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
            
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if(node!= null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}
