package recursion;

/**
 * @author Louis
 * @date Create in 2021/4/28 0:00
 */
public class LC_112_HasPathSum {
    /**
     * 题目：路径总和
     * 解法：递归
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 边界条件
        if(root == null) {
            return false;
        }
        // 叶子节点：左右子树均为null
        if(root.left==null && root.right==null) {
            return root.val == targetSum;
        }
        // 找左子树
        if(hasPathSum(root.left, targetSum-root.val)) {
            return true;
        }
        // 找右子树
        if(hasPathSum(root.right, targetSum-root.val)) {
            return true;
        }
        // 没找到
        return false;
    }

    /** main */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println((new LC_112_HasPathSum()).hasPathSum(root, 5));
    }
}
