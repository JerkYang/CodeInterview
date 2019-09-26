package one2ten;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 20:43
 * @Description: 跳台阶
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class P_8 {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}
