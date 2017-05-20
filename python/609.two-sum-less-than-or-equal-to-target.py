# 609.两数之和 / Two Sum - Less than or equal to target
# http://www.lintcode.com/zh-cn/problem/two-sum-less-than-or-equal-to-target/

# Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

# 样例
# Given nums = [2, 7, 11, 15], target = 24. 
# Return 5. 
# 2 + 7 < 24
# 2 + 11 < 24
# 2 + 15 < 24
# 7 + 11 < 24
# 7 + 15 < 25


class Solution:
    # @param nums {int[]} an array of integer
    # @param target {int} an integer
    # @return {int} an integer
    def twoSum5(self, nums, target):
        # Write your code here
        pairs = 0
        if len(nums) < 2 or target is None:
            return pairs
        nums.sort(cmp)
        i = 0
        j = len(nums) - 1
        while(i < j) :
            if nums[i] + nums[j] <= target:
                pairs += (j - i)
                i = i + 1
            else:
                j = j - 1
        return pairs