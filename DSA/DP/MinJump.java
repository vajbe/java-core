package DSA.DP;

public class MinJump {

    int farthest = 0;
    int currentEnd = 0;
    int jumps = 0;

    public int jump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                currentEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }

    public static void main(String args[]) {
        System.out.println("Min Jumps -> " + new MinJump().jump(new int[] { 2, 3, 1, 1, 4 }));
    }
}
