package calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PATHUMI
 */
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[10];
    JButton add, substraction, multiple, division;
    JButton sqroot, percentage, equal, clear, del, decimal;
    JPanel panel;

    double number1 = 0, number2 = 0, result = 0;
    char operator;

    Calculator() {

        initComponents();

    }

    public static void main(String[] args) {

        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimal) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == add) {
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == division) {
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == substraction) {
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiple) {
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == sqroot) {
            number1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(number1);
            textField.setText(String.valueOf(result));

        }
        if (e.getSource() == percentage) {
            number1 = Double.parseDouble(textField.getText());
            result = number1 / 100;
            textField.setText(String.valueOf(result));

        }
        if (e.getSource() == equal) {
            number2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }
            textField.setText(String.valueOf(result));
            number1 = result;
        }
        if (e.getSource() == clear) {

            textField.setText("");
        }
        if (e.getSource() == del) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));

            }
        }
    }

    private void initComponents() {
        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        JMenuBar menu = new JMenuBar();
        JMenu view = new JMenu("View");
        JMenuItem standard = new JMenuItem("Standard");
        JMenuItem scientific = new JMenuItem("Scientific");
        JMenuItem graphing = new JMenuItem("Graphing");
        JMenuItem programmer = new JMenuItem("Programmer");
        JMenuItem date = new JMenuItem("Date Calculation");
        view.add(standard);
        view.add(scientific);
        view.add(graphing);
        view.add(programmer);
        view.add(date);

        JMenu edit = new JMenu("Edit");

        JMenu help = new JMenu("Help");
        JMenuItem help1 = new JMenuItem("View Help");
        JMenuItem about = new JMenuItem("About Calculator");
        help.add(help1);
        help.add(about);
        menu.add(view);
        menu.add(edit);
        menu.add(help);

        frame.setJMenuBar(menu);
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        add = new JButton("+");
        substraction = new JButton("-");
        multiple = new JButton("*");
        division = new JButton("/");
        sqroot = new JButton("√");
        percentage = new JButton("%");
        equal = new JButton("=");
        clear = new JButton("c");
        del = new JButton("x");
        decimal = new JButton(".");

        functions[0] = add;
        functions[1] = substraction;
        functions[2] = multiple;
        functions[3] = division;
        functions[4] = sqroot;
        functions[5] = percentage;
        functions[6] = equal;
        functions[7] = clear;
        functions[8] = del;
        functions[9] = decimal;

        for (int i = 0; i < 10; i++) {
            functions[i].addActionListener(this);
            functions[i].setFocusable(false);

        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
        }
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(clear);
        panel.add(del);
        panel.add(percentage);
        panel.add(sqroot);

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiple);

        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(substraction);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);

        panel.add(decimal);
        panel.add(numbers[0]);
        panel.add(equal);
        panel.add(division);

        frame.add(panel);
        frame.add(textField);

        frame.setVisible(true);
    }

}
