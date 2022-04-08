package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    
    public static void levelOrderTraversal(Node start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            System.out.print(n.val + " ");
            if(n.left != null) queue.add(n.left);
            if(n.right != null) queue.add(n.right);
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
        
        levelOrderTraversal(root);
    }
}
