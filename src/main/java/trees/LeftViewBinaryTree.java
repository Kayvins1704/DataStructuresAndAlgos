package trees;

import java.util.HashSet;
import java.util.Set;

public class LeftViewBinaryTree {
    private static final Set<Integer> levelSet = new HashSet<>();
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    
    public static void leftView(Node root, int level){
        if(root == null) return;
        if(levelSet.add(level)) System.out.println(root.val);
        leftView(root.left, level+1);
        leftView(root.right, level+1);
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

        leftView(root, 0);
    }
}
