/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (41.30%)
 * Total Accepted:    2.5K
 * Total Submissions: 6.1K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例:
 * 
 * 
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
        if(s.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; ) {
            if(i < len && (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') ||
                    s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                while(i < len && ((s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') ||
                        s.charAt(i) <= 'z' && s.charAt(i) >= 'a')) {
                    result.append(s.charAt(i));
                    i++;
                }
            }
            if(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int count = 0;
                while (s.charAt(i) != '[') {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
                int j = i + 1;
                int leftCount = 1;
                while(leftCount != 0) {
                    if(s.charAt(j) == '[')
                        leftCount++;
                    if(s.charAt(j) == ']')
                        leftCount--;
                    j++;
                }
                String transformResult = decodeString(s.substring(i+1, j-1));
                for(int k = 0; k < count; k++)
                    result.append(transformResult);
                i = j;
            }
        }
        return result.toString();
    }
}

