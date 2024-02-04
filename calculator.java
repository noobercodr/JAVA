import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener  {
    JFrame frame;
    JPanel panel;
    JButton buttons[] = new JButton[10];
    JButton add, sub, mul,div;
    JButton clr, del,equal,deci;
    JButton fbutton[]=new JButton[8];
    JTextField text=new JTextField();
    String operator;
    double num1,num2;
    double result;
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(500, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       // Font my new Font("algerian",Font.BOLD,30);
        for(int i=0;i<10;i++)
        {
            buttons[i]=new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
        }
        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        clr=new JButton("clr");
        del=new JButton("del");
        equal=new JButton("=");
        deci=new JButton(".");
        //add=new JButton("+");
        fbutton[0]=add;
        fbutton[1]=sub;
        fbutton[2]=mul;
        fbutton[3]=div;
        fbutton[4]=clr;
        fbutton[5]=del;
        fbutton[6]=equal;
        fbutton[7]=deci;
        for(int i=0;i<8;i++)
        {
            fbutton[i].addActionListener(this);
            fbutton[i].setFocusable(false);
        }
        text.setBounds(100,0,200,75);
        panel=new JPanel();
        panel.setBounds(20,100,350,400);
        panel.setLayout(new GridLayout(4,4));
        for(int i=0;i<10;i++)
        {
            panel.add(buttons[i]);
        }
        for(int i=0;i<6;i++)
        {
            panel.add(fbutton[i]);
        }
        equal.setBounds(20,500,100,100);
        deci.setBounds(120,500,100,100);
        frame.add(equal);
        frame.add(deci);
        frame.add(text);
        frame.add(panel);
        frame.setVisible(true);
    }
        public void actionPerformed(ActionEvent e)
        {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == buttons[i]) {
                    text.setText(text.getText().concat(String.valueOf(i)));

                }
            }
            if (e.getSource() == add) {
                num1 = Double.parseDouble(text.getText());
                text.setText("");
                operator = "+";
            }
            if (e.getSource() == sub) {
                num1 = Double.parseDouble(text.getText());
                text.setText("");
                operator = "-";
            }
            if (e.getSource() == mul) {
                num1 = Double.parseDouble(text.getText());
                text.setText("");
                operator = "*";
            }
            if (e.getSource() == div) {
                num1 = Double.parseDouble(text.getText());
                text.setText("");
                operator = "/";
            }
            if (e.getSource() == clr) {
                text.setText("");
            }
            if (e.getSource() == del) {
                String temp = text.getText();
                text.setText("");
                for (int i = 0; i < temp.length() - 1; i++)
                    text.setText(text.getText() + temp.charAt(i));
            }
            if (e.getSource() == deci) {
                text.setText(text.getText().concat("."));
            }
            if (e.getSource() == equal) {
                num2 = Double.parseDouble(text.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        text.setText(String.valueOf(result));
                        break;
                    case "-":
                        result = num1 - num2;
                        text.setText(String.valueOf(result));
                        break;
                    case "*":
                        result = num1 * num2;
                        text.setText(String.valueOf(result));
                        break;
                    case "/":
                        result = num1 / num2;
                        text.setText(String.valueOf(result));
                        break;
                }
                    num1 = result;
                }
            }
        



    public static void main(String args[]) {
        new Calculator();
    }
}
