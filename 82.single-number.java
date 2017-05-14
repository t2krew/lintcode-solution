// 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。

// 给出 [1,2,2,1,3,4,3]，返回 4


public class Solution {
  /**
    *@param A : an integer array
    *return : a integer 
    */
  public int singleNumber(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    // Write your code here
    int ans = A[0];
    for (int i = 1; i < A.length; i++) {
      ans ^= A[i];
    }
    return ans;
  }
}