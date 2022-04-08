package trees;

public class DiameterOfTree {
    private static int diamOfTree = 0;
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    
    public static int calculateDiameterOfTree(Node node){
        if(node == null) return -1;
        
        int leftHeight = calculateDiameterOfTree(node.left);
        int rightHeight = calculateDiameterOfTree(node.right);
        
        diamOfTree = Math.max(diamOfTree, leftHeight + rightHeight + 2);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(11);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.right.left = new Node(8);
        root.left.right.right.left.left = new Node(9);
        root.left.right.right.left.right = new Node(10);

        calculateDiameterOfTree(root);

        System.out.println(diamOfTree);
    }
}
