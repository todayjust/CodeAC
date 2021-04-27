package leetcode;

public class A_124MaxTreePath {

    static int ans = Integer.MIN_VALUE;

    static int maxOneSide(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0,maxOneSide(root.left));
        int right = Math.max(0,maxOneSide(root.right));
        ans = Math.max(ans,left+right+root.val);


        return Math.max(left, right) + root.val;
    }
    public static int maxPathSum(TreeNode root) {
        maxOneSide(root);
        return ans;
    }

    public static void main(String[] args) {
    /*输入：root = [-10,9,20,null,null,15,7]
    输出：42
    解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
    */
        TreeNode r =new TreeNode(-10);
        r.left =new TreeNode(9);
        r.right=new TreeNode(20);
        r.right.left=new TreeNode(15);
        r.right.right=new TreeNode(7);
        System.out.println(maxPathSum(r));
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