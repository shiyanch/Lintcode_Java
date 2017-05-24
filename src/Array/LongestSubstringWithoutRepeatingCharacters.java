package Array;

/**
 * Created by shiyanch on 12/8/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] dict = new int[256];
        int longest = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s.length()) {
            if (dict[s.charAt(right++)]++ > 0) {
                count++;
            }

            while (count > 0) {
                if (dict[s.charAt(left++)]-- > 1) {
                    count--;
                }
            }

            longest = Math.max(longest, right-left);
        }
        return longest;
    }
    public int lengthOfLongestSubstring_2(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int left = 0;
        int right = 0;
        int[] dict = new int[256];
        int longest = 0;

        while (right < s.length()) {
            while (right < s.length() && dict[s.charAt(right)] == 0) {
                dict[s.charAt(right)]++;
                right++;
            }
            longest = Math.max(longest, right-left);

            while (right < s.length() && left < right && s.charAt(left) != s.charAt(right)) {
                dict[s.charAt(left)]--;
                left++;
            }
            dict[s.charAt(left)]--;
            left++;

        }

        return longest;
    }
}
