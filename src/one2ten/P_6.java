package one2ten;

import org.junit.Test;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 15:52
 * @Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class P_6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = left;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }
    @Test
    public  void Test6() {
        int[] arr={1,2,3,4,5,6};
        int i = minNumberInRotateArray(arr);
        System.out.println(i);

    }
}
