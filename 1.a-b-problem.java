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
    // 主要利用异或运算来完成 
    // 异或运算有一个别名叫做：不进位加法
    // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
    // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
    // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
    // 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
    // 令a' = a ^ b, b' = (a & b) << 1
    // 可以知道，这个过程是在模拟加法的运算过程，进位不可能
    // 一直持续，所以b最终会变为0。因此重复做上述操作就可以
    // 求得a + b的值。
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