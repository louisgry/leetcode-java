# leetcode-java

LeetCode Java Solution



## 题目

### [回溯](#backtracking)

- [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)：[【17题解】](#17题解)
- [78. 子集](https://leetcode-cn.com/problems/subsets/)：[【78题解】](#78题解)



## 题解

### backtracking

#### 17题解

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
            backtrack(digits, index+1, s+letters.charAt(i));
        }
    }
}
```



### 78题解

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
}
```

