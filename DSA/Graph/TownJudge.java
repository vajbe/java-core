// https://leetcode.com/problems/find-the-town-judge/description/?envType=problem-list-v2&envId=graph
package DSA.Graph;

public class TownJudge {

    int findJudge(int n, int trusts[][]) {
        if (n == 1 && trusts.length == 0)
            return 1;

        int[] outDegree = new int[n + 1];
        int[] inDegree = new int[n + 1];

        for (int[] relation : trusts) {
            int a = relation[0];
            int b = relation[1];

            outDegree[a]++;
            inDegree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TownJudge judge = new TownJudge();
        int[][] arr = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        System.out.println(judge.findJudge(3, arr));
    }
}
