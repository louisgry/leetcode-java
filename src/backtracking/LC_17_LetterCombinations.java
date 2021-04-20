package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2021/4/17 16:50
 */
public class LC_17_LetterCombinations {
    /**
     * 题目：电话号码的字母组合
     * 思路：回溯
     */
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
            System.out.println(s+", return");
            return;
        }

        char c = digits.charAt(index);
        // 边界情况：字符串合法性
        assert( c>='0' && c<='9' && c!='1');
        String letters = letterMap[c-'0'];

        // 遍历字母字符串
        for(int i=0; i<letters.length(); i++) {
            System.out.println(c+", use "+letters.charAt(i));
            backtrack(digits, index+1, s+letters.charAt(i));
        }
        System.out.println(c+" complete, return");
    }

    /** main */
    public static void main(String[] args) {
        String digits1 = "23";
        // ==> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println((new LC_17_LetterCombinations()).letterCombinations(digits1));


//        String digits2 = "";
//        // ==> []
//        System.out.println((new LC_17_LetterCombinations()).letterCombinations(digits2));
//
//        String digits3 = "2";
//        // ==> ["a","b","c"]
//        System.out.println((new LC_17_LetterCombinations()).letterCombinations(digits3));
    }
}
