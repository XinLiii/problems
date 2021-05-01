package ama_oa_2021;

public class CountGoodNodes {
	public int res;
    public int goodNodes(TreeNode root) {
        res=0;
        helper(root,root.val);
        return res;
    }
    
    public void helper(TreeNode root,int bigValue){
        if(root==null) return;
        if(root.val>=bigValue){
            bigValue=Math.max(root.val,bigValue);
            this.res++;
        }
        helper(root.left,bigValue);
        helper(root.right,bigValue);
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
