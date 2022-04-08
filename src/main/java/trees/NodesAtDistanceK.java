package trees;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistanceK {
    static class Node{
        int val;
        Node parent;
        Node left;
        Node right;
        
        public Node(int val){
            this.val = val;
        }
    }
    
    private static final List<Node> nodesAtDistK = new ArrayList<>();
    
    public static void nodesAtDistanceK(Node currNode, Node givenNode, int k){
        traverseTree(currNode, null);
        getNodesAtDistanceK(givenNode, givenNode, k);
        nodesAtDistK.forEach(node -> System.out.print(node.val + " "));
    }
    
    public static void traverseTree(Node currNode, Node prevNode){
        if(currNode == null) return;
        currNode.parent = prevNode;
        traverseTree(currNode.left, currNode);
        traverseTree(currNode.right, currNode);
    }
    
    public static void getNodesAtDistanceK(Node givenNode, Node currNode, int k){
        if(currNode == null) return;
        
        if(k == 0) {
            if(currNode != givenNode) nodesAtDistK.add(currNode);
            return;
        }
        
        getNodesAtDistanceK(givenNode, currNode.left, k-1);
        getNodesAtDistanceK(givenNode, currNode.right, k-1);
        getNodesAtDistanceK(givenNode, currNode.parent, k-1);
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

        nodesAtDistanceK(root, root.left.left, 2);
    }
}
