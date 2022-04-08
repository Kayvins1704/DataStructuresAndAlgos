package trees;

import java.util.Stack;

public class PostorderTraversalWithoutRecur {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    public static void postorderTraversalWithoutRecur(Node start){
        Node cur = start;
        Node temp = null;
        Stack<Node> st = new Stack<>();

        while(cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }else{
                temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    System.out.print(temp.val + " ");
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.val + " ");
                    }
                }else{
                    cur = temp;
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

        postorderTraversalWithoutRecur(root);
    }
}
