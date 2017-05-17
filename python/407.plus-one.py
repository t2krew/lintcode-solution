# 407.加一 / plus-one
# http://www.lintcode.com/zh-cn/problem/plus-one/

# 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。

# 该数字按照大小进行排列，最大的数在列表的最前面。

# 样例

# 给定 [1,2,3] 表示 123, 返回 [1,2,4].

# 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].


class Solution:
    # @param {int[]} digits a number represented as an array of digits
    # @return {int[]} the result
    def plusOne(self, digits):
        # Write your code here
        l = len(digits)
        for i in range(l-1, -1,-1):
            if digits[i] >= 9:
                digits[i] = 0
            else:
                digits[i] = digits[i] + 1
                return digits
        digits.insert(0, 1)
        return digits
            