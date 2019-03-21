/*
 * @lc app=leetcode.cn id=128 lang=cpp
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (41.94%)
 * Total Accepted:    5.2K
 * Total Submissions: 12.5K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 */
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int len = nums.size();
        map<int, bool> existed;
        map<int, bool> processed;
        for(int i = 0; i < len; i++)
            existed[nums[i]] = true;
        int max = 0;
        for(int i = 0; i < len; i++) {
            int mid = nums[i];
            if(processed[mid])
                continue;
            processed[mid] = true;
            int left, right;
            left = right = mid;
            while(existed[--left])
                processed[left] = true;
            while(existed[++right])
                processed[right] = true;
            int diff = right - left - 1;
            if(diff > max)
                max = diff;
        }
        return max;
    }
};

