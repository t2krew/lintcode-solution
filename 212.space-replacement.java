// 212.空格替换 / space-replacement
// http://www.lintcode.com/zh-cn/problem/space-replacement/

// 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。

// 你的程序还需要返回被替换后的字符串的长度。

// 注意事项

// 如果使用 Java 或 Python, 程序中请用字符数组表示字符串。

// 样例
// 对于字符串"Mr John Smith", 长度为 13

// 替换空格之后，参数中的字符串需要变为"Mr%20John%20Smith"，并且把新长度 17 作为结果返回。


public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i< length; i++) {
            if (string[i] == ' ') {
                count ++;
            }
        }
        
        int j = length + 2 * count;  
        for (int i = length; i >= 0; i--)  
        {  
            if (string[i] == ' ')  
            {  
                string[j--] = '0';  
                string[j--] = '2';  
                string[j--] = '%';  
            } else  
            {  
                string[j--] = string[i];  
            }  
        }
        return length + 2 * count;
    }
}