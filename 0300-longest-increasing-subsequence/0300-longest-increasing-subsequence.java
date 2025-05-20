class Solution {
    public int solve(int[] nums, int prevIndex, int currIndex, int[][] dp){
        if(currIndex == nums.length) return 0;
        if(prevIndex != -1 && dp[prevIndex][currIndex] != -1) return dp[prevIndex][currIndex];
        int skip = solve(nums, prevIndex, currIndex + 1, dp);
        int take = 0;
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex]){
            take = 1 + solve(nums, currIndex, currIndex + 1, dp);
        }
        if(prevIndex != -1) dp[prevIndex][currIndex] = (int)Math.max(skip, take);
        return Math.max(skip, take);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, -1, 0, dp);
    }
}