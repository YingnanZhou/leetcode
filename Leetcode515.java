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
    public List<Integer> largestValues(TreeNode root) {
        //store the result
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    //the level starts at 0, level is corresponding to the index of the list,
    //for example, all elements at level 1 are corresponding the index 2 of the list, what we have to do is to pick the max one and put it into this position
    //if level equals the size of the list, which means this is the first element in this level, we add it to the list directly, otherwise we should compare this element to the elemen
    private void helper(TreeNode root, List<Integer> res, int level) {
        if(root == null) return;
        if(res.size() == level) res.add(root.val);
        res.set(level, Math.max(root.val, res.get(level)));
        
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}