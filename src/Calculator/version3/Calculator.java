package Calculator.version3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    final static int UNDEFINED = -1;
    final static int ADD = UNDEFINED + 1;
    final static int SUB = ADD + 1;
    final static int MUL = SUB + 1;
    final static int DIV = MUL + 1;
    private static final String TAGS[] = "x^3 Sqrt x^2 1/x CE C <- / 7 8 9 * 4 5 6 - 1 2 3 + ln 0  .  =".split("\\s+");
    private static int newCalc = 1, equaltionBeClicked = 0;

    JTextField screen = new JTextField(40);
    JButton[] btns = new JButton[6 * 4];

    double firstOperand;
    double secondOperand;
    int OPERATOR_TYPE = UNDEFINED;

    Calculator() {
        super("Calculator");
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setText("0");
        this.setLayout(new BorderLayout());
        this.add(screen, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(6, 4));
        for (int i = 0; i < 24; i++) {
            panel.add(btns[i] = new JButton(TAGS[i]));
            btns[i].addActionListener(this);
        }

        this.add(panel, BorderLayout.CENTER);
        this.pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        //System.out.println(Arrays.asList(TAGS));
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton btn : btns) {
            if (e.getSource() == btn) {
                String s = btn.getText();
                if ("0123456789".contains(s)) {
                    // JOptionPane.showMessageDialog(null,"digit button clicked");
                    if (screen.getText().equals("0") || "+-*/".contains(screen.getText()) || newCalc == 1) {
                        newCalc = 0;
                        screen.setText(s);

                    } else
                        screen.setText(screen.getText() + s);
                } else if ("+-*/".contains(s)) {
                    equaltionBeClicked = 0;
                    firstOperand = Double.parseDouble(screen.getText());
                    OPERATOR_TYPE = "+-*/".indexOf(s);
                    screen.setText(s);

                } else if (s.equals("Sqrt")) {
                    double x = Math.sqrt(Double.parseDouble(screen.getText()));
                    screen.setText(change(x));
                } else if (s.equals("1/x")) {
                    double x = 1 / Double.parseDouble(screen.getText());
                    screen.setText(change(x));
                } else if (s.equals("x^2")) {
                    double x = Math.pow(Double.parseDouble(screen.getText()), 2);
                    screen.setText(change(x));
                } else if (s.equals("x^3")) {
                    double x = Math.pow(Double.parseDouble(screen.getText()), 3);
                    screen.setText(change(x));
                } else if (s.equals("ln")) {
                    double x = Math.log(Double.parseDouble(screen.getText()));
                    screen.setText(change(x));
                } else if (s.equals("=") && equaltionBeClicked == 0) {
                    try {
                        equaltionBeClicked = 1;
                        secondOperand = Double.parseDouble(screen.getText());
                        double result = Double.parseDouble(screen.getText());
                        switch (OPERATOR_TYPE) {
                            case ADD:
                                result = firstOperand + secondOperand;
                                break;
                            case DIV:
                                result = firstOperand / secondOperand;
                                break;
                            case MUL:
                                result = firstOperand * secondOperand;
                                break;
                            case SUB:
                                result = firstOperand - secondOperand;
                                break;
                        }
                        screen.setText(change(result));
                        newCalc = 1;
                    } catch (Exception e1) {
                        screen.setText("ERROR!");
                    }
                } else if (s.equals(".") && newCalc == 0) {
                    if (!screen.getText().contains("."))
                        screen.setText(screen.getText() + ".");
                } else if (s.equals("C") || s.equals("CE")) {
                    screen.setText("0");
                } else if (s.equals("<-")) {
                    if (screen.getText().isEmpty())
                        screen.setText("0");
                    else
                        screen.setText(screen.getText().substring(0, screen.getText().length() - 1));
                }
            }
        }
    }

    private String change(double x) {
        if (Double.toString(x).substring(Double.toString(x).length() - 2).equals(".0"))
            return Double.toString(x).substring(0, Double.toString(x).length() - 2);
        else return Double.toString(x);
    }
}