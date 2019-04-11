import java.util.Map;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (20.07%)
 * Total Accepted:    6.3K
 * Total Submissions: 31.3K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */
class Solution {
    Map<String, Integer> cache = new HashMap();
    public int numDecodings(String s) {
        if(s.startsWith("0"))
            return 0;
        if(s.length() == 0 || s.length() == 1)
            return 1;
        if(cache.containsKey(s))
            return cache.get(s);
        int way1 = numDecodings(s.substring(1));
        int way2 = 0;
        if((s.charAt(0) - '0') * 10 + s.charAt(1) - '0' <= 26)
            way2 = numDecodings(s.substring(2));
        cache.put(s, way1 + way2);
        return way1 + way2;
    }
}

