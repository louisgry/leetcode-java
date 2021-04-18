package brute;

/**
 * @author Louis
 * @date Create in 2021/4/18 18:05
 */
public class LC_461_HammingDistance {
    /**
     * 题目：汉明距离
     * 思路：直觉
     */
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
