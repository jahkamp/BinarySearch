/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author newfrontier2
 */
public class BinarySearch {

    static int slength = 3;

    static int[] randomIntArray(int size) {
        int[] array = new int[size];
        Random r = new Random();
        array[0] = 0;
        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] + r.nextInt(10);
        }
        return array;
    }

    static String generateRandomString(int length) {
        Random r = new Random();
        String result = "";
        for (int i = 0; i < length; i++) {
            char next = (char) ((int) 'a' + r.nextInt(25));
            result += next;

        }
        return result;
    }

    static String[] randomStringArray(int size) {
        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            array[i] = generateRandomString(slength);
        }
        return array;
    }

    static int binarySearchIntValue(int[] array, int searchVal, int lower, int upper) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (array[mid] == searchVal) {
            return mid;
        } else if (array[mid] > searchVal) {
            return binarySearchIntValue(array, searchVal, lower, mid - 1);
        } else {
            return binarySearchIntValue(array, searchVal, mid + 1, upper);
        }

    }

    static int binarySearchStrings(String[] array, String searchVal, int lower, int upper) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (array[mid].compareTo(searchVal) == 0) {

            return mid;
        } else if (array[mid].compareTo(searchVal) > 0) {
            return binarySearchStrings(array, searchVal, lower, mid - 1);
        } else {
            return binarySearchStrings(array, searchVal, mid + 1, upper);
        }

    }

    static int linearSearchStrings(String[] array, String searchVal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(searchVal) == 0) {
                return i;
            }
        }
        return -1;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] array = randomIntArray(100);
        //       int slength = 6;
//        for(int i =0; i<array.length; i++){
//        System.out.println(array[i]);
//        }
        //  System.out.println("binarySearch " + array[array.length-1] + " returns " + binarySearchIntValue(array, array[array.length-1], 0, array.length-1));
        String[] sarray = randomStringArray(10000);
        Arrays.sort(sarray);

//    for(int i=0; i<sarray.length; i++){
//        System.out.println(i + ": " + sarray[i]);
//    }
        int numBiTrials = 10000;

        for (int n = 100000; n <= 100000; n += 10000) {
            String[] testArray = randomStringArray(n);
            Arrays.sort(testArray);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numBiTrials; i++) {
                String randomString = generateRandomString(slength);
                binarySearchStrings(testArray, randomString, 0, testArray.length - 1);
                // System.out.println("binarySearch " + randomString + " returns " + binarySearchStrings(sarray, randomString, 0, sarray.length - 1));
            }
            long endTime = System.currentTimeMillis();
            System.out.print("elapsed time = " + (double)(endTime - startTime)/numBiTrials);        
        
        //at this point, binary search should be compiled

        for (int i = 0; i < numBiTrials; i++) {
            String randomString = generateRandomString(slength);
            binarySearchStrings(testArray, randomString, 0, testArray.length - 1);
        }
        //at this point, binary search should be compiled
        startTime = System.currentTimeMillis();
        int numLinTrials = 10;
        for (int i = 0; i < numLinTrials; i++) {
            String randomString = generateRandomString(slength);
            linearSearchStrings(testArray, randomString);
            // System.out.println("binarySearch " + randomString + " returns " + binarySearchStrings(sarray, randomString, 0, sarray.length - 1));
        }
        endTime = System.currentTimeMillis();

        System.out.println("\t elapsed time = " + (double)(endTime - startTime)/numLinTrials);
    }
    }
}
