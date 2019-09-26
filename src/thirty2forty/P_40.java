package thirty2forty;

import data_structure.TreeNode;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-22 14:51
 * @Description: 平衡二叉树 p274
 *  从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
 */
public class P_40 {
    //重复遍历了节点
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
//                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
//
//    private int maxDepth(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//
//    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
