# leetcode-java

LeetCode Java Solution



## 题目

### [回溯](#backtracking)

- [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)：[【17题解】](#17题解)

- [46. 全排列](https://leetcode-cn.com/problems/permutations/)：[【46题解】](#46题解)

- [77. 组合](https://leetcode-cn.com/problems/combinations/)：[【77题解】](#77题解)

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

### [位运算](#bitoperation)

- [461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance/)：[【461题解】](#461题解)
- [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)：[【338题解】](#338题解)



## 题解

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

