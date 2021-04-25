package recursion;

/**
 * @author Louis
 * @date Create in 2021/4/25 23:30
 */
public class LC_104_MaxDepth {
    /**
     * 题目：二叉树的最大深度
     * 解法：递归
     */
    public int maxDepth(TreeNode root) {
        // 递归终止条件
        if(root == null) {
            return 0;
        }

        // 递归过程
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    /** main */
    public static void main(String[] args) {
        TreeNode left = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), left);
        System.out.println((new LC_104_MaxDepth()).maxDepth(root));
    }
}
