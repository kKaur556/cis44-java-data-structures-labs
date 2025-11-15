public class AVLTreeDriver {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);//triggers left rotation
        // TODO: Add more insertions to test all 4 rotation cases
        tree.insert(5);
        tree.insert(4);//triggers right rotation
        tree.insert(8);//triggers left-right rotation
        tree.insert(25);//triggers right-left rotation

        
        
        // TODO: Print traversals
        //expected inorder 1
        System.out.print("Inorder: ");
        tree.inorder();       
        
        //expected inorder 2
        System.out.print("Preorder: ");
        tree.preorder();
        
        //expected inorder 3
        System.out.print("Postorder: ");
        tree.postorder();
        

        // TODO: Add expected results as comments for verification
        /*
        Expected inorder 1: 4 5 8 10 20 25 30
        Expected inorder 2: 10 5 4 8 20 25 30
        Expected inorder 3: 4 8 5 25 30 20 10
        */
    }
}
