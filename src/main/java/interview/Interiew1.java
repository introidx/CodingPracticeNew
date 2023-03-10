package interview;

import com.sun.source.tree.Tree;

import java.util.*;

public class Interiew1 {

    public static void main(String[] args) {
//[1,2,3,null,null,4,5]
        String s = "1,*, 2,3,null, null, *, 4,5";



    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i =0; i < inorder.length ; i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length -1, inorder , 0, inorder.length , inMap);
        return root;



    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(preorder[preStart]);
        int numLeft = inRoot - inStart;

        root.left = helper(preorder, preStart +1 , preStart + numLeft , inorder, inStart, inRoot -1, inMap);
        root.right = helper(preorder, preStart + numLeft + 1,preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
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

