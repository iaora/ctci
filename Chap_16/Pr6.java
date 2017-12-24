/*
 * Smallest Difference: Given two arrays of integers, compute the pair of values (one value in each array)
 * with the smallest (non-negative) difference. Return the difference.
 */

import java.util.Arrays;

public class Pr6{
    public static void main(String[] args){
        int[] arr1 = {1,3,15,11,2};
        int[] arr2 = {23,127,235,19,8};

        findSmallestDiff(arr1, arr2);

    }

    private static void findSmallestDiff(int[] arr1, int[] arr2){
        Arrays.sort(arr1); // O(m logm)
        Arrays.sort(arr2); // O(n log n)

        int index1 = 0;
        int index2 = 0;
        int diff = Integer.MAX_VALUE;

        // Iterate through both arrays to find the one with the smallest difference
        while(index1 < arr1.length && index2 < arr2.length){
            // Check difference
            if( Math.abs(arr1[index1] - arr2[index2]) < diff )
                diff = Math.abs(arr1[index1] - arr2[index2]);

            // Increase index to check
            if( arr1[index1] < arr2[index2] )
                index1++;
            else
                index2++;
        }
        System.out.println("Diff: " + diff);
        return;
    }
}
