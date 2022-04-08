package trees;

public class BalancedBinaryTree {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    
    static class NodeWithHeightBalance{
        Node node;
        int height;
        boolean isBalanced;

        public NodeWithHeightBalance(Node node, int height, boolean isBalanced) {
            this.node = node;
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public static boolean checkIfTreeIsBalanced(Node node){
        return checkIfTreeIsHtBalanced(node).isBalanced;
    }
    
    private static NodeWithHeightBalance checkIfTreeIsHtBalanced(Node node){
        if(node == null) return new NodeWithHeightBalance(null, -1, true);
        
        NodeWithHeightBalance leftNode = checkIfTreeIsHtBalanced(node.left);
        NodeWithHeightBalance rightNode = checkIfTreeIsHtBalanced(node.right);
        
        return new NodeWithHeightBalance(node, Math.max(leftNode.height, rightNode.height) + 1, 
                leftNode.isBalanced && rightNode.isBalanced && Math.abs(leftNode.height - rightNode.height) <= 1);
    }

    public static void main(String[] args) {
        /*Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(11);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.right.left = new Node(8);
        root.left.right.right.left.left = new Node(9);
        root.left.right.right.left.right = new Node(10);*/
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(checkIfTreeIsBalanced(root));
    }
}
