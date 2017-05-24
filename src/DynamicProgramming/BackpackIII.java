package DynamicProgramming;

/**
 * Given n kind of items with size Ai and value Vi
 * ( each item has an infinite number available) and a backpack with size m.
 *
 * What's the maximum value can you put into the backpack?
 * */
public class BackpackIII {

    public int backPackIII_jiuzhang(int[] A, int[] V, int m) {
        int[] dp = new int[m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i]) dp[j] = Math.max(dp[j], dp[j-A[i]]+V[i]); }
        }
        return dp[m]; }

    public int backpackIII(int[] A, int[] V, int m) {
        int[] dp = new int[m+1];
        for (int i=0; i<=m; i++) {
            for (int j=0; j<A.length; j++) {
                if (i >= A[j]) {
                    dp[i] = Math.max(dp[i], dp[i-A[j]] + V[j]);
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        int[] A = {2,3,5,7,3,2,4,9,2};
        int[] V = {1,5,2,4,6,4,2,5,7};
        int m = 20;

        System.out.println(new BackpackIII().backpackIII(A, V, m));
        System.out.println(new BackpackIII().backPackIII_jiuzhang(A, V, m));
    }
}
