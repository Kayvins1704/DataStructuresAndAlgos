package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversal {
    private static Map<Integer, List<Node>> mp = new HashMap<>();
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

    public static void traverseTreeAndPrint(Node node){
        traverseTree(node, 0);
        printTree();
    }

    private static void traverseTree(Node node, int level){
        if(node == null) return;

        if(!mp.containsKey(level)) mp.put(level, new ArrayList<>());
        mp.get(level).add(node);

        minLevel = Math.min(minLevel, level);
        maxLevel = Math.max(maxLevel, level);

        traverseTree(node.left, level-1);
        traverseTree(node.right, level+1);
    }

    private static void printTree(){
        for(int i=minLevel; i<=maxLevel; i++){
            mp.get(i).forEach(node -> System.out.print(node.val + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        traverseTreeAndPrint(root);
    }
}
