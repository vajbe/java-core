//https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
package DSA.DP;

public class MaxJump {
    public boolean canJump(int[] nums) {
        int canReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > canReach) {
                return false;
            }
            canReach = Math.max(canReach, i + nums[i]);
            if (canReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MaxJump jump = new MaxJump();
        System.out.println("Can jump " + jump.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println("Can jump " + jump.canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println("Can jump " + jump.canJump(new int[] { 0 }));
        System.out.println("Can jump " + jump.canJump(new int[] { 1 }));
        System.out.println("Can jump " + jump.canJump(new int[] {}));
    }
}
