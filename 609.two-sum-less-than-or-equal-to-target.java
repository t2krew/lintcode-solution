// 609.两数之和 / Two Sum - Less than or equal to target
// http://www.lintcode.com/zh-cn/problem/two-sum-less-than-or-equal-to-target/

// Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

// 样例
// Given nums = [2, 7, 11, 15], target = 24. 
// Return 5. 
// 2 + 7 < 24
// 2 + 11 < 24
// 2 + 15 < 24
// 7 + 11 < 24
// 7 + 15 < 25


public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        int pairs = 0;
        if (nums == null || nums.length < 2) {
            return pairs;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            // nums[i]的所有组合 = j - i
            if (nums[i] + nums[j] <= target) {
                pairs += j - i;
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }
}