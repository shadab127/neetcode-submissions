class Solution {
    public int rob(int[] nums) {
        int maxProfit = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            maxProfit = Math.max(maxProfit, maxProfit(nums,i, dp));
        }
        return maxProfit;
    }
    public int maxProfit(int[] nums, int curr, int[] dp){
        if(dp[curr] != -1) return dp[curr];
        int profit = nums[curr];
        for(int i=curr+2;i<nums.length;i++){
            profit = Math.max(profit, nums[curr]+maxProfit(nums, i, dp));
        }
        dp[curr] = profit;
        return dp[curr];
    }
}
