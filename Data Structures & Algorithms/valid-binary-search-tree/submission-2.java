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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        verifyBST(root,inOrder);
        int prev = -10000;
        for(int next: inOrder){
            if(next<=prev){
                return false;
            }
            prev = next;
        }
        return true;
    }
    public void verifyBST(TreeNode root, List<Integer> inOrder){
        if(root.left != null){
            verifyBST(root.left, inOrder);
        }
        inOrder.add(root.val);
        if(root.right != null){
            verifyBST(root.right, inOrder); 
        }       
    }
}
