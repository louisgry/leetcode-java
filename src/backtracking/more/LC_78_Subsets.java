package backtracking.more;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/17 15:43
 */
public class LC_78_Subsets {
    /**
     * 题目：子集
     * 思路：回溯法
     * 参考：https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     * 回溯辅助函数：
     * @param nums 数组
     * @param index 当前下标
     * @param path 树路径的值
     */
    private void backtrack(int[] nums, int index, List<Integer> path) {
        res.add(new ArrayList<>(path)); // 注意：由于Java的引用传递，这里要new
        // 递归终止条件：index与数组长度相等
        if(index == nums.length) {
            return;
        }
        // 遍历数组元素
        for(int i=index; i<nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1); // 删最后一个元素
        }
    }

    /** main */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // ==> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println((new LC_78_Subsets()).subsets(nums));

    }
}
