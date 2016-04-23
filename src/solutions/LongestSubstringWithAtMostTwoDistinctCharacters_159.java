package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 *
 * Given a string, find the length of the longest substring T that
 * contains at most 2 distinct characters.
 *
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return lengthOfLongestSubstringKDistinct(s, 2);
    }

    private int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); ++right) {
            char ch = s.charAt(right);
            int cnt = 1;
            if (map.containsKey(ch)) cnt += map.get(ch);
            map.put(ch, cnt);
            while (map.size() > k) {
                char chl = s.charAt(left);
                int cntl = map.get(chl);
                --cntl;
                ++left;
                if (cntl == 0) {
                    map.remove(chl);
                } else {
                    map.put(chl, cntl);
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}