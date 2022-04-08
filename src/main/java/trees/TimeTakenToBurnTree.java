package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TimeTakenToBurnTree {
    static class Node{
        int val;
        Node parent;
        Node left;
        Node right;
        Node prevNode;

        public Node(int val){
            this.val = val;
        }
    }
    
    private static void traverseTree(Node currNode, Node prevNode){
        if(currNode == null) return;
        currNode.parent = prevNode;
        traverseTree(currNode.left, currNode);
        traverseTree(currNode.right, currNode);
    }
    
    public static int timeTakenToBurn(Node givenNode, Node root){
        traverseTree(root, null);
        
        int time = 0;
        Queue<Node> q = new LinkedList<>();
        if(givenNode.left != null) {
            givenNode.left.prevNode = givenNode;
            q.add(givenNode.left);
        }
        if(givenNode.right != null) {
            givenNode.right.prevNode = givenNode;
            q.add(givenNode.right);
        }
        if(givenNode.parent != null) {
            givenNode.parent.prevNode = givenNode;
            q.add(givenNode.parent);
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node iterNode = q.remove();
                if(iterNode.left != null && iterNode.left != iterNode.prevNode) {
                    iterNode.left.prevNode = iterNode;
                    q.add(iterNode.left);
                }
                if(iterNode.right != null && iterNode.right != iterNode.prevNode) {
                    iterNode.right.prevNode = iterNode;
                    q.add(iterNode.right);
                }
                if(iterNode.parent != null && iterNode.parent != iterNode.prevNode){
                    iterNode.parent.prevNode = iterNode;
                    q.add(iterNode.parent);
                }
            }
            time++;
        }
        
        return time;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(8);
        root.right.right = new Node(9);

        System.out.println(timeTakenToBurn(root.right.left, root));
    }
}
