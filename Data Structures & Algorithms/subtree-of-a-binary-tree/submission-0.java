/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(isSame(top,subRoot)){
                return true;
            }
            if(top.left != null){
                stack.push(top.left);
            }
            if(top.right != null){
                stack.push(top.right);
            }
        }
        return false;
    }
    public boolean isSame(TreeNode root, TreeNode root2){
        if(root == null && root2 == null) return true;
        if(root == null || root2 == null) return false;
        if(root.val != root2.val) return false;
        return isSame(root.left,root2.left) && isSame(root.right, root2.right);
    }
}
