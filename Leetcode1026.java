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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
    
    private int helper(TreeNode root, int min, int max) {
        if(root == null) return max - min; //base case
        
        //maintain max and min values in a path
        min = Math.min(root.val, min); 
        max = Math.max(root.val, max);
        
        //compare the results from left and right
        int l = helper(root.left, min, max); 
        int r = helper(root.right, min, max);
        return Math.max(l, r);
    }
}