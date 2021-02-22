package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfOneAnother {

    public boolean isSubtree(TreeNode s, TreeNode t) {
       if(s == null && t == null) return true;

       if(s == null || t == null) return false;

        if(s.val == t.val) {
            return traverse(s, t);
        }

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(s);


        while(!myQueue.isEmpty()) {
            TreeNode currNode = myQueue.poll();

            if(currNode.left != null) {
                if(currNode.left.val == t.val) {
                    return traverse(currNode.left, t);
                }
                myQueue.add(currNode.left);
            }

            if(currNode.right != null) {
                if(currNode.right.val == t.val) {
                    return traverse(currNode.right, t);
                }

                myQueue.add(currNode.right);
            }
        }

        return traverse(s, t);
    }


    public boolean traverse(TreeNode s,TreeNode t) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(s);
        queue2.add(t);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode currSTree = queue1.poll();
            TreeNode currTTree = queue2.poll();

            if(currSTree.val != currTTree.val) return false;

            if(currSTree.left != null) {
                queue1.add(currSTree.left);

            }

            if(currTTree.left != null) {
                queue2.add(currTTree.left);

            }

            //do the same for right
            if(currSTree.right != null ) {
                queue1.add(currSTree.right);

            }

            if(currTTree.right != null) {
                queue2.add(currTTree.right);

            }

        }

        if(!queue1.isEmpty() || !queue2.isEmpty()) return false;


        return true;
    }


    public static void main(String[] args) {
        SubtreeOfOneAnother sb = new SubtreeOfOneAnother();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);


        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        subRoot.right.left = new TreeNode(0);


        System.out.println(sb.isSubtree(root, subRoot));

        TreeNode s = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode t = new TreeNode(1);

        System.out.println(sb.isSubtree(s, t));

    }
}
