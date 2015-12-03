public class Solution {
    // Given an array of integers, every element appears three 
    // times except for one. Find that single one.

    // Note:
    // Your algorithm should have a linear runtime complexity. 
    // Could you implement it without using extra memory?

    // bitwise solution: O(n) time, O(1) space
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;
        int one = 0, two = 0, three = 0;
        for (int n : A) {
            two |= one & n;
            one ^= n;
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
    
    // construct target number bit by bit:
    // O(n) time, O(1) space
    // This solution can be generalized to solve a more general problem: 
    // Given an array of integers, every element appears exactly N times
    // except for one, find that one. 
    public int singleNumber2(int[] A) {
        if (A == null || A.length == 0) return -1;
        int ret = 0;
        for (int i = 0; i < 32; ++i) {
            int bitCount = 0;
            for (int n : A) {
                // Here should prefer ((n >> i) & 1) > 0 rather than (n & (1 << i)) > 0
                // since >> (arithmetic shift right) preserves the signedness of number
                // and the test cases contain negative numbers. If we don't need to
                // consider the signedness then the two notations are equivalent.
                if (((n >> i) & 1) > 0) {
                    bitCount = (bitCount + 1) % 3;
                }
            }
            ret |= bitCount << i;
        }
        return ret;
    }
}