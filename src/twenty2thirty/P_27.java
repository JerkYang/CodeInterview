package twenty2thirty;


import data_structure.TreeNode;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-15 19:05
 * @Description: 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class P_27 {
    protected TreeNode leftLast = null;

    public TreeNode Convert(TreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            // 最后的一个节点可能为最右侧的叶节点
            leftLast = root;
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            leftLast.right = root;
            root.left = leftLast;
        }
        // 当根节点只含左子树时，则该根节点为最后一个节点
        leftLast = root;
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;

    }
}
