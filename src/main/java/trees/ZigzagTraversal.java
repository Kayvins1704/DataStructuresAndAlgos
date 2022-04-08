package trees;

import java.util.Stack;

public class ZigzagTraversal {
    private static int level = 0;
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public static void zigzagTraversal(Node node){
        Stack<Node> st1 = new Stack<>();
        st1.push(node);
        while(!st1.isEmpty()){
            Stack<Node> st2 = new Stack<>();
            while(!st1.isEmpty()){
                Node peekNode = st1.pop();
                System.out.print(peekNode.val + " ");
                if(level%2 == 0){
                    if(peekNode.left != null) st2.push(peekNode.left);
                    if(peekNode.right != null) st2.push(peekNode.right);
                }else{
                    if(peekNode.right != null) st2.push(peekNode.right);
                    if(peekNode.left != null) st2.push(peekNode.left);
                }
            }
            st1 = st2;
            level++;
            System.out.println();
        }
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

        zigzagTraversal(root);
    }
}
