class Solution {
    public int solve(int[] nums, int currIndex, int prevIndex, int[][] dp){
        if(currIndex == nums.length) return 0;
        if(prevIndex != -1 && dp[prevIndex][currIndex] != -1) return dp[prevIndex][currIndex];
        int skip = solve(nums, currIndex + 1, prevIndex, dp);
        int take = 0;
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex]){
            take = 1 + solve(nums, currIndex + 1, currIndex, dp);
        }
        if(prevIndex != -1 ){
            dp[prevIndex][currIndex] = Math.max(skip, take);
            return dp[prevIndex][currIndex];
        }
        return Math.max(skip, take);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, -1, dp);
    }
}