package twenty2thirty;

import java.util.Stack;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-15 15:35
 * @Description: 包含min函数的栈 p165
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class P_21 {
    /**数据栈*/
    Stack<Integer> dataStack = new Stack<Integer>();
    /**辅助栈*/
    Stack<Integer> minStack = new Stack<Integer>();

    /**最小元素压栈的同时压入辅助栈*/
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
