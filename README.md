# leetcode-java

LeetCode Java Solution

## 题目

### [回溯](#backtracking)

- [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)：[【17题解】](#17题解)



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