# leetcode-java

LeetCode Java Solution



## 题目

### [递归](#recursion)

- [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)：[【104题解】](#104题解)
- [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)：[【226题解】](#226题解)
- [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)：[【112题解】](#112题解)
- [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)：[【257题解】](#257题解)
- more
- [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
- [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)
- [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
- [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/)
- [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)
- [404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/)
- [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)
- [129. 求根节点到叶节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)



### [回溯](#backtracking)

- [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)：[【17题解】](#17题解)

- [46. 全排列](https://leetcode-cn.com/problems/permutations/)：[【46题解】](#46题解)

- [77. 组合](https://leetcode-cn.com/problems/combinations/)：[【77题解】](#77题解)

- [79. 单词搜索](https://leetcode-cn.com/problems/word-search/)：[【79题解】](#79题解)

- [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)：[【200题解】](#200题解)

- [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)：[【51题解】](#51题解)

  more

- [93. 复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses/)

- [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)

- [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

- [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)

- [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

- [216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/)

- [78. 子集](https://leetcode-cn.com/problems/subsets/)：[【78题解】](#78题解)

- [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)

- [401. 二进制手表](https://leetcode-cn.com/problems/binary-watch/)

- [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)

- [417. 太平洋大西洋水流问题](https://leetcode-cn.com/problems/pacific-atlantic-water-flow/)

- [37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/)



### [位运算](#bitoperation)

- [461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance/)：[【461题解】](#461题解)
- [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)：[【338题解】](#338题解)



## 题解

### recursion

### 104题解

- 解法：递归
- 复杂度：O(n)、O(h)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        // 递归终止条件
        if(root == null) {
            return 0;
        }

        // 递归过程
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
```



### 226题解

- 解法：递归
- 复杂度：O(n)、O(h)

```java
class Solution {
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
}
```



### 112题解

- 解法：递归
- 复杂度：O(n)、O(h)

```java
class Solution {
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
}
```



### 257题解

- 解法：递归
- 复杂度：O(n)、O(h)

```java
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return res;
    }

    private void helper(TreeNode root, String path) {
        // 递归终止条件
        if(root == null) {
            return;
        }
        if(root.left==null && root.right==null) {
            path += root.val;
            res.add(path);
        }

        // 递归过程
        path += root.val + "->";
        helper(root.left, path);
        helper(root.right, path);
    }
}
```





### backtracking

#### 17题解

- 解法：回溯
- 复杂度：O(2 x len(s))、O(len(s))

```java
class Solution {
    final String[] letterMap = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz", // 9
    };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 边界情况：空串
        if(digits.equals("")) {
            return res;
        }
        backtrack(digits, 0, "");
        return res;
    }

    /**
     * 回溯辅助函数，得到每一个字母的树排列
     * @param digits 数字字符串
     * @param index 第几个数字
     * @param s 前index个的字母字符串
     */
    private void backtrack(String digits, int index, String s) {
        // 递归终止条件：index与digits长度相等
        if(index == digits.length()) {
            // 保存s
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        // 边界情况：字符串合法性
        assert( c>='0' && c<='9' && c!='1');
        String letters = letterMap[c-'0'];

        // 遍历字母字符串
        for(int i=0; i<letters.length(); i++) {
            // s <== s+letters.charAt(i)
            backtrack(digits, index+1, s+letters.charAt(i));
        }
    }
}
```



### 46题解

- 解法：回溯
- 复杂度：O(n^n)、O(n)

```java
class Solution {
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
        // 递归终止条件：index与nums长度相等
        if(index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            // 判断nums[i]是否在path中
            if(!path.contains(nums[i])) {
                path.add(nums[i]);
            	// 递归操作
                backtrak(nums, index+1, path);
            	// 回溯操作
                path.remove(path.size()-1);
            }
        }
    }
}
```



### 77题解

- 解法：回溯
- 复杂度：O(n^k)、O(k)

```java
class Solution {
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
}
```

- 优化：剪枝，不需要遍历到i=n

```java
	private void backtrack(int n, int k, int index, List<Integer> path) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝：i最大为n-(k-path.size())+1
        for(int i=index; i<=n-(k-path.size())+1; i++) {
            path.add(i);
            backtrack(n, k, i+1, path);
            path.remove(path.size()-1);
        }
    }
```



### 79题解

- 解法：回溯
- 复杂度：O(n^2m^2)、O(nxm)

```java
class Solution {
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
}
```



### 200题解

- 解法：回溯+DFS
- 复杂度：O(nxm)、O(nxm)

```java
class Solution {
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
}
```



### 51题解

- 解法：回溯
- 复杂度：O(n^n)、O(n)

```java
class Solution {
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
}
```





more



### 78题解

- 解法：回溯
- 复杂度：O(n x 2^n)、O(n)
- 参考：[回溯 + 位运算技巧—参考代码 1](https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/)

```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     * 回溯辅助函数：
     * @param nums 数组
     * @param index 当前下标
     * @param path 路径的值
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
}
```



## bitoperation

### 461题解

* 推荐解法：异或运算
* 复杂度：O(32)、O(32)

```java
class Solution {
    public int hammingDistance(int x, int y) {
        // 位运算：异或
        int xor = x ^ y;
        String bin_xor = Integer.toBinaryString(xor);
        // 找1的个数
        int res = 0;
        for(int i=0; i<bin_xor.length(); i++) {
            if(bin_xor.charAt(i) =='1') {
                res++;
            }
        }
        return res;
    }
}
```

- 简单解法：朴素法
- 复杂度：O(32)、O(32x2)

 ```java
class Solution {
    public int hammingDistance(int x, int y) {
        // 得到二进制表示
        String bin_x = Integer.toBinaryString(x);
        String bin_y = Integer.toBinaryString(y);

        // 左侧补零
        int max_len = Math.max(bin_x.length(), bin_y.length());
        bin_x = String.format("%"+max_len+"s",bin_x).replace(' ', '0');;
        bin_y = String.format("%"+max_len+"s", bin_y).replace(' ', '0');;

        // 找不同的个数
        int res = 0;
        for(int i=0; i<max_len; i++) {
            if(bin_x.charAt(i) != bin_y.charAt(i)) {
                res++;
            }
        }

        return res;
    }
}
 ```



### 338题解

- 推荐解法：动态规划+位运算
- 复杂度：O(num)、O(1)
- 参考：[比特位计数，多种解决方式—3，解法三](https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-duo-chong-jie-jue-fang-p77tu/)

```java
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=1; i<=num; i++) {
            // i&(i-1)：消耗掉最右边的1，如12：1100==>1000
            dp[i] = dp[i & (i-1)] + 1;
        }
        return dp;
    }
}
```

- 简单解法：朴素法
- 复杂度：O(num x 32)、O(32)

```java
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        // 遍历num
        for(int i=0; i<=num; i++) {
            // 转二进制找1的个数
            String bin_i = Integer.toBinaryString(i);
            int count = 0;
            for(int j=0; j<bin_i.length(); j++) {
                if(bin_i.charAt(j) == '1') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
```

