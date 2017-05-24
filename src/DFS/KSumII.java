package DFS;

import java.util.ArrayList;


public class KSumII {

    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.length; i++) {
            dfs(result, new ArrayList<Integer>(), i, k, target, A);
        }
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currList,
                     int start, int remain, int target, int[] A) {

//        System.out.println(start+" "+remain+" "+target);

        if (remain < 0 || start >= A.length || (remain == 0 && target != 0) ) {
            return;
        }

        if (remain == 1 && target == A[start]) {
            currList.add(A[start]);
            result.add(new ArrayList<Integer>(currList));
        }

        currList.add(A[start]);
        for (int i = start+1; i < A.length; i++) {
            dfs(result, currList, i, remain - 1, target - A[start], A);
        }
        currList.remove(currList.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,4};
        int k = 2;
        int t = 5;

        System.out.println(new KSumII().kSumII(nums, k, t).toString());
    }
}
