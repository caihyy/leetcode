package editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1521 👎 0

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.err.println(solution.generateParenthesis(5));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max;
        int right;
        List<String> result = new LinkedList<>();
        public List<String> generateParenthesis(int n) {
            max = n;
            dfs("",0,0);
            return result;
        }

        void dfs(String s, int r,int l){
            if (s.length() == max*2){
                result.add(s);
                return;
            }
            if (r<max){
                dfs(s+"(",r+1,l);
            }

            if (l<r){
                dfs(s+")",r,l+1);
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}