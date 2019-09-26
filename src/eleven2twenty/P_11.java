package eleven2twenty;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-12 09:01
 * @Description: 二进制中1的个数 P101
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class P_11 {
    /**
     * 可能陷入死循环的解法 如Ox80000000 右移一位得到0xC0000000 一直右移得到0xFFFFFFFF 从而陷入死循环
     *
     * @param n
     * @return
     * @link https://blog.csdn.net/youyou362/article/details/72667951/
     */
    public int NumberOf1_1(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            n = n >> 1;
        }
        return sum;
    }

    /**
     * 【常规写法】
     * 为了避免死循环，我们可以不右移输入的数字n。首先把n和1做与运算，判断n的最低位是不是为1。
     * 接着把1左移-位得到2，再和n做与运算，就能判断n的次低位是不是1....这样反复左移，
     * 每次都能判断n的其中一位是不是1。基于这种思路，我们可以把代码修改如下:
     *
     * @param n
     * @return
     */
    public int NumberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while (0 != flag) {
            if ((n & flag) != 0) {
                count++;
            }
            //无符号右移，例如从11101变成1110
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 无符号右移>>>(不论正负,高位均补0)
     *
     * @param n
     * @return
     */
    public int NumberOf1_3(int n) {
        int sum = 0;
        while (n != 0) {
            //逐个判断低位是否为1；
            sum += n & 1;
            //无符号右移，例如从11101变成1110
            n = n >>> 1;
        }
        return sum;
    }

    /**
     * 想不到的写法,
     * 我们把上面的分析总结起来就是:把个整数减去1,再和原第会把该整数最右边的1变成0.那么一个整数的二进制表示中有多少个1,就可以
     * 进行多少次这样的操作。
     * @param n
     * @return
     */
    public int NumberOf1_4(int n) {
        int sum = 0;
        while (n != 0) {
            ++sum;
            n = (n - 1) & n;
        }
        return sum;
    }

    @Test
    public void Test11() {
        int i = 0x80000000;
        System.out.println(NumberOf1_1(i));
        System.out.println(NumberOf1_2(i));

        System.out.println(NumberOf1_3(i));
        System.out.println(NumberOf1_4(i));
    }
}
