// 46.majority-number / 主元素
// http://www.lintcode.com/zh-cn/problem/majority-number/

// 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。

// 样例
// 给出数组[1,1,1,1,2,2,2]，返回 1

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            return 0;
        }
        int counter = 0;
        int num = nums.get(0);
        for(int i=0; i < nums.size(); i++) {
            if (counter == 0) {
                num = nums.get(i);
                counter++;
            } else if (num == nums.get(i)) {
                counter++;
            } else {
                counter--;
            }
            
        }
        return num;
    }
}