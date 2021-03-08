//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 634 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {}
        TreeNode (int val) { this.val = val; }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

   //leetcode submit region begin(Prohibit modification and deletion)
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
   // 法一：深度优先搜索-递归
   // 算法思想：可以使用深度优先搜索合并两个二叉树。从根节点开始同时遍历两个二叉树，并将对应的节点进行合并。
   //         两个二叉树的对应节点可能存在以下三种情况，对于每种情况使用不同的合并方式：
   //        （1）如果两个二叉树的对应节点都为空，则合并后的二叉树的对应节点也为空；
   //        （2）如果两个二叉树的对应节点只有一个为空，则合并后的二叉树的对应节点为其中的非空节点；
   //        （3）如果两个二叉树的对应节点都不为空，则合并后的二叉树的对应节点的值为两个二叉树的对应节点的值之和，此时需要显性合并两个节点。
   //         对一个节点进行合并之后，还要对该节点的左右子树分别进行合并。这是一个递归的过程。
   // 时间复杂度：O(min(m, n))，空间复杂度：O(min(m, n))  其中m和n分别是两个二叉树的节点个数
   // 时间复杂度说明：对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，
   //              因此被访问到的节点数不会超过较小的二叉树的节点数
   // 空间复杂度说明：间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数
   // 参考资料1：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/(官方解)
   class Solution {
       public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
           // 如果两个二叉树的对应节点都为空 | 如果两个二叉树的对应节点只有一个为空
           if (root1 == null) {
               return root2;
           }
           if (root2 == null) {
               return root1;
           }

           // 如果两个二叉树的对应节点都不为空
           TreeNode merged = new TreeNode(root1.val + root2.val);
           merged.left = mergeTrees(root1.left, root2.left);
           merged.right = mergeTrees(root1.right, root2.right);

           return merged;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}