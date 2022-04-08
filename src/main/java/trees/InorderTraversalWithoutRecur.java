package trees;

import java.util.Stack;

public class InorderTraversalWithoutRecur {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public static void inorderTraversalWithoutRecur(Node start){
        Stack<Node> st = new Stack<>();
        Node n = start;

        while(n != null){
            st.push(n);
            n = n.left;
        }

        while(!st.isEmpty()){
            n = st.pop();
            System.out.print(n.val + " ");

            if(n.right != null) {
                n = n.right;
                while(n != null){
                    st.push(n);
                    n = n.left;
                }
            }
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

        inorderTraversalWithoutRecur(root);
    }
}
