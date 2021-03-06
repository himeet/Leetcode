//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表 
// 👍 994 👎 0

package com.glj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

   //leetcode submit region begin(Prohibit modification and deletion)
   /**
    * Definition for singly-linked list.
    * public class ListNode {
    *     int val;
    *     ListNode next;
    *     ListNode(int x) {
    *         val = x;
    *         next = null;
    *     }
    * }
    */
   // 法二：哈希表法
   // 算法思想：遍历链表A并将每个结点的地址(或者引用)存储在哈希表中。然后检查链表B中的每一个结点b是否在哈希表中。
   //         若在，则b为相交节点。
   // 时间复杂度：O(m+n)，空间复杂度：O(m)或O(n)  其中n和m分别是两个链表的长度
   // 时间复杂度说明：需要遍历链表A和B各一次
   // 空间复杂度说明：只用到了常数复杂度的额外空间
   // 参考资料1：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/(官方解)
   // 备注1：官方解无代码
   public class Solution {
       public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
           // 制作哈希表
           Set<ListNode> hashSet = new HashSet<>();
           ListNode a = headA;
           while (a != null) {
               hashSet.add(a);
               a = a.next;
           }
           // 遍历B中check是否存在相同的点
           ListNode b = headB;
           while (b != null) {
               if (hashSet.contains(b)) {
                   return b;
               }
               b = b.next;
           }
           return null;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}