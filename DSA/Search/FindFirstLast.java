//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
package DSA.Search;

public class FindFirstLast {

    int findFirstIndex(int[] input, int ele) {
        int left = 0, right = input.length - 1, first = -1;
        while (left <= right && input.length > 0) {
            int mid = (left + right) / 2;
            if (input[mid] == ele) {
                first = mid;
                right = mid - 1;
            } else if (input[mid] > ele) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    int findLastIndex(int[] input, int ele) {
        int left = 0, right = input.length - 1, last = -1;
        while (left <= right && input.length > 0) {
            int mid = (left + right) / 2;
            if (input[mid] == ele) {
                last = mid;
                left = mid + 1;
            } else if (input[mid] < ele) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstIndex(nums, target);
        ans[1] = findLastIndex(nums, target);
        return ans;
    }

    public static void main(String[] args) {
        FindFirstLast f = new FindFirstLast();
        f.searchRange(new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 5 }, 2);
        f.searchRange(new int[] {}, 2);
    }
}