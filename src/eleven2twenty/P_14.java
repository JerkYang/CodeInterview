package eleven2twenty;
import data_structure.ListNode;
/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-12 14:50
 * @Description:  链表中倒数第k个结点 p135
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class P_14 {
    public ListNode findKthToTail(ListNode head, int k) {
        if(head==null || k==0){
            return null;
        }
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}
