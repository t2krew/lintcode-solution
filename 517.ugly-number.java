// 517.丑数 / ugly-number
// http://www.lintcode.com/zh-cn/problem/ugly-number/

// 写一个程序来检测一个整数是不是丑数。

// 丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。

// 注意事项

// 可以认为 1 是一个特殊的丑数。

// 样例
// 给出 num = 8，返回 true。
// 给出 num = 14，返回 false。


public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return num == 1;
    }
}