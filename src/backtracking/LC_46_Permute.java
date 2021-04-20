package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/20 14:29
 */
public class LC_46_Permute {
    /**
     * 题目：全排列
     * 解法：回溯
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrak(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     * 回溯辅助函数
     * @param nums 数组
     * @param index 当前下标
     * @param path 路径的值
     */
    private void backtrak(int[] nums, int index, List<Integer> path) {
        if(index == nums.length) {
            res.add(new ArrayList<>(path));
            System.out.println(path+", return");
            return;
        }
        for(int i=0; i<nums.length; i++) {
            // 判断nums[i]是否在path中
            if(!path.contains(nums[i])) {
                System.out.println(nums[i]);
                path.add(nums[i]);
                backtrak(nums, index+1, path);
                System.out.println("remove "+path.get(path.size()-1));
                path.remove(path.size()-1);
            }
        }
    }

    /** main */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println((new LC_46_Permute()).permute(nums));
    }
}
