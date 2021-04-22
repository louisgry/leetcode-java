package backtracking.more;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/22 16:40
 */
public class LC_79_Exist {
    /**
     * 题目：单词搜索
     * 解法：回溯
     */
    int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(backtrack(board, word,0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word,
                              int index, int startx, int starty) {
        // 递归终止条件：index等于word的长度，返回最后一个字符是否相等
        if(index == word.length()-1) {
            return board[startx][starty] == word.charAt(index);
        }
        if(board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            // 上下左右搜索
            for(int i=0; i<4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                // 先判断是否越界，再判断当前字符是否未访问
                if(inArea(newx, newy, board.length, board[0].length) && !visited[newx][newy]) {
                    // 进行下一个递归操作
                    if(backtrack(board, word, index+1, newx, newy)) {
                        return true;
                    }
                }
            }
            // 回溯操作
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    /** main */
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println((new LC_79_Exist()).exist(board, word));
    }
}
