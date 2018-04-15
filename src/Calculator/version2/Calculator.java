package Calculator.version2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java Swing模仿Windows自带的计算器:
 * GUI复杂界面生成
 * 界面层次this{
 * topPanel{
 * screen,
 * editPanel{
 * editButton
 * //......
 * }
 * },
 * bottomPanel{
 * inputButton
 * //......
 * }
 * }
 *
 * @author ZHAO Jing 33470027#qq.com
 */
public class Calculator extends JFrame implements ActionListener {
    final static String TAGS[] = "MC 7 8 9 / sqrt MR 4 5 6 * % MS 1 2 3 - 1/x M+ 0 +/- . + =".split(" ");
    JTextField screen;
    JButton inputButtons[];
    JButton editButtons[];

    public Calculator() {
        JPanel top = new JPanel();
        JPanel edit = new JPanel();
        JPanel bottom = new JPanel();
        this.setLayout(new BorderLayout());
        top.setLayout(new BorderLayout());
        bottom.setLayout(new GridLayout(4, 6));

        screen = new JTextField(20);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setText("0.");
        top.add(screen, BorderLayout.NORTH);

        edit.setLayout(new GridLayout(1, 4));
        editButtons = new JButton[4];
        editButtons[0] = new JButton("");
        editButtons[0].setEnabled(false);
        editButtons[1] = new JButton("BackSpace");
        editButtons[2] = new JButton("CE");
        editButtons[3] = new JButton("C");
        for (int i = 0; i < editButtons.length; i++)
            edit.add(editButtons[i]);
        top.add(edit, BorderLayout.SOUTH);
        this.add(top, BorderLayout.NORTH);

        inputButtons = new JButton[4 * 6];
        for (int i = 0; i < inputButtons.length; i++)
            bottom.add(inputButtons[i] = new JButton(TAGS[i]));
        this.add(bottom, BorderLayout.CENTER);

        this.setResizable(false);// 禁用最大化按钮
        setSize(405, 208);
        setTitle("My Caculator ver 0.1a");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
    }
}