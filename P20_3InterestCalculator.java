package com.sjsu;

/**
 * This is a class for calculating the interest
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
import java.text.DecimalFormat;

public class P20_3InterestCalculator
{
    // create some attributes
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    private static final int RATE = 5;
    private static final double INIBALANCE = 1000.00;
    private static double balance;
    private static JLabel iniLabel;
    private static JTextField iniAmount;
    private static JLabel rate;
    private static JTextField interestRate;
    private static JLabel years;
    private static JTextField numYears;
    private static JButton calculate;
    private static JTextArea newBalance;
    private static JPanel controlPanel;
    private static DecimalFormat format = new DecimalFormat("##.##");

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        createControlPanel();
        frame.add(controlPanel);
        CalculateListener listener = new CalculateListener();
        calculate.addActionListener(listener);
        frame.setTitle("Interest Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setVisible(true);
    }

    /**
     * create an action listener for the button "Calculate"
     */
    private static class CalculateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            double dIniAmount = Double.parseDouble(iniAmount.getText());
            int inRate = Integer.parseInt(interestRate.getText());
            int inYears = Integer.parseInt(numYears.getText());
            newBalance.setText("Balance: \n");
            for(int i = 1; i <= inYears; i++)
            {
                balance = dIniAmount * (Math.pow( (1 + inRate/100.0), i));
                newBalance.setText(newBalance.getText() + "End of " + i + " year(s): " + format.format(balance) + "\n");
            }
        }
    }

    /**
     * create the method to make all components and put them together
     */
    private static void createControlPanel()
    {
        iniLabel = new JLabel("Initial amount", JLabel.CENTER);
        iniAmount = new JTextField();
        iniAmount.setText("" + INIBALANCE);
        rate = new JLabel("Interest rate", JLabel.CENTER);
        interestRate = new JTextField();
        interestRate.setText("" + RATE);
        years = new JLabel("Number of years", JLabel.CENTER);
        numYears = new JTextField();
        numYears.setText("" + 1);
        calculate = new JButton("Calculate");
        calculate.setBackground(Color.GREEN);
        newBalance = new JTextArea();
        newBalance.setEditable(false);
        newBalance.setMargin(new Insets(5, 5, 5, 5));
        newBalance.setBackground(Color.PINK);
        newBalance.setSize(WINDOW_WIDTH, WINDOW_HEIGHT/2);
        double dIniAmount = Double.parseDouble(iniAmount.getText());
        int inRate = Integer.parseInt(interestRate.getText());
        int inYears = Integer.parseInt(numYears.getText());
        balance = dIniAmount * (Math.pow( (1 + inRate/100.0), inYears));
        newBalance.setText("Balance: $" + format.format(balance));
        JScrollPane scrolNewBalance = new JScrollPane((newBalance));
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3, 2));
        northPanel.add(iniLabel);
        northPanel.add(iniAmount);
        northPanel.add(rate);
        northPanel.add(interestRate);
        northPanel.add(years);
        northPanel.add(numYears);
        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(northPanel, BorderLayout.NORTH);
        controlPanel.add(scrolNewBalance, BorderLayout.CENTER);
        controlPanel.add(calculate, BorderLayout.SOUTH);
    }
}
