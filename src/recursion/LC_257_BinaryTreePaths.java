package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/28 13:26
 */
public class LC_257_BinaryTreePaths {
    /**
     * 题目：二叉树的所有路径
     * 解法：递归
     */
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return res;
    }

    private void helper(TreeNode root, String path) {
        // 递归终止条件
        if(root == null) {
            return;
        }
        if(root.left==null && root.right==null) {
            path += root.val;
            res.add(path);
        }

        // 递归过程
        path += root.val + "->";
        helper(root.left, path);
        helper(root.right, path);
    }

    /** main */
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, new TreeNode(5));
        TreeNode root = new TreeNode(1, left, new TreeNode(3));
        System.out.println((new LC_257_BinaryTreePaths()).binaryTreePaths(root));
    }
}
