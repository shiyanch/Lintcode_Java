package Array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Given an integer array, find a subarray with sum closest to zero.
 * Return the indexes of the first number and last number.
 *
 * Example
 * Given [-3, 1, 1, -3, 5],
 * return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 */
public class SubarraySumClosest {
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            res[0] = res[1] = 0;
            return res;
        }

        Map<Long, Integer> map = new HashMap<>();
        long[] sum = new long[nums.length];
        for (int i=0; i<nums.length; i++) {
            sum[i] = (i==0)?nums[i]:sum[i-1] + nums[i];
            if (map.containsKey(sum[i])) {
                res[0] = map.get(sum[i])+1;
                res[1] = i;
                return res;
            }
            map.put(sum[i], i);
        }

        Arrays.sort(sum);
        long closest = Integer.MAX_VALUE;
        for (int i = 2; i < sum.length; i++) {
            if (Math.abs(sum[i] - sum[i - 1]) < closest) {
                res[0] = map.get(sum[i]);
                res[1] = map.get(sum[i - 1]);
                closest = Math.abs(sum[i] - sum[i - 1]);
            }
        }

        Arrays.sort(res);
        res[0]++;
        return res;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/shiyanch/Documents/workspace/Lintcode/Resource/16.in"));
            String line = reader.readLine();
            String[] vStrs = line.split(",");
            int[] nums = new int[vStrs.length];
            for (int i=0; i<vStrs.length; i++) {
                nums[i] = Integer.parseInt(vStrs[i]);
            }
            int[] res = new SubarraySumClosest().subarraySumClosest(nums);
            System.out.println(res[0] + " " + res[1]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
