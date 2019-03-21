/*
 * @lc app=leetcode.cn id=93 lang=cpp
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (42.85%)
 * Total Accepted:    5.9K
 * Total Submissions: 13.8K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */
class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        findIp(s, 4, "", res);
        return res;
    }
    
    void findIp(string source, int left, string curr, vector<string> &res) {
        if(source.size() > 12)
            return;
        if(left == 0 && source.empty()) {
            res.push_back(curr);
            return;
        }
        for(int i = 1; i <= 3; i++)
            if(isValid(source.substr(0, i)) && source.size() >= i)
                findIp(source.substr(i), left-1, curr + source.substr(0, i) + (left==1? "": "."), res);
    }
    
    bool isValid(string source) {
        if(source.empty() || source.size() > 3 || source.size() > 1 && source.at(0) == '0')
            return false;
        int res = atoi(source.c_str());
        return res <= 255 && res >= 0;
    }
};

