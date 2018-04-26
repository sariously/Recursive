package edu.gcccd.csis;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void printEveryOther() {

        // test that the correct sequence is returned when ia.length is > 0
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        int k = 2;
        assertEquals("9753", Recursion.printEveryOther(test, k));



       // test that an exception is thrown when ia is NULL
        test = null;
        boolean thrown = false;
        try {
            Recursion.printEveryOther(test, k);
            fail();
        } catch (NullPointerException e) {
            thrown = true;
        }

        assertTrue(thrown);


        // test that an exception is thrown when ia is EMPTY
        test = new int[] {};
        thrown = false;
        try {
            Recursion.printEveryOther(test, k);
            fail();
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);


        // test that an exception is thrown when k > ia.length
        test = new int[] {0};
        thrown = false;
        try {
            Recursion.printEveryOther(test, k);
            fail();
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);


        // test that an exception is thrown when k < 0
        k = -1;
        thrown = false;
        try {
            Recursion.printEveryOther(test, k);
            fail();
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);


    }



    @Test
    public void printStars() {
        assertEquals("Hel*l*lo*o", Recursion.printStars("Hellloo"));

        // test that empty string returns the empty string
        assertEquals("", Recursion.printStars(""));

        // Strings composed of a single character should return the same string
        assertEquals("o", Recursion.printStars("o"));

        // Spaces are characters. A star should be inserted between two adjacent spaces
        assertEquals(" * ", Recursion.printStars("  "));

        // test that an exception is thrown when String argument s is NULL
        boolean thrown = false;
        try {
            Recursion.printStars(null);
            fail();
        } catch (NullPointerException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    /*
     * we know the sum of the 1st k positive numbers is n(n+1)2
     */
    @Test
    public void sum() {
        for (int i = 0; i < 10; i++) {
            int k = new Random().nextInt(100);
            assertEquals(k * (k + 1) / 2, Recursion.sum(k));
        }
        // corner cases
        assertEquals(0, Recursion.sum(-1));
        assertEquals(0, Recursion.sum(0));
        try {
            int x = Recursion.sum(Integer.MAX_VALUE); // stackoverflow
            fail();
        } catch (StackOverflowError error) {
            assertTrue(true);
        }
    }
}