/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
    
    private int dfs(TreeNode root) {
        //null nodes return 0 makes sure leaves on level 1(bot to top)
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        //if one subtree is null, we have to return the minDepth of the other one
        if(left == 0) return right + 1;
        if(right == 0) return left + 1;
       //return lowest level among two subtrees
        return Math.min(left,  right) + 1;
    }
}