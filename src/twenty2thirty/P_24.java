package twenty2thirty;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-15 16:21
 * @Description: 二叉搜索树的后序遍历序列 p179
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class P_24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean IsTreeBST(int [] sequence,int start,int end ){
        //有个end-1  故要注意是小于等于
        if(end <= start) return true;
        //遍历前半个子树,找到后半个子树的起点
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        //遍历后半个子树
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        //递归遍历左右子树
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
    }
}
