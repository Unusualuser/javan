package Practice_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Calc extends JFrame {

    public Calc(){
        setTitle("Pretty calc =)");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        //GridLayout layout = new GridLayout(2, 4);
        //panel1.setLayout(layout);

        JLabel label1 = new JLabel("The first number");
        label1.setBounds(15, 23, 120, 20);
        panel1.add(label1);

        JTextField first = new JTextField(10);
        first.setBounds(120, 20, 150, 30);
        panel1.add(first);

        JLabel label2 = new JLabel("The second number");
        label2.setBounds(290,23,120,20);
        panel1.add(label2);

        JTextField second = new JTextField(10);
        second.setBounds(410, 20, 150, 30);
        panel1.add(second);


        JTextField res = new JTextField();
        res.setBounds(225, 150, 150, 30);
        panel1.add(res);


        JButton buttonAdd = new JButton("+");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) + Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonAdd.setBounds(125, 70, 50, 50);
        panel1.add(buttonAdd);

        JButton buttonSub = new JButton("-");
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) - Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonSub.setBounds(225, 70, 50, 50);
        panel1.add(buttonSub);

        JButton buttonMul = new JButton("*");
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) * Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonMul.setBounds(325, 70, 50, 50);
        panel1.add(buttonMul);

        JButton buttonDiv = new JButton("/");
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) / Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonDiv.setBounds(425, 70, 50, 50);
        panel1.add(buttonDiv);


        add(panel1);
        panel1.setLayout(null);
        setVisible(true);

//        JButton buttonAdd = new JButton("+");
//        buttonAdd.setBounds(40, 90, 85, 20);
//        buttonAdd.addActionListener(action -> {
//            clickCount++;
//            label.setText(field.getText());
//        });
//        JPanel panel = new JPanel();
//        GridLayout layout = new GridLayout(3, 2);
//        panel.setLayout(layout);
//        panel.add(label);
//        panel.add(buttonAdd);
//        JPanel secondPanel = new JPanel();
//        secondPanel.add(field);
//        secondPanel.add(new JButton("+"));
//        panel.add(secondPanel);
//        panel.add(new JButton("!!"));
//        panel.add(new JButton("!!"));
//        add(panel);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
