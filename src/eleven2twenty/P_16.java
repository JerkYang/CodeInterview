package eleven2twenty;

import data_structure.ListNode;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-12 19:06
 * @Description: 合并两个排序的链表 p146
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class P_16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode res = null;
        if(list1.val<list2.val){
            res = list1;
            res.next = Merge(list1.next, list2);
        }else{
            res = list2;
            res.next = Merge(list1, list2.next);
        }
        return res;
    }
}
