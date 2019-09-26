package one2ten;

import data_structure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 14:22
 * @Description: 从尾到头打印链表  P58
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 */
public class P_3 {
    //递归写法
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if(listNode != null){
            this.printListFromTailToHead1(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
    //非递归写法 利用栈FILO特性
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
