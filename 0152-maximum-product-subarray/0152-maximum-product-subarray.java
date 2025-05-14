class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = Math.min(nums[i], Math.min(nums[i]*min, nums[i]*max));
            max = Math.max(nums[i], Math.max(nums[i]*min, nums[i]*max));
            min = temp;
            ans = Math.max(ans, max); 
        }
        return ans;
    }
}