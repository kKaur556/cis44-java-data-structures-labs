public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }
        
        // 2. Insert key in leaf
        node.insertKey(key);
       
        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        // 2. Promote middle key to parent
        // 3. Move keys and children appropriately
        // 4. Update parent pointers
        System.out.println("Splitting node with keys: " + node.keys);
        
        Integer midKey = node.keys.get(1);
        
        //create new right node
        TwoFourNode rightNode = new TwoFourNode();
        rightNode.insertKey(node.keys.remove(2));
        rightNode.insertKey(node.keys.remove(2));
        
        node.keys.remove(1);
        
        if(!node.isLeaf())
        {
            rightNode.children.add(node.children.remove(2));
            rightNode.children.add(node.children.remove(2));
            rightNode.children.add(node.children.remove(2));
            
            //updating parent pointers
            for(TwoFourNode child : rightNode.children) child.parent = rightNode;
            
        }
        
        TwoFourNode parentNode;
        if(node.parent == null)
        {
            parentNode = new TwoFourNode();
            parentNode.children.add(node);
            this.root = parentNode;
        }else parentNode = node.parent;
        
        parentNode.insertKey(midKey);
        
        int insIndex = parentNode.keys.indexOf(midKey) + 1;
        parentNode.children.add(insIndex, rightNode);
        
        //updating parent pointers
        node.parent = parentNode;
        rightNode.parent = parentNode;
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}
