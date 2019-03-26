/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (32.38%)
 * Total Accepted:    62.9K
 * Total Submissions: 193.5K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int count = 0;
        boolean conflict = false;
        StringBuilder sb = new StringBuilder("");
        while(true) {
            if(strs[0].length() <= count)
                break;
            char c = strs[0].charAt(count);
            for(int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if(str.length() <= count || str.charAt(count) != c) {
                    conflict = true;
                    break;
                }
            }
            if(conflict)
                break;
            count++;
            sb.append(c);
        }
        return sb.toString();
    }
}

