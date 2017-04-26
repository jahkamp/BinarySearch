/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Random;

/**
 *
 * @author bmumey
 */
public class BinarySearchString {

    static int[] randomIntArray(int size) {
        int[] array = new int[size];
        Random r = new Random();
        array[0] = 0;
        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] + r.nextInt(10);
        }
        return array;
    }

    static int binarySearch(int[] array, int searchVal, int lower, int upper) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (array[mid] == searchVal) {
            return mid;
        } else if (array[mid] > searchVal) {
            return binarySearch(array, searchVal, lower, mid - 1);
        } else {
            return binarySearch(array, searchVal, mid + 1, upper);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] array = randomIntArray(100000);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        long totalTime = 0;
        long startTime = 0;
        int trials = 0;
        while (totalTime < 1) {
            startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
        }
        totalTime = 0;
        startTime = 0;
        while (totalTime < 1.5) {
            trials++;
            startTime = System.currentTimeMillis();
        System.out.println("binarySearch " + array[array.length - 1] + " returns "
                + binarySearch(array, array[array.length - 1], 0, array.length - 1));
            long endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
        }
        System.out.println("Total BinarySearch Elapsed Time : " + totalTime + " milliseconds, which took " + trials + " trials.");
        
        totalTime = 0;
        startTime = 0;
        while (totalTime < 1.5) {
            trials++;
            startTime = System.currentTimeMillis();
//        System.out.println("linearSearch " + array[array.length - 1] + " returns "
//                + linearSearch(array, array[array.length - 1], 0, array.length - 1));
//            long endTime = System.currentTimeMillis();
//            totalTime = endTime - startTime;
        }
        System.out.println("Total LinearSearch Elapsed Time : " + totalTime + " milliseconds, which took " + trials + " trials.");
    }

}
