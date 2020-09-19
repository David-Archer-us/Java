package com.sjsu;

/**
 * This is a class for controlling the colors
 * Author: David Zhang
 * Course: cs49j
 * Instructor: Dr. Ramin Moazeni
 * Teacher Assistant: Yan Chen
 * Date: 11/17/19
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E20_5ColorController
{
    // create some attributes
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 100;
    private static JLabel label;
    private static JComboBox colorBox;
    private static JPanel colorPanel;
    private static JPanel controlPanel;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        createControlPanel();
        frame.add(controlPanel);
        ChoiceListener listener = new ChoiceListener();
        colorBox.addActionListener(listener);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color Viewer");
    }

    /**
     * create an action listener for getting the user's choice
     */
    private static class ChoiceListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String colorSelected = (String)colorBox.getSelectedItem();
            if(colorSelected.equals("Red"))
            {
                colorPanel.setBackground(Color.RED);
            }
            else if(colorSelected.equals("Green"))
            {
                colorPanel.setBackground(Color.GREEN);
            }
            else if(colorSelected.equals("Blue"))
            {
                colorPanel.setBackground(Color.BLUE);
            }
            else
            {
                colorPanel.setBackground(Color.BLACK);
            }
        }
    }

    /**
     * create a method for setting up a control panel
      */

    public static void createControlPanel()
    {
        label = new JLabel("Colors");
        colorBox = new JComboBox();
        colorBox.addItem("Red");
        colorBox.addItem("Green");
        colorBox.addItem("Blue");
        colorPanel = new JPanel();
        controlPanel = new JPanel();
        controlPanel.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        controlPanel.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        north.add(label);
        north.add(colorBox);
        controlPanel.add(north, BorderLayout.NORTH);
        controlPanel.add(colorPanel, BorderLayout.CENTER);
    }
}
