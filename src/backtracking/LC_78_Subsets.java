package backtracking;

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
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res);
        return res;
    }

    private void backtrack(List<List<Integer>> res) {

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // ==> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println((new LC_78_Subsets()).subsets(nums));

    }
}
