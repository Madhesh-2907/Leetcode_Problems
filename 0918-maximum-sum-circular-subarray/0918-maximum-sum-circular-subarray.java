class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentmaxsum = nums[0];
        int maxsum = nums[0];
        int currentminsum = nums[0];
        int minsum = nums[0];

        int totalsum = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            totalsum += nums[i];

            if(i>0)
            {
                currentmaxsum = Math.max(nums[i], currentmaxsum + nums[i]);
                maxsum = Math.max(currentmaxsum, maxsum);

                currentminsum = Math.min(nums[i], currentminsum + nums[i]);
                minsum = Math.min(currentminsum, minsum);
            }
        }
        if(maxsum < 0 )
        {
            return maxsum;
        }
        int circularsum = totalsum - minsum;
        return Math.max(circularsum, maxsum);
    }
}