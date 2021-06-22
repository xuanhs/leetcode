package middle;

//给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
//
// 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False
//。
//
// 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null
//,1,3]
//输出：true
//解释：树中蓝色的节点构成了与链表对应的子路径。
//
//
// 示例 2：
//
//
//
// 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,nu
//ll,1,3]
//输出：true
//
//
// 示例 3：
//
// 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
//null,1,3]
//输出：false
//解释：二叉树中不存在一一对应链表的路径。
//
//
//
//
// 提示：
//
//
// 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
// 链表包含的节点数目在 1 到 100 之间。
// 二叉树包含的节点数目在 1 到 2500 之间。
//
// Related Topics 树 链表 动态规划
// 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import source.ListNode;
import source.TreeNode;

/**
 * 主要解题思路：树递归
 * 每个节点匹配，匹配到时返回true
 * 当前节点匹配失败时，继续判断下一节点，即（head，root）匹配失败，但（head,root.left）与（head,root.right）可能匹配成功
 * 只需要注意并不需要从头开始匹配，可以是中间某段匹配即可
 */
class Solution1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSub(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return isSub(head.next, root.left) || isSub(head.next, root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

