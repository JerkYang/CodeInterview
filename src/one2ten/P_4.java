package one2ten;

import data_structure.TreeNode;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-11 14:42
 * @Description: 重建二叉树 p62
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class P_4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    /**
     * @param pre 前序序列 {1,2,4,7,3,5,6,8}
     * @param startPre 前序开始下标
     * @param endPre 前序结束下标
     * @param in 中序序列 {4,7,2,1,5,3,8,6}
     * @param startIn 中序开始下标
     * @param endIn 中序结束下标
     * @return
     */
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn){
            return null;
        }
        //前序序列的第一个节点为树的根节点
        TreeNode root=new TreeNode(pre[startPre]);
        //在中序序列中寻找树/子树的根节点
        for(int i=startIn;i<=endIn;i++) {
            if (in[i] == pre[startPre]) {
                //划分左子树 左子树前序[startPre + 1,startPre + i - startIn] 左子树中序[startIn,i - 1]
                //startPre + 1: 当前节点的下一个节点
                //startPre + i - startIn:  其中i - startIn为左子树节点个数
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //划分右子树
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
