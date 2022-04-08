package trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    private static final List<Integer> path = new ArrayList<>();
    private static boolean pathFound = false;
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    
    public static void rootToNodePath(Node root, Node givenNode){
        if(root == null || pathFound) return;
        path.add(root.val);
        if(root.equals(givenNode)) {
            pathFound = true;
            return;
        }
        rootToNodePath(root.left, givenNode);
        rootToNodePath(root.right, givenNode);
        if(!pathFound) path.remove(path.size() - 1);
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

        rootToNodePath(root, root.left.right.right.left.right);

        path.forEach(System.out::println);
    }
}
