class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ws = 0;
        for(int i = 0; i < k; i++)
        {
            ws += nums[i];
        }
        double avg = ws / k;
        double max = avg;
        for(int i = k; i < nums.length; i++)
        {
            ws += nums[i];
            ws -= nums[i-k];

            avg = ws / k;

            max = Math.max(max,avg);
        }
        return max;
    }
}