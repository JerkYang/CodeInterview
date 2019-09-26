package thirty2forty;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-18 13:59
 * @Description: 整数中1出现的次数（从1到n整数中1出现的次数）p221
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 *
 * 当n = 3141592时:
 * m	a	    b	  ones
 * 1	3141592	0	(3141592+8)/10*1+0=314160
 * 10	314159	2	(314159+8)/10*10+0=314160
 * 100	31415	92	(31415+8)/10*100+0=314200
 * 1000	3141	592	(3141+8)/101000+1(592+1)=314593
 * 当然后面还有m=10000,100000,1000000三种情况，对应着万位，十万位， 百万位为1时的情况
 *
 * 下面说下a+8的意义：
 *
 * 当考虑个位，十位，百位这三位为1的情况时：
 *
 * 个位 2 ，当个位取值1时，前面的六位数字可由0~314159组成，即314160种情况
 *
 * 十位9，当十位取值1时，前面的五位数字可由0~31415组成，十位之后的一位可由0~9组成，组合情况31416*10=314160种情况
 *
 * 百位5，当百位取值为1时，前面的四位数字可由0~3141组成，百位之后的两位可由0~99组成，组合情况为3142*100=314200种情况
 *
 * 注意：当考虑千位1时：
 *
 * 千位1，千位取值即1，前面的三位数字可由0~314组成，但是当前面的值为314时，后面的三位只有0~592种情况(特殊情况)，
 * 其余的情况即为前面的值为0~313,后面三位有0~999,情况数为3141000，所以总情况数为3141000 + 593=314593种情况
 *
 * 这时可发现和代码中的公式算的情况是吻合的，a+8的巧妙之处在于当a的最后一位(当前分析位)为0或1时，加8不产生进位，
 * 这是为需要单独算的特殊情况做准备，而当前分析位为2~9时，不需要考虑特殊情况，所以允许加8产生的进位。
 */
public class P_32 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            ones += (a + 8) / 10 * m + ((a % 10 == 1) ? 1 : 0) * (b + 1);
        }
        return ones;
    }
}