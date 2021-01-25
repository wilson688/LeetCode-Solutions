package BinaryTrees;

import apple.laf.JRSUIUtils;

public class SortedNumsToBST {

    int[] nums;

    public TreeNode createBST(int[] nums) {
        this.nums = nums;

        return helper(0, nums.length - 1);
    }

    private TreeNode helper(int start, int end) {
        if(end < start) return null;

        int p = (start + end) / 2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(0, p - 1);
        root.right = helper(p +1, end);
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        SortedNumsToBST t = new SortedNumsToBST();

        System.out.println("Tree has path sequence: " + t.createBST(new int[] {
                -10,-3,0,5,9}));
    }
}
