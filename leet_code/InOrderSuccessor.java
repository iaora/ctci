/**

    Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

    Note: If the given node has no in-order successor in the tree, return null.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        getInOrder(root, arr);
        int targetIndex = arr.indexOf(p.val);
        
        // last value
        if(targetIndex == arr.size()-1)
            return null;
        
        int successorVal = arr.get(targetIndex+1);
        
        return findInOrder(root, successorVal);
    }
    
    private TreeNode findInOrder(TreeNode root, int target){
        if(root == null) return null;
        
        TreeNode left = findInOrder(root.left, target);
        if(root.val == target)
            return root;
        TreeNode right = findInOrder(root.right, target);
        
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
    
    private void getInOrder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;
        getInOrder(root.left, arr);
        arr.add(root.val);
        getInOrder(root.right, arr);
    }
}
