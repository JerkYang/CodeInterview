package one2ten;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 20:58
 * @Description:  矩阵覆盖 p79相关题目
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 【分析】
 * 我们先把2×8的覆盖方法记为f(8)。用第一个2x1的小矩形去覆盖大矩形的最左边时有两种选择：竖着放或者横着放。
 * 当竖着放的时候，右边还剩下2×7的区域，这种情形下的覆盖方法记为f(7)。
 * 接下来考虑横着放的情况。当2x1的小矩形横着放在左上角的时候，左下角必须和横着放一个2x1的小短形，而在右边还剩下2×6的区域，
 * 这种情形下的覆盖方法记为f(6)，因此f(8)=f(7)+f(6)。此时我们可以看出，这仍然是要波那契数列。
 */
public class P_10 {
    public int RectCover(int target) {
        int a=1;
        int b=2;
        int c =0;
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            for(int i = 0;i < target-2;i++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
