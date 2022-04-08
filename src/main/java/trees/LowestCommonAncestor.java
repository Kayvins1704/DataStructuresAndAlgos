package trees;

public class LowestCommonAncestor {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static Node lcaNode;

    public static boolean checkIfLca(Node currNode, Node node1, Node node2){
        if(lcaNode != null) return true;
        if(currNode == null) return false;

        boolean nodeFound = currNode == node1 || currNode == node2;

        boolean left = checkIfLca(currNode.left, node1, node2);
        boolean right = checkIfLca(currNode.right, node1, node2);

        if((nodeFound && (left || right)) || (left & right) && lcaNode == null) {
            System.out.println(currNode.val);
            lcaNode = currNode;
        }

        return nodeFound || left || right;
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

        checkIfLca(root, root.left.right.left, root.left.right.right);
    }
}
