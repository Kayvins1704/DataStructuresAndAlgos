package trees;

public class SymmetricalBinaryTree {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    
    public static boolean checkIfSymmetric(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null && root1.val == root2.val)
            return checkIfSymmetric(root1.left, root2.right) && checkIfSymmetric(root1.right, root2.left);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(3);
        root.right.right = new Node(4);

        System.out.println(checkIfSymmetric(root.left, root.right));
    }
}
