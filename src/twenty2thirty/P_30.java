package twenty2thirty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-18 13:08
 * @Description:最小的K个数
 *输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 时间复杂度只有O(nlogk), 因为堆中总共k个数，每插入或删除一个数，都要调整一次堆，即时间复杂度为O(logk),
 * 共循环n次，插入的次数最坏情况为n次，删除为n-k次，而平均下来插入次数也不少，所以大致估计时间复杂度就在nlogk
 */
public class P_30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        //用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
        // 在java中优先队列是基于堆实现的
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                // 下面两行是为了GC
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
