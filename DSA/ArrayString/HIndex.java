// https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
package DSA.ArrayString;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); 
        for (int i = 1; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex h = new HIndex();
        System.out.println(h.hIndex(new int[] { 3, 0, 6, 1, 5 })); // 0,1,3,5,6
        System.out.println(h.hIndex(new int[] { 1, 3, 1 }));
    }
}
