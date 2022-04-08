package BST;

public class TreeFromPreorderTraversal {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static Node prev = null;

    public static Node treeFromPreorderTraversal(int[] preorder){
        int iter = preorder.length - 1;

        while(iter >= 0){
            Node curr = new Node(preorder[iter]);
            if(prev != null) {
                if(prev.val > curr.val){
                    curr.right = prev;
                }else{
                    Node next = prev;
                    while(prev.right != null && prev.right.val < curr.val) prev = prev.right;
                    curr.right = prev.right;
                    prev.right = null;
                    curr.left = next;
                }
            }
            prev = curr;
            iter--;
        }

        return prev;
    }

    public static void preorderTraversal(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,12};

        Node root = treeFromPreorderTraversal(preorder);

        preorderTraversal(root);
    }
}
