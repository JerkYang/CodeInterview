package thirty2forty;

import data_structure.TreeNode;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-22 14:44
 * @Description: 二叉树的深度 p271
 */
public class P_39 {
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int nLelt=TreeDepth(root.left);
        int nRight=TreeDepth(root.right);
        return nLelt>nRight?(nLelt+1):(nRight+1);
    }
}
