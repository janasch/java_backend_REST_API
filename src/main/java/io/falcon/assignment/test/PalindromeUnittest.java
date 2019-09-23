package io.falcon.assignment.test;

import io.falcon.assignment.util.PalindromeHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeUnittest {

    @Test
    public void testPalindromeHelper(){

        assertEquals(4, PalindromeHelper.calculatePalindrome("abba"));
        assertEquals(5, PalindromeHelper.calculatePalindrome("uieMadamopl"));
        assertEquals(5, PalindromeHelper.calculatePalindrome("qwert radar "));

    }


}
