//This is my calculator
import javax.swing.*;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame = new JFrame("Calculator");
    JTextField textField = new JTextField();
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton;
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;
    Calculator(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;

        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel =new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    void Calculation(String input){
        String numbers[]=input.split(" ");
        int sum =Integer.parseInt(numbers[0]);
        for(int i=0;i< numbers.length;i++){
            if(numbers[i].equals("+")){
                 sum += Integer.parseInt(numbers[i+1]);
            }
            else if(numbers[i].equals("-")){
                sum -= Integer.parseInt(numbers[i+1]);
            }
            else if(numbers[i].equals("*")){
                sum *= Integer.parseInt(numbers[i+1]);
            }
            else if(numbers[i].equals("/")){
                sum /= Integer.parseInt(numbers[i+1]);
            }
        }
            System.out.println(sum);
        }


public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText()
                        .concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
    if(e.getSource()==subButton){
        num1 = Double.parseDouble(textField.getText());
        operator='+';
        textField.setText("");
    }
    if(e.getSource()==mulButton){
        num1 = Double.parseDouble(textField.getText());
        operator='*';
        textField.setText("");
    }
    if(e.getSource()==divButton){
        num1 = Double.parseDouble(textField.getText());
        operator='/';
        textField.setText("");
    }

}
    public static void main(String[] args) {
        Calculator arr = new Calculator();
        String lol="3 + 4 - 1 * 5 / 2";
        arr.Calculation(lol);
    }

    }
