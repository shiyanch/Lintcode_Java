package DynamicProgramming;

/**
 * Given n items with size nums[i] which an integer array and all positive numbers, no duplicates.
 * An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
 * Each item may be chosen unlimited number of times
 */
public class BackpackIV {

    public int backPackIV_jiuzhang(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] A = {2,2,3};
//        int[] V = {1,5,2,4,6,4,2,5,7};
        int m = 7;
        System.out.println(new BackpackIV().backPackIV_jiuzhang(A, m));
    }
}
