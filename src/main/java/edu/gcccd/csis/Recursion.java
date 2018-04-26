package edu.gcccd.csis;

public class Recursion {
    /*
     * Recursive method to output every other element in the given array backwards,
     * ending with the element at index k.
     * An example input array {1,2,3,4,5,6,7,8,9,10}, called with k=2, should output 9753
     */
    static String result = "";
    static String printEveryOther(final int[] ia, final int k) {
        if (ia.length == 0 )
        {
            throw new IllegalArgumentException("ARRAY MUST NOT BE EMPTY");
        }
        else if (ia == null)
        {
            throw new NullPointerException("ARRAY REFERENCE MUST NOT BE NULL");
        }
        else if (ia.length < k)
        {
            throw new IllegalArgumentException("INDEX k MUST BE LESS THAN " + ia.length);
        }
        else if (k < 0)
        {
            throw new IllegalArgumentException("INDEX k CANNOT BE NEGATIVE");
        }
        else if (ia.length - 1 > k)
        {
            printEveryOther(ia, k + 2); // recurse
            result += String.valueOf(ia[k]);
        }
        return result;

    }




    /*
     * Recursively take in a string and place a * between adjacent letters that are the same
     * An example input String "hello" should return hel*lo.
     */
    static String printStars(final String s) {


        if (s == null)
        {
            throw new NullPointerException("STRING REFERENCE MUST NOT BE NULL");
        }

        else if (s.length() <= 1 )
        {
            return s;
        }

        if (s.charAt(1) == s.charAt(0)) // if adjacent characters are the same
        {
            return s.charAt(0)+ "*" + printStars(s.substring(1)); // add star and recurse
        }

        else
        {
            return s.charAt(0) + printStars(s.substring(1));    // otherwise just recurse
        }

    }

    /*
     * Recursively computes the sum of the 1st k positive numbers.
     * An example input 4 should return 10.
     */
    static int sum(int k) {
        return k > 0 ? k + sum(k - 1) : 0;
    }

    public static void main(String[] args) {
        System.out.println(printEveryOther(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2));
        System.out.println(printStars("Hellloo"));
        System.out.println(sum(4));
    }
}