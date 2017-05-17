//407.加一 / plus-one
//http://www.lintcode.com/zh-cn/problem/plus-one/

// 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。

// 该数字按照大小进行排列，最大的数在列表的最前面。

// 样例

// 给定 [1,2,3] 表示 123, 返回 [1,2,4].

// 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].


public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            if (digits[i] >= 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int [] ans = new int[len + 1];
        ans[0] = 1;
        return ans;
    }
}