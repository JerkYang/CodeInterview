package twenty2thirty;

import data_structure.TreeNode;

import java.util.ArrayList;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-15 16:08
 * @Description: 从上往下打印二叉树 p171
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class P_23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        //用ArrayList模拟一个队列来存储相应的TreeNode
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
