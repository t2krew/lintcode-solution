# 46.majority-number / 主元素
# http://www.lintcode.com/zh-cn/problem/majority-number/

# 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。

# 样例
# 给出数组[1,1,1,1,2,2,2]，返回 1


class Solution:
    """
    @param nums: A list of integers
    @return: The majority number
    """
    def majorityNumber(self, nums):
        # write your code here
        counter = 0
        num = nums[0]
        for n in nums:
            if counter == 0:
                num = n
                counter += 1
            elif num == n:
                counter += 1
            else:
                counter -= 1
        return num