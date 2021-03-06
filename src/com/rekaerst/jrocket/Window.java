package com.rekaerst.jrocket;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 7397621225088225807L;

    public Window(int width, int height, String title, App app) {
        JFrame frame = new JFrame(title);
        Container panel = frame.getContentPane();

        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(app);
        frame.setVisible(true);
        app.start();
        System.out.println(panel.getSize());
    }
}
