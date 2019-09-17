package io.falcon.assignment.services;

import org.springframework.stereotype.Service;

/**
 * Manacher Algorithm to find length of longest palindrom substring in content String.
 * Source: https://algs4.cs.princeton.edu/53substring/Manacher.java.html
 */

//@Service
public class MessageService {


        private int[] p;  // p[i] = length of longest palindromic substring of t, centered at i
        private String s;  // original string
        private char[] t;  // transformed string
        private int maxPal; //length of max Palindrome

        public MessageService(String s) {
            this.s = s;
            preprocess();
            p = new int[t.length];

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

                if (p[i] > currMax){
                    currMax = p[i];
                    maxPal = currMax;
                }
            }

        }

        public int getLongestPalindromeLength(){
            return this.maxPal;
        }

        // Transform s into t.
        private void preprocess() {
            t = new char[s.length() * 2 + 3];
            t[0] = '$';
            t[s.length() * 2 + 2] = '@';
            for (int i = 0; i < s.length(); i++) {
                t[2 * i + 1] = '#';
                t[2 * i + 2] = s.charAt(i);
            }
            t[s.length() * 2 + 1] = '#';
        }

        // longest palindromic substring, helper method for debugging
        public String longestPalindromicSubstring() {
            int length = 0;   // length of longest palindromic substring
            int center = 0;   // center of longest palindromic substring
            for (int i = 1; i < p.length - 1; i++) {
                if (p[i] > length) {
                    length = p[i];
                    center = i;
                }
            }
            return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
        }
}
