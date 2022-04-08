package trees;

import java.util.*;

public class BoundaryTraversal {
    private static final Stack<Node> st = new Stack<>();
    private static final Queue<Node> q = new LinkedList<>();
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    public static void boundaryTraversal(Node root){
        leftTraversal(root);
        inorderTraversal(root);
        if(root.right != null) rightTraversal(root.right);

        while(!st.isEmpty()) q.add(st.pop());

        q.forEach(node -> System.out.print(node.val + " "));
    }

    private static void inorderTraversal(Node node){
        if(node == null) return;

        if(node.left == null && node.right == null) q.add(node);

        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    private static void leftTraversal(Node node){
        if(node.left != null || node.right != null) q.add(node);
        if(node.left != null) leftTraversal(node.left);
        else if(node.right != null) leftTraversal(node.right);
    }

    private static void rightTraversal(Node node){
        if(node.left != null || node.right != null) st.push(node);
        if(node.right != null) rightTraversal(node.right);
        else if(node.left != null) rightTraversal(node.left);
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

        boundaryTraversal(root);
    }
}
