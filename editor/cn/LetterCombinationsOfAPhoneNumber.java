package editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 966 👎 0

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.bind.v2.runtime.output.ForkXmlOutput;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.err.println(solution.letterCombinations("23"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //dfs
    class Solution {
        char[][] num2chars = new char[10][];
        {
            num2chars[2] = new char[]{'a', 'b', 'c'};
            num2chars[3] = new char[]{'d', 'e', 'f'};
            num2chars[4] = new char[]{'g', 'h', 'i'};
            num2chars[5] = new char[]{'j', 'k', 'l'};
            num2chars[6] = new char[]{'m', 'n', 'o'};
            num2chars[7] = new char[]{'p', 'q', 'r','s'};
            num2chars[8] = new char[]{'t', 'u', 'v'};
            num2chars[9] = new char[]{'w', 'x', 'y', 'z'};
        }

        int length;
        List<String> result = new LinkedList<>();
        public List<String> letterCombinations(String digits) {
            if ("".equals(digits)){
                return result;
            }
            length = digits.length();

            dfs("",digits,0);
            return result;
        }

        void dfs(String s, String digits, int index){
            if (index == length){
                result.add(s);
                return;
            }
            int x = digits.charAt(index)-'0';
            for (int y=0;y<num2chars[x].length;y++) {
                dfs(s+num2chars[x][y],digits,index+1);
            }
            return;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}