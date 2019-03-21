/*
 * @lc app=leetcode.cn id=99 lang=cpp
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (51.30%)
 * Total Accepted:    2.4K
 * Total Submissions: 4.7K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 
 * 请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * 输出: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * 输出: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 进阶:
 * 
 * 
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    public:
    int last = 0;
    TreeNode* lastNode;
    void recoverTree(TreeNode* root) {
        last = INT_MIN;
        TreeNode* left = leftStart(root);
        last = INT_MAX;
        TreeNode* right = rightStart(root);
        int tmp = left->val;
        left->val = right->val;
        right->val = tmp;
    }
    
    TreeNode* leftStart(TreeNode* root) {
        if(!root)
            return NULL;
        TreeNode* left = leftStart(root->left);
        if(root->val < last)
            return lastNode;
        last = root->val;
        lastNode = root;
        TreeNode* right = leftStart(root->right);
        return (TreeNode*) ((long) left | (long) right);
    }
    
    TreeNode* rightStart(TreeNode* root) {
        if(!root)
            return NULL;
        TreeNode* right = rightStart(root->right);
        if(root->val > last)
            return lastNode;
        last = root->val;
        lastNode = root;
        TreeNode* left = rightStart(root->left);
        return (TreeNode*) ((long) left | (long) right);
    }
};

