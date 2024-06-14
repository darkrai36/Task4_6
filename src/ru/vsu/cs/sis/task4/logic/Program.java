package ru.vsu.cs.sis.task4.logic;

import ru.vsu.cs.sis.task4.ui.FrameMain;

public class Program {
    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
}