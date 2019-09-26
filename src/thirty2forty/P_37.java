package thirty2forty;

import data_structure.ListNode;

import java.util.HashSet;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-22 12:54
 * @Description:
 */
public class P_37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while (current1 != null) {
            hashSet.add(current1);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashSet.contains(current2)) {
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }

//方法2
    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        // 链表1
        ListNode current1 = pHead1;
        // 链表2
        ListNode current2 = pHead2;
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差
        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else{
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;

    }


    /**
     * 求指定链表的长度
     * @param pHead 链表头结点
     * @return 链表长度
     */
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
