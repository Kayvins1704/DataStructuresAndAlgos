package trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static void inorderTraversal(Node root){
        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.val + " ");
                curr = curr.right;
            }else{
                Node prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void preOrderTraversal(Node root){
        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.val + " ");
                curr = curr.right;
            }else{
                Node prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    System.out.print(curr.val + " ");
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.left.left = new Node(7);
        root.left.right.left.right = new Node(8);
        root.left.right.left.right.left = new Node(9);
        root.left.right.left.right.right = new Node(10);
        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.right.left = new Node(12);
        root.right.right.left.right = new Node(13);
        root.right.right.left.right.right = new Node(14);

        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        preOrderTraversal(root);
    }
}
