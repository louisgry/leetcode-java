package bitoperation;

/**
 * @author Louis
 * @date Create in 2021/4/18 18:05
 */
public class LC_461_HammingDistance {
    /**
     * 题目：汉明距离
     * 推荐解法：异或运算
     * 简单解法：朴素法
     */
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

    public int hammingDistance2(int x, int y) {
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

    /** main */
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println((new LC_461_HammingDistance()).hammingDistance(x, y));
    }
}
