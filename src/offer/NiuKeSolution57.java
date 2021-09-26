package offer;

import source.ListNode;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/9/26 22:17
 * @description： 去除链表中重复出现的元素
 */
public class NiuKeSolution57 {

    /**
     * 一开始想得比较麻烦，想着剔除重复的
     * 后来改变了思路，只需要记录没有重复的即可，这样就少了非常多需要判断的情况，只需要找到不同的，然后记录下来就好了
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode res = new ListNode(0);
        ListNode node = new ListNode(0);
        res.next = node;
        while (pHead != null) {
            if (pHead.next == null) {
                node.next = pHead;
                break;
            }
            if (pHead.val != pHead.next.val) {
                node.next = pHead;
                node = node.next;
                pHead = pHead.next;
                continue;
            }
            while (pHead.next != null && pHead.val == pHead.next.val) {
                pHead.next = pHead.next.next;
            }
            node.next = pHead.next;
            node = node.next;
            pHead = pHead.next;
            System.out.println(pHead.val + "_" + pHead.next.val);
        }
        return res.next;
    }

}
