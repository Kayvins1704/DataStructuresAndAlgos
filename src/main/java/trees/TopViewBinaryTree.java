package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewBinaryTree {
    private static final Map<Integer, Integer> topViewMap = new HashMap<>();
    private static int minLevel = Integer.MAX_VALUE;
    private static int maxLevel = Integer.MIN_VALUE;
    static class Node{
        int val;
        Node left;
        Node right;
        
        public Node(int val){
            this.val = val;
        }
    }
    
    static class EnhancedNode{
        Node node;
        int topViewLevel;
        public EnhancedNode(Node node, int topViewLevel){
            this.node = node;
            this.topViewLevel = topViewLevel;
        }
    }
    
    public static void topViewTraversal(Node root){
        Queue<EnhancedNode> q = new LinkedList<>();
        q.add(new EnhancedNode(root, 0));
        while(!q.isEmpty()){
            EnhancedNode enhancedNode = q.remove();
            if(!topViewMap.containsKey(enhancedNode.topViewLevel)) {
                topViewMap.put(enhancedNode.topViewLevel, enhancedNode.node.val);
                minLevel = Math.min(minLevel, enhancedNode.topViewLevel);
                maxLevel = Math.max(maxLevel, enhancedNode.topViewLevel);
            }
            if(enhancedNode.node.left != null) q.add(new EnhancedNode(enhancedNode.node.left, enhancedNode.topViewLevel - 1));
            if(enhancedNode.node.right != null) q.add(new EnhancedNode(enhancedNode.node.right, enhancedNode.topViewLevel + 1));
        }
        
        for(int i=minLevel; i<=maxLevel; i++){
            System.out.print(topViewMap.get(i) + " ");
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

        topViewTraversal(root);
    }
}
