package editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4495 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        System.err.println(solution.longestPalindrome(s));
        
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