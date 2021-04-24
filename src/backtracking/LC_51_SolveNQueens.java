package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/24 17:09
 */
public class LC_51_SolveNQueens {
    /**
     * 题目：N皇后
     * 解法：回溯
     */
    List<List<String>> res = new ArrayList<>();
    boolean[] col; // 竖向判断
    boolean[] diag1; // 对角线1判断
    boolean[] diag2; // 对角线2判断

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2*n-1];
        diag2 = new boolean[2*n-1];

        backtrack(n, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int index, List<Integer> row) {
        if(index == n) {
            res.add(gen_res(n, row));
        }

        // 遍历所有列
        for(int j=0; j<n; j++) {
            // 竖向、对角线1、对角线2合法
            if(!col[j] && !diag1[index+j] && !diag2[index-j+n-1]) {
                row.add(j);
                col[j] = true;
                diag1[index+j] = true;
                diag2[index-j+n-1] = true;

                // 递归
                backtrack(n, index+1, row);

                // 回溯
                row.remove(row.size()-1);
                col[j] = false;
                diag1[index+j] = false;
                diag2[index-j+n-1] = false;
            }
        }
    }

    private List<String> gen_res(int n, List<Integer> row) {
        List<String> resString = new ArrayList<>();
        for(int i=0; i<n; i++) {
            char[] charArr = new char[n];
            Arrays.fill(charArr, '.');
            charArr[row.get(i)] = 'Q';
            resString.add(new String(charArr));
        }
        return resString;
    }

    /** main */
    public static void main(String[] args) {
        int n = 4;
        System.out.println((new LC_51_SolveNQueens()).solveNQueens(n));
    }
}
