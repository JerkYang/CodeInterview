package thirty2forty;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-21 10:46
 * @Description: 丑数 p240
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * [思路]
 * 所有的丑数分为三种类型 2*i,3*i,5*i     其中 i是数组中的元素，一开始只有1
 * [2*1]  3*1  5*1
 * 2*2  [3*1]  5*1
 * [2*2]  3*2  5*1
 * 2*3  3*2  [5*1]
 * [2*3]  3*2  5*2
 * [2*4]  3*3  5*2
 * 2*5  [3*3]  5*2
 * [2*5] 3*4  5*2
 * [2*6] 3*4  5*3
 * 2*8  [3*5]  5*3
 * [2*8]  3*6  5*4
 */
public class P_34 {
    public static final int MIN_INDEX=7;
    public int GetUglyNumber_Solution(int index) {
        if (index < MIN_INDEX) {
            return index;
        }
        int[] ret = new int[index];
        ret[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            ret[i] = min(min(ret[t2] * 2, ret[t3] * 3), ret[t5] * 5);
            if (ret[i] == ret[t2] * 2) {
                t2++;
            }
            if (ret[i] == ret[t3] * 3) {
                t3++;
            }
            if (ret[i] == ret[t5] * 5) {
                t5++;
            }
        }
        System.out.println("第"+index+"个"+"丑数是"+ret[index - 1]);
        return ret[index - 1];
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
    @Test
    public void Test(){
     GetUglyNumber_Solution(20);
    }
}
