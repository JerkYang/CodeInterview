package thirty2forty;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-22 12:35
 * @Description: 数组中的逆序对 p249
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * [思路]
 * 过程：先把数组分割成子数组，先统计出子数组内部的逆序对的数目，
 * 然后再统计出两个相邻子数组之间的逆序对的数目。
 * 在统计逆序对的过程中，还需要对数组进行排序。
 * 如果对排序算法很熟悉，我们不难发现这个过程实际上就是归并排序。
 */
public class P_36 {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        //数值过大求余
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;

    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                //数值过大求余
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        //array[i]没复制完
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        //array[j]没复制完
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        //数组整体复制
        if (high + 1 - low >= 0) {
            System.arraycopy(copy, low, array, low, high + 1 - low);
        }

        return (leftCount + rightCount + count) % 1000000007;
    }
}
