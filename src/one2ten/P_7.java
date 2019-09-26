package one2ten;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 16:28
 * @Description: 斐波那契数列 p76
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class P_7 {
    public int Fibonacci(int n) {
        int F1 = 0;
        int F2 = 1;
        int Fn = 0;
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            //自底向上计算 可以节省空间 应为记录了每一步的操作结果
            for (int i = 3; i <= n; i++) {
                Fn = F1 + F2;
                F2 = F1;
                F1 = Fn;
            }
            return Fn;
        }
    }

    @Test
    public void Test7() {
        int fibonacci = Fibonacci(40);
        System.out.println(fibonacci);
    }
}
