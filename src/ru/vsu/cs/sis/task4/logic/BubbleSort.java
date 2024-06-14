package ru.vsu.cs.sis.task4.logic;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1, data);
                }
            }
        }
    }
    private static <T> void swap(int i1, int i2, T[] data) {
        T tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }
    public static <T extends Comparable<T>> void sortModified(T[] data, boolean[] fixed) throws Exception {
        if (data.length == 0) {
            throw new NullPointerException("Array is empty!");
        }
        if (fixed.length != data.length) {
            throw new IndexOutOfBoundsException("Длины массивов должны быть равны!");
        }
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (!fixed[j]) {
                    for (int k = j + 1; k <= i; k++) {
                        if (!fixed[k]) {
                            if (data[j].compareTo(data[k]) > 0) {
                                swap(j, k, data);
                            }
                        }
                    }
                }
            }
        }
    }
}
//[7, 2, 8, 1, 4]