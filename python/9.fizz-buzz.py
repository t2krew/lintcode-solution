# 9.Fizz Buzz 问题 / fizz-buzz
# http://www.lintcode.com/problem/fizz-buzz

# 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

# 如果这个数被3整除，打印fizz.
# 如果这个数被5整除，打印buzz.
# 如果这个数能同时被3和5整除，打印fizz buzz.

# Example:
# 比如 n = 15, 返回一个字符串数组

# [
#   "1", "2", "fizz",
#   "4", "buzz", "fizz",
#   "7", "8", "fizz",
#   "buzz", "11", "fizz",
#   "13", "14", "fizz buzz"
# ]


class Solution:
  """
  @param n: An integer as description
  @return: A list of strings.
  For example, if n = 7, your code should return
    ["1", "2", "fizz", "4", "buzz", "fizz", "7"]
  """
  def fizzBuzz(self, n):
    results = []
    for i in range(1, n+1):
      if i % 15 == 0:
        results.append("fizz buzz")
      elif i % 5 == 0:
        results.append("buzz")
      elif i % 3 == 0:
        results.append("fizz")
      else:
        results.append(str(i))
    return results
