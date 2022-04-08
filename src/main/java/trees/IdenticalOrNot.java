package trees;

public class IdenticalOrNot {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static boolean identicalOrNot(Node root1, Node root2){
        return (root1 == null && root2 == null) || (root1 != null && root2 != null 
                && root1.val == root2.val && identicalOrNot(root1.left, root2.left) 
                && identicalOrNot(root1.right, root2.right));
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

        Node root1 = new Node(-10);
        root1.left = new Node(9);
        root1.right = new Node(-20);
        root1.right.left = new Node(-15);
        root1.right.left.right = new Node(-100);
        root1.right.right = new Node(7);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.left.right = new Node(11);
        root2.left.right = new Node(5);
        root2.left.right.left = new Node(6);
        root2.left.right.right = new Node(7);
        root2.left.right.right.left = new Node(8);
        root2.left.right.right.left.left = new Node(9);
        root2.left.right.right.left.right = new Node(10);

        System.out.println(identicalOrNot(root1, root2));
    }
}
