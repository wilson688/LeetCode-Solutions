package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

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


public class InvertTree {


   public TreeNode invertTree(TreeNode root) {

       if(root == null) return null;

       Queue<TreeNode> queue = new LinkedList<>();

       queue.offer(root);

       while(!queue.isEmpty()) {
           TreeNode currNode = queue.poll();
           TreeNode temp = currNode.left;
           currNode.left = currNode.right;
           currNode.right = temp;

           if(currNode.left != null) {
               queue.offer(currNode.left);
           }

           if(currNode.right != null) {
               queue.offer(currNode.right);
           }
       }

       return root;
   }

   public TreeNode invertTreeRecursive(TreeNode root) {
       if(root == null) return null;

       TreeNode left = invertTreeRecursive(root.left);
       TreeNode right = invertTreeRecursive(root.right);
       root.left = right;
       root.right = left;

       return root;
   }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        InvertTree t = new InvertTree();

        System.out.println("Tree has path sequence: " + t.invertTree(root));
        System.out.println("Tree has path sequence: " + t.invertTreeRecursive(root));
    }
}
