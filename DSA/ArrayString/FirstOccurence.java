//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
package DSA.ArrayString;

public class FirstOccurence {
    public int strStr(String haystack, String needle) {
        int k = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(k)) {
                k++;
                if (k == needle.length()) {
                    return i - (k - 1);
                }
            } else {
                i = i - k;
                k = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstOccurence f = new FirstOccurence();
        System.out.println(f.strStr("dadisticsad", "sad"));
    }
}