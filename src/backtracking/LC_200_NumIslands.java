package backtracking;

/**
 * @author Louis
 * @date Create in 2021/4/23 15:39
 */
public class LC_200_NumIslands {
    /**
     * 题目：岛屿数量
     * 解法：回溯 + DFS
     */
    private int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        assert n>0;
        int m = grid[0].length;
        visited = new boolean[n][m];

        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 判断是否为岛屿，并且未被访问过
                if(grid[i][j]=='1' && !visited[i][j]) {
                    res++;
                    dfs(grid, n, m, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int n, int m, int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            // 判断是否在边界内，未被访问过，且为岛屿
            if(inArea(newx, newy, n, m) && !visited[newx][newy] && grid[newx][newy]=='1') {
                dfs(grid, n, m, newx, newy);
            }
        }
    }

    private boolean inArea(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    /** main */
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        System.out.println((new LC_200_NumIslands()).numIslands(grid));
    }
}
