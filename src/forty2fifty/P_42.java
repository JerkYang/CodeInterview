package forty2fifty;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-25 13:54
 * @Description: 和为s的连续正数序列 p282
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 */
public class P_42 {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
    @Test
    public void Test(){
        ArrayList<ArrayList<Integer>> continuousSequence = findContinuousSequence(15);
        for (ArrayList<Integer> list:continuousSequence
             ) {
            System.out.print("{");
            for (Integer x:list
                 ) {
                System.out.print(x);
                //最后一位去逗号
                if (!x.equals(list.get(list.size()-1))){
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
    }
}
