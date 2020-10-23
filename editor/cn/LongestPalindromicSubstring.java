package editor.cn;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2825 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int len = s.length();
        if (len<2){
            return s;
        }
        int x=0, y=0, max=1;
        int[][] dp = new int[len][len];
        for (int i =0;i<len;i++){
            dp[i][i] = 1;
        }
        for (int j=1; j<len ; j++){
            for (int i=j-1;i>=0;i--){
                if (c[i] != c[j]){
                    dp[i][j] = 0;
                }else {
                    // System.out.println(c[i] +" "+ c[j] +" "+ (j-i<3)+" "+ (dp[i+1][j-1] == 1) +" "+max +" "+(j-i+1));
                    if (j-i<3){
                        dp[i][j] = 1;
                    }else if(dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                    }
                }

                if (dp[i][j] == 1 && j-i+1 > max ){
                    max = j-i+1;
                    x=i;
                    y=j;
                }
            }
        }

        String result = s.substring(x,y+1);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}