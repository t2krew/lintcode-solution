# 82.落单的数 / single-number
# http://www.lintcode.com/problem/single-number

# 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。

# 给出 [1,2,2,1,3,4,3]，返回 4


class Solution:
    """
    @param A : an integer array
    @return : a integer
    """
    def singleNumber(self, A):
        # write your code here
        if A is None or len(A) == 0:
            return 0
        ans = A[0]
        for i in range(1, len(A)):
            ans ^= A[i]
        return ans