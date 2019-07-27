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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;    
    }
    
    private int helper(TreeNode root) {
        //for every node, we record the max path, including its left branch and right branch
        //start from the bottom
        //if we reach leave child or a null branch, return 0;
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        //if current node's value is as the same as its right child or left child, then we hava a path, so the value increased by 1
        //if they are different, we return 0, there is no path
        left = root.left != null && root.val == root.left.val ? left + 1 : 0;
        right = root.right != null && root.val == root.right.val ? right + 1 : 0;
        
        //for every recusion, we record the max result
        max = Math.max(max, left + right);
        
        //for left and right branch, we can only choose one
        return Math.max(left, right);
    }
}