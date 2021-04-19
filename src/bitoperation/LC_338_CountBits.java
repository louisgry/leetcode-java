package bitoperation;

/**
 * @author Louis
 * @date Create in 2021/4/19 16:21
 */
public class LC_338_CountBits {
    /**
     * 题目：比特位计数
     * 推荐解法：位运算
     * 简单解法：朴素法
     */
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=1; i<=num; i++) {
            // i&(i-1)：消耗掉最右边的1，如12：1100==>1000
            dp[i] = dp[i & (i-1)] + 1;
        }
        return dp;
    }

    public int[] countBits2(int num) {
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

    /** main */
    public static void main(String[] args) {
        int num = 2;
        int[] res = (new LC_338_CountBits()).countBits(num);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
