package DSA.ArrayString;

import java.util.Arrays;

//https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();

        if (gasSum < costSum) {
            return -1;
        }

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        GasStation s = new GasStation();
        System.out.println(s.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
    }
}
