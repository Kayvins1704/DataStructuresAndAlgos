package trees;

import java.util.Stack;

public class FlattenToLinkedList {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static Node prev = null;

    private static final Stack<Node> st = new Stack<>();

    public static void flattenWithoutRecursion(Node root){
        Node curr = root;

        while(curr != null){
            if(curr.left != null){
                Node next = curr.left;

                while(next.right != null){
                    next = next.right;
                }

                next.right = curr.right;
                curr.right = curr.left;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    public static void flattenWithRecursion(Node root){
        if(root == null) return;
        flattenWithRecursion(root.right);
        flattenWithRecursion(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flattenWithoutRecursionUsingStack(Node root){
        st.push(root);

        while(!st.isEmpty()){
            Node curr = st.pop();
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
            if(!st.isEmpty()) curr.right = st.peek();
            curr.left = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        //flattenWithoutRecursion(root);
        //flattenWithRecursion(root);
        flattenWithoutRecursionUsingStack(root);

        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
