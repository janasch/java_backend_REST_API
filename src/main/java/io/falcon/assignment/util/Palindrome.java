package io.falcon.assignment.util;

/**
 * Manacher Algorithm to find length of longest palindrom substring in content String.
 * Source: https://algs4.cs.princeton.edu/53substring/Manacher.java.html
 */

public final class Palindrome {

        public static int calculatePalindrome(String s) {
            // Preprocess
            char[] t = new char[s.length() * 2 + 3];
            t[0] = '$';
            t[s.length() * 2 + 2] = '@';
            for (int i = 0; i < s.length(); i++) {
                t[2 * i + 1] = '#';
                t[2 * i + 2] = s.charAt(i);
            }
            t[s.length() * 2 + 1] = '#';

            // Old Constructor
            int maxPal = -1;
            int[] p = new int[t.length];

            int center = 0, right = 0, currMax = 0;
            for (int i = 1; i < t.length - 1; i++) {
                int mirror = 2 * center - i;

                if (right > i)
                    p[i] = Math.min(right - i, p[mirror]);

                // attempt to expand palindrome centered at i
                while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                    p[i]++;

                // if palindrome centered at i expands past right,
                // adjust center based on expanded palindrome.
                if (i + p[i] > right) {
                    center = i;
                    right = i + p[i];
                }

                if (p[i] > currMax) {
                    currMax = p[i];
                    maxPal = currMax;
                }
            }

            return maxPal;
        }
}
