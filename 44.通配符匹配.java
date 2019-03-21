/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 *
 * https://leetcode-cn.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (21.16%)
 * Total Accepted:    3.9K
 * Total Submissions: 18.4K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * 
 */
class Solution {
    private Boolean[][] cacheMap;

    private boolean allStar(String p, int startIndex) {
        for(int i = startIndex; i < p.length(); i++)
            if(p.charAt(i) != '*')
                return false;
        return true;
    }

    private boolean matchHelp(String s, String p, int i, int j) {
        if(cacheMap[i][j] != null)
            return cacheMap[i][j];
        if(i == s.length() && j == p.length() || allStar(p, j) && p.substring(j).length() != 0)
            return (cacheMap[i][j] = true);
        if(i == s.length() ^ j == p.length())
            return (cacheMap[i][j] = false);
        char sc = s.charAt(i);
        char pc = p.charAt(j);
        if(sc == pc || pc == '?')
            return (cacheMap[i+1][j+1]==null? (cacheMap[i+1][j+1]=matchHelp(s, p, i+1, j+1)):cacheMap[i+1][j+1]);
        if(pc == '*')
            return (cacheMap[i+1][j+1]==null? (cacheMap[i+1][j+1]=matchHelp(s, p, i+1, j+1)): cacheMap[i+1][j+1]) ||
                    (cacheMap[i+1][j]==null? (cacheMap[i+1][j]=matchHelp(s, p, i+1, j)): cacheMap[i+1][j]) ||
                    (cacheMap[i][j+1]==null? (cacheMap[i][j+1]=matchHelp(s, p, i, j+1)): cacheMap[i][j+1]);
        return false;
    }

    public boolean isMatch(String s, String p) {
        cacheMap = new Boolean[s.length()+1][p.length()+1];
        return matchHelp(s, p, 0, 0);
    }
}

