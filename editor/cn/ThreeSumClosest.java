package editor.cn;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 611 👎 0

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.err.println(solution.threeSumClosest(new int[]{-1,2,1,-4},1));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0,j = len-1;
        HashMap<Integer,Integer> map = new HashMap();
        while (i != j){
            for (int k = i+1; k<j; k++){
                int n = nums[i] + nums[k] + nums[j];
                System.err.println(i+" "+k+" "+j + " " +min);
                if (Math.abs(target - n) < min){
                    min = Math.abs(target - n);
                    System.err.println("min");
                    map.put(min,nums[i] + nums[j] + nums[k]);
                }
                if (n > target){
                    System.err.println("j--");
                    j--;
                }else if (n < target){
                    System.err.println("i++");
                    i++;
                }else if (target - n == 0){
                    System.err.println("equal");
                    return nums[i] + nums[j] + nums[k];
                }
            }

        }
        return map.get(min);
    }

}*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}