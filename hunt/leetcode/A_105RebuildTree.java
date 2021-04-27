package leetcode;

import java.util.HashMap;

public class A_105RebuildTree {
    /*根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
*/


    public static TreeNode build(int[] pre,int pleft,int pright,int[] inorder,int ileft,int iright,HashMap<Integer,Integer> map ){
        if(pleft>pright||ileft>iright) return null;
        TreeNode root = new TreeNode(pre[pleft]);
        int rootIndex = map.get(root.val);
        int numsLeft = rootIndex - ileft;
        root.left = build(pre,pleft+1,pleft+numsLeft,inorder,ileft,rootIndex
        -1,map);
        root.right = build(pre,pleft+numsLeft+1,pright,inorder,rootIndex+1,iright,map);
               return root;
    }

    public static  TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[]  inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder,inorder);

    }
}
