package eleven2twenty;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-12 12:25
 * @Description: 调整数组顺序使奇数位于偶数前面 p131
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class P_13 {
    public void reOrderArray(int[] array) {
        if (array != null) {
            int[] even = new int[array.length];
            int indexOdd = 0;
            int indexEven = 0;
            for (int num : array) {
                if ((num & 1) == 1) {
                    array[indexOdd++] = num;
                } else {
                    even[indexEven++] = num;
                }
            }
            for (int i = 0; i < indexEven; i++) {
                array[indexOdd + i] = even[i];
            }
        }
    }
}
