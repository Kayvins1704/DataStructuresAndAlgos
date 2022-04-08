package trees;

public class MaxPathSum {
    private static int currMaxPathSum = 0;

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static int getMaxPathSum(Node node){
        if(node == null) return 0;

        int leftNodePathSum = Math.max(node.val + getMaxPathSum(node.left), node.val);
        int rightNodePathSum = Math.max(node.val + getMaxPathSum(node.right), node.val);

        currMaxPathSum = Math.max(currMaxPathSum, leftNodePathSum + rightNodePathSum - node.val);

        return Math.max(leftNodePathSum, rightNodePathSum);
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

        /*Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(-20);
        root.right.left = new Node(-15);
        root.right.left.right = new Node(-100);
        root.right.right = new Node(7);*/

        getMaxPathSum(root);

        System.out.println(currMaxPathSum);
    }
}
