package ru.vsu.cs.sis.task4.logic;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Integer[] arr = {7, 10, 3, 8, 7, 2, 1, 9, 5, 7};
        Integer[] arr2 = {1, 2, 3, 4, 5};
        Integer[] data = {9, 6, 5, 36, 7, 2, 5, 1, 10, 111, 13, 5, 7, 19};
        boolean[] fixedData = {false, true, false, true, true, true, true, true, false, false, true, false, false, false};
        boolean[] fixed2 = {true, true, false, true, true};
        boolean[] fixed = {false, true, false, false, true, true, false, false, true, false};
        BubbleSort.sortModified(arr, fixed);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
    private static Integer[] randomArr(int bound) {
        Integer[] res = new Integer[bound];
        Random rnd = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt(1238);
        }
        return res;
    }
}