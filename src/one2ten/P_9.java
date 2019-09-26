package one2ten;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 20:48
 * @Description: 变态跳台阶 P78本题扩展
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 【分析】
 *
 * （1）假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1)；假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)；
 *      假定第一次跳的是3阶，那么剩下的是n-3个台阶，跳法是f(n-3)......假定第一次跳的是n-1阶，那么剩下的是1个台阶，跳法是f(1)；
 *      假定第一次跳的是n阶，那么剩下的是0个台阶，跳法是1种；
 * （2）总跳法为: f(n) = 1+f(n-1) + f(n-2)+....+f(1)  （第一个1是跳n阶只有一种方法）
 * （3）根据（2）可以得出有一阶的时候 f(1) = 1 ；
 *      有两阶的时候可以有 f(2) = 1+f(1)=2；
 *      有三阶的时候可以有 f(3) = 1+f(2)+f(1)=4...依次内推，有n阶时f(n)=2^(n-1)。
 */
public class P_9 {
    public int JumpFloorII(int target) {
        if(target <= 0) {
            return 0;
        }
        //左右target-1位 实现2^(target-1)次方
        return 1<<(target - 1);
    }
    @Test
    public  void  test9(){
        System.out.println(JumpFloorII(4));
    }
}
