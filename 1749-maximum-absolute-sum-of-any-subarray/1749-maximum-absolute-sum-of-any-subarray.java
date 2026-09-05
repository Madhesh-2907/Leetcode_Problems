class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentmaxsum = 0;
        int maxsum = 0;
        int currentminsum = 0;
        int minsum = 0;

        for(int i=0; i<nums.length; i++)
        {
            currentmaxsum = Math.max(0, currentmaxsum + nums[i]);
            maxsum = Math.max(maxsum, currentmaxsum);
            currentminsum = Math.min(0, currentminsum + nums[i]);
            minsum = Math.min(minsum, currentminsum);
        }
        return Math.max(maxsum, -minsum);
    }
}