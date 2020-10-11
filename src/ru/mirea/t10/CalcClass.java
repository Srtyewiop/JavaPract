package ru.mirea.t10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcClass extends JFrame implements ActionListener {

    private JFrame frame;
    private JTextField textFieldFirstNum, textFieldSecondNum, textFieldResult;
    JButton addButton, substractButton, divideButton, multiplyButton;

    private static double a = 0, b = 0, result = 0;
    private static int operator = 0;

    public CalcClass() {
        frame = new JFrame("Calculator");
        frame.setSize(223, 323);

        textFieldFirstNum = new JTextField();
        textFieldSecondNum = new JTextField();
        textFieldResult = new JTextField();

        addButton = new JButton("+");
        substractButton = new JButton("-");
        divideButton = new JButton("/");
        multiplyButton = new JButton("*");

        textFieldFirstNum.setBounds(30, 40, 280, 30);
        textFieldSecondNum.setBounds(30, 170, 280, 30);
        textFieldResult.setBounds(30, 270, 280, 60);

        addButton.setBounds(40, 100, 50, 40);
        substractButton.setBounds(110, 100, 50, 40);
        divideButton.setBounds(180, 100, 50, 40);
        multiplyButton.setBounds(250, 100, 50, 40);

        frame.add(textFieldFirstNum);
        frame.add(textFieldSecondNum);
        frame.add(textFieldResult);
        frame.add(divideButton);
        frame.add(multiplyButton);
        frame.add(substractButton);
        frame.add(addButton);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        addButton.addActionListener(this);
        divideButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        substractButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a + b;
            textFieldResult.setText("" + result);
        }

        if (e.getSource() == substractButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a - b;
            textFieldResult.setText("" + result);
        }

        if (e.getSource() == multiplyButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a * b;
            textFieldResult.setText("" + result);
        }

        if (e.getSource() == divideButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a / b;
            textFieldResult.setText("" + result);
        }
    }
}
