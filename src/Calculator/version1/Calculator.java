package Calculator.version1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jal on 2017/12/19 0019.
 */
public class Calculator extends JFrame implements ActionListener {
    JTextField textFieldFirst, textFieldSecond, textFieldResult;
    JButton btnadd, btnsub, btnmul, btndiv, btnequ;
    int a, b, val;

    Calculator() {
        super("Calculator");
        this.setLayout(new FlowLayout());
        this.add(textFieldFirst = new JTextField());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(btnadd = new JButton("+"));
        panel.add(btnsub = new JButton("-"));
        panel.add(btnmul = new JButton("*"));
        panel.add(btndiv = new JButton("/"));
        this.add(panel);

        this.add(btnequ = new JButton("="));
        this.add(textFieldResult = new JTextField());
        textFieldFirst.setColumns(5);
        textFieldSecond.setColumns(5);
        textFieldResult.setColumns(13);
        btnadd.addActionListener(this);
        btnsub.addActionListener(this);
        btnmul.addActionListener(this);
        btndiv.addActionListener(this);
        btnequ.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        a = Integer.parseInt(textFieldFirst.getText());
        b = Integer.parseInt(textFieldSecond.getText());
        if (e.getSource() == btnadd) {
            val = a + b;
        } else if (e.getSource() == btnsub) {
            val = a - b;
        } else if (e.getSource() == btnmul) {
            val = a * b;
        } else if (e.getSource() == btndiv) {
            val = a / b;
        } else if (e.getSource() == btnequ) {
            updateView();
        } else {

        }
    }

    private void updateView() {
        textFieldResult.setText(Integer.toString(val));
    }
}
