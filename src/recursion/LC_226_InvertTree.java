package recursion;

/**
 * @author Louis
 * @date Create in 2021/4/26 14:04
 */
public class LC_226_InvertTree {
    /**
     * 题目：翻转二叉树
     * 解法：递归
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归终止条件
        if(root == null) {
            return null;
        }

        // 递归过程
        // 错误写法：root.left=invertTree(root.right);
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // swap
        root.left = right;
        root.right = left;
        return root;
    }

    /** main */
    public static void main(String[] args) {
        TreeNode l = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode r = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode root = new TreeNode(4, l, r);

        TreeNode res = (new LC_226_InvertTree()).invertTree(root);
        TreeNode.printBST(res);
    }
}
