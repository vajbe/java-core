package DSA.ArrayString;

//https://leetcode.com/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-interview-150
public class MaxSumArray {
    public static int maxSubArray(int[] nums) {
        int i = 0;
        int maxsum = -Integer.MAX_VALUE;
        int currSum = 0;
        while (i < nums.length) {
            currSum += nums[i];
            if (currSum > maxsum) {
                maxsum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
            i++;
        }
        return maxsum;
    }

    public static void main(String[] args) {
        // int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] nums = { 5, 4, -1, 7, 8 };
        System.out.println("Maximum sum is: " + maxSubArray(nums));
    }
}
