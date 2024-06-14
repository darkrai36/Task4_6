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
        int first = firstNonFixedIndex(fixed);
        int last = lastNonFixedIndex(fixed);
        if (first != last) {
            for (int i = last; i >= 0; i--) {
                for (int j = first; j < i; j++) {
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
    private static int lastNonFixedIndex(boolean[] fixed) {
        int res = -1;
        for (int i = fixed.length - 1; i >= 0; i--) {
            if (!fixed[i]) {
                res = i;
                break;
            }
        }
        return res;
    }
    private static int firstNonFixedIndex(boolean[] fixed) {
        int res = fixed.length;
        for (int i = 0; i < fixed.length; i++) {
            if (!fixed[i]) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}