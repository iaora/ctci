import java.util.Arrays;

/*
 * Number Swapper: Write a function to swap a number in place (that is,
 * without temporary variables.
 *
 */

public class Pr1{
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {4,3,2,11};
        swapXOR(arr2, 1, 3);
        System.out.println(Arrays.toString(arr2));
    }

    public static void swap(int[] arr, int index1, int index2){
        arr[index2] = Math.abs(arr[index1]- arr[index2]);
        arr[index1] += arr[index2];
        arr[index2] = arr[index1] - arr[index2];
    }

    public static void swapXOR(int[] arr, int index1, int index2){
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
