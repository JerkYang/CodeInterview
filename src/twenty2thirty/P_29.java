package twenty2thirty;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-18 10:39
 * @Description: 数组中出现次数超过一半的数字 p205
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class P_29 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;

        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        int time = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result) {
                time++;
            }
        }
        if (time * 2 <= array.length) {
            System.out.println(time);
            return 0;
        } else {
            return result;
        }
    }
    @Test
    public void Test(){
        int [] array={4,2,1,4,2,4};
        int i = MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }
}
