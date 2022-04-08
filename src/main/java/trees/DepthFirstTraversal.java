package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    static class NodeNum{
        Node node;
        int num;
        public NodeNum(Node node, int num){
            this.node = node;
            this.num = num;
        }
    }

    public static void inorderTraversal(Node node){
        if(node != null){
            inorderTraversal(node.left);
            System.out.print(node.data+" ");
            inorderTraversal(node.right);
        }
    }

    public static void preorderTraversal(Node node){
        if(node != null){
            System.out.print(node.data+" ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public static void inOneGo(Node node){
        Stack<NodeNum> st = new Stack<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        NodeNum nodeNum = new NodeNum(node, 1);
        st.push(nodeNum);

        while(!st.isEmpty()){
            if(st.peek().num == 1) {
                preorder.add(st.peek().node.data);
                st.peek().num = 2;
                if(st.peek().node.left != null) st.push(new NodeNum(st.peek().node.left, 1));
            }
            if(st.peek().num == 2) {
                inorder.add(st.peek().node.data);
                st.peek().num = 3;
                if(st.peek().node.right != null)st.push(new NodeNum(st.peek().node.right, 1));
            }
            if(st.peek().num == 3){
                postorder.add(st.peek().node.data);
                st.pop();
            }
        }

        System.out.print("Inorder Traversal : ");
        for(Integer val : inorder) System.out.print(val + " ");
        System.out.println();

        System.out.print("Preorder Traversal : ");
        for(Integer val : preorder) System.out.print(val + " ");
        System.out.println();

        System.out.print("Postorder Traversal : ");
        for(Integer val : postorder) System.out.print(val + " ");
        System.out.println();
    }

    public static void postorderTraversal(Node node){
        if(node != null){
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data+" ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
        System.out.println();
        inOneGo(root);
    }
}
