class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = n-1; i >= 1; i--){
            if(nums[i] > nums[i-1]){
                index = i-1;
                break;
            }
        }

        if(index == -1){
            int low = 0;
            int high = n-1;
            while(low < high){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
            return;
        }

        for(int i = n - 1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        int low = index + 1;
        int high = n - 1;
        while(low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        return;
    }
}