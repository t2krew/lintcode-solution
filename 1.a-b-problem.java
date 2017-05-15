// 1.A + B 问题/a-b-problem
// http://www.lintcode.com/zh-cn/problem/a-b-problem/


// 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。

// 说明
// a和b都是 32位 整数么？

// 是的
// 我可以使用位运算符么？

// 当然可以
// 样例
// 如果 a=1 并且 b=2，返回3


//解法1:
public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        if (b == 0) {
            return a;
        } else {
            return aplusb(a^b, (a&b)<<1);
        }
    }
};



//解法2:
public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        int c=0;
        while(true) {
            if (b == 0){
                return a;
            } else {
                c = a;
                a = a^b;
                b = (c&b)<<1;
            }
        }
    }
};


// 解法3:
public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        return a-(-b);
    }
};