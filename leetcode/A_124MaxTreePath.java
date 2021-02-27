public class A_124MaxTreePath {

    int ans = Integer.MIN_VALUE;

    int maxOneSide(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0,maxOneSide(root.left));
        int right = Math.max(0,maxOneSide(root.right));
        ans = Math.max(ans,left+right+root.val);


        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}