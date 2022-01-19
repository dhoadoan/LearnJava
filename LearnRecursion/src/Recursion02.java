/*
Given a string with only characters '1', '0', and '*'.
Where a '*' can be either 0 or 1. Write a function that takes in the string and
prints out all the possible digits by replacing those '*' by either '0' or '1'
* */

import java.util.Arrays;

public class Recursion02 {
    public static void main(String[] args) {
        String[] arr = {"1", "*", "*", "*", "0", "1"};
        String[] arr1 = {"*", "0", "*", "*", "*", "1"};
        String[] arr2 = {"*", "*", "*", "*", "*", "*"};
        String[] arr3 = {"0", "*", "*", "*", "*", "*"};
        String[] arr4 = {"*", "*", "*", "*", "*", "1"};
        String[] arr5 = {"*", "0", "1", "1", "*", "*"};


        replaceDigits(arr3);
    }

    public static void replaceDigits(String[] arr) {
        backTrack(0, arr);
    }

    private static void backTrack(int index, String[] arr) {
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        if (arr[index].equals("*")){
            for (int value = 0; value < 2; value++){
                arr[index] = value + "";
                backTrack(index + 1, arr);
                arr[index] = "*";
            }
        } else {
            backTrack(index + 1, arr);
        }
    }
}
