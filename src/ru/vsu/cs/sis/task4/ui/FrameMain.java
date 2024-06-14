package ru.vsu.cs.sis.task4.ui;

import ru.vsu.cs.sis.task4.logic.BubbleSort;
import ru.vsu.cs.sis.task4.util.JTableUtils;
import ru.vsu.cs.sis.task4.util.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable inputTable;
    private JTable outputTable;
    private JButton bubbleSortButton;

    public FrameMain() {
        this.setTitle("Task 4_6");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(inputTable, 45, true, true, false, true);
        JTableUtils.initJTableForArray(outputTable, 45, true, true, false, false);

        inputTable.setRowHeight(25);
        outputTable.setRowHeight(25);

        JTableUtils.writeArrayToJTable(inputTable, new int[][]{{9,6,5,36,7,2,5,1,10,111,13,5,7,19}, {0,1,1,0,1,0,1,0,1,1,1,1,1,0}});

        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] matrix = JTableUtils.readIntMatrixFromJTable(inputTable);
                    Integer[] arr = convertToIntegerArray(matrix[0]);
                    int[] fixed = matrix[1];
                    boolean[] fixedArr = convertToBooleanArray(fixed);
                    BubbleSort.sortModified(arr, fixedArr);
                    JTableUtils.writeArrayToJTable(outputTable, convertToIntArray(arr));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
    private static boolean[] convertToBooleanArray(int[] arr) {
        boolean[] newArr = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] == 1;
        }
        return newArr;
    }

    private static Integer[] convertToIntegerArray(int[] arr) {
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private static int[] convertToIntArray(Integer[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
