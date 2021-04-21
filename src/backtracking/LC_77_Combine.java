package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/21 20:37
 */
public class LC_77_Combine {
    /**
     * 题目：组合
     * 解法：回溯
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 边界判断
        if(n<=0 || k<=0 || k>n) {
            return res;
        }
        // 从数字1开始回溯
        backtrack(n, k, 1, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int k, int index, List<Integer> path) {
        // 递归终止条件：path的个数等于k
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<=n; i++) {
            path.add(i);
            // 递归操作
            backtrack(n, k, i+1, path);
            // 回溯操作
            path.remove(path.size()-1);
        }
    }

    /** main */
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println((new LC_77_Combine()).combine(n, k));
    }
}
