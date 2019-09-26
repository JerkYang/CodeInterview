package thirty2forty;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-22 13:36
 * @Description: 数字在排序数组中出现的次数 p263
 * 统计一个数字在排序数组中出现的次数。例如,输入排序数组{1,2,3,3,3,3,4,5}和数字3,由于3在这个数组中出现了4次,因此输出4.
 * [思路]
 * 因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
 * 这两个数应该插入的位置，然后相减即可。
 */
public class P_38 {
    public int GetNumberOfK(int[] array, int k) {
        return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
    }

    public int biSearch(int[] array, double num) {
        int s = 0, e = array.length - 1;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (array[mid] < num) {
                s = mid + 1;
            } else if (array[mid] > num) {
                e = mid - 1;
            }
        }
        return s;
    }

    @Test
    public void Test() {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(arr, 3));
    }


    //方法二 书上写法
    public int GetNumberOfKII(int[] array, int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length - 1);
        int lastK = getLastK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    //递归写法
    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    //循环写法
    private int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }


}
