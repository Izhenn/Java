//劉亦禎 111113208
//操作說明:小計算機，可計算加減乘除的運算式
//符合的評分標準:
//1.程式有意義且可以執行 
//2.支援整數運算
//3.支援小數運算
//自評:75分
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class H7_111113208 extends JFrame implements ActionListener{
    static H7_111113208 frm=new H7_111113208();
    // static JFrame frm=new JFrame("Calculator");
    static JPanel pne=new JPanel();
    static JButton btn1=new JButton("1");
    static JButton btn2=new JButton("2");
    static JButton btn3=new JButton("3");
    static JButton btn15=new JButton("/");
    static JButton btn4=new JButton("4");
    static JButton btn5=new JButton("5");
    static JButton btn6=new JButton("6");
    static JButton btn16=new JButton("*");
    static JButton btn7=new JButton("7");
    static JButton btn8=new JButton("8");
    static JButton btn9=new JButton("9");
    static JButton btn17=new JButton("-");
    static JButton btn0=new JButton("0");
    static JButton btn18=new JButton(".");
    static JButton btn19=new JButton("=");
    static JButton btn20=new JButton("+");
    static JLabel lab=new JLabel(" ");
    static String inputString = "";
    static JButton btn25=new JButton("C");

    public static void main(String[] args) {
        frm.setTitle("Calculator");
        btn1.addActionListener(frm);
        btn2.addActionListener(frm);
        btn3.addActionListener(frm);
        btn15.addActionListener(frm);
        btn4.addActionListener(frm);
        btn5.addActionListener(frm);
        btn6.addActionListener(frm);
        btn16.addActionListener(frm);
        btn7.addActionListener(frm);
        btn8.addActionListener(frm);
        btn9.addActionListener(frm);
        btn17.addActionListener(frm);
        btn0.addActionListener(frm);
        btn18.addActionListener(frm);
        btn19.addActionListener(frm);
        btn20.addActionListener(frm);
        btn25.addActionListener(frm);
        
        lab.setBounds(20,30,300,100);
        lab.setOpaque(true);
        lab.setBackground(new Color(240,220,190));
        lab.setPreferredSize(new Dimension(300,100));
        lab.setHorizontalTextPosition(JLabel.LEFT);
        frm.add(lab,BorderLayout.NORTH);
        GridLayout grid=new GridLayout(4,4);
        pne.setLayout(grid);
        pne.setBounds(20, 50, 300, 400);
        frm.setSize(600,700);
        pne.setOpaque(false);
        pne.add(btn1);
        pne.add(btn2);
        pne.add(btn3);
        pne.add(btn15);
        pne.add(btn4);
        pne.add(btn5);
        pne.add(btn6);
        pne.add(btn16);
        pne.add(btn7);
        pne.add(btn8);
        pne.add(btn9);
        pne.add(btn17);
        pne.add(btn0);
        pne.add(btn18);
        pne.add(btn19);
        pne.add(btn20);
        frm.add(pne,BorderLayout.CENTER);
        frm.add(btn25,BorderLayout.SOUTH);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        double result=0;
        JButton btn=(JButton) e.getSource();
        String btntext=btn.getText();
        if(btntext.equals("=")){
            char[] tokens=inputString.toCharArray();
            Stack<Character> operator=new Stack<>();
            Stack<Double> number=new Stack<>();

            for(int i=0;i<tokens.length;i++){           //處理每個字符分別放入堆疊
                if(Character.isDigit(tokens[i])){           //判斷字串是否為數字
                    StringBuilder sb=new StringBuilder();
                    while(i<tokens.length && (Character.isDigit(tokens[i]) || tokens[i]=='.')){
                        sb.append(tokens[i]);           //一個一個字元檢測，可以檢測出一位數以上的數字
                        i++;
                    }
                    number.push(Double.parseDouble(sb.toString()));
                    i--;
                }
                else if(tokens[i] == '('){
                    operator.push(tokens[i]);
                }
                else if(tokens[i] == ')'){
                    while (operator.peek() != '(') {        //重複推出堆疊並運算，直到operator的堆疊頂部是左括號
                        double b=number.pop();
                        double a=number.pop();
                        char c=operator.pop();
                        // double result=0;
                        if(c=='+'){
                            result=a+b;
                        }
                        else if(c=='-'){
                            result=a-b;
                        }
                        else if(c=='*'){
                            result=a*b;
                        }
                        else if(c=='/'){
                            result=a/b;
                        }
                        number.push(result);
                    }
                    operator.pop();
                }
                else if(Operator(tokens[i])){           //使用函數檢測tokens[i]是否為運算子
                    while (!operator.isEmpty() && Precedence(tokens[i],operator.peek())){       //如果堆疊不為空，且現在的token優先權小於operator堆疊頂部的運算子(用Precedence函數檢測)
                        double a=number.pop();                                                  
                        double b=number.pop();
                        char c=operator.pop();
                        // double result=0;
                        if(c=='+'){
                            result=a+b;
                        }
                        else if(c=='-'){
                            result=a-b;
                        }
                        else if(c=='*'){
                            result=a*b;
                        }
                        else if(c=='/'){
                            result=a/b;
                        }
                        number.push(result);
                    }
                    operator.push(tokens[i]);
                }
                // lab.setText(result);
            }
            while (!operator.isEmpty()) {                   //當運算式處理完畢，且運算子堆疊不為空，則不斷推出運算，直到堆疊為空
                double b=number.pop();
                double a=number.pop();
                char c=operator.pop();
                
                if(c=='+'){
                    result=a+b;
                }
                else if(c=='-'){
                    result=a-b;
                }
                else if(c=='*'){
                    result=a*b;
                }
                else if(c=='/'){
                    result=a/b;
                }
                number.push(result);
            }
        lab.setText(Double.toString(result));
        }
        else if(btntext.equals("C")){
            lab.setText(" ");
        }
        else{
            inputString += btn.getText();
            lab.setText(inputString);
        }
        
    }
    private static boolean Operator(char c){        //檢測當前字符是否為運算子
        if(c =='+' || c=='-' || c=='*' || c=='/'){
            return true;
        }
        else
        return false;
    }
    private static boolean Precedence(char a,char b){       //檢查token[i]跟operator堆疊頂部運算子的優先權(token[i]運算子優先權不可低於operator堆疊頂部運算子)
        if (b=='(' || b==')') {                 //如果operator堆疊頂部運算子是括號可直接堆上去
            return false;
        }
        else if ((a=='+' || a=='-') && (b=='*' || b=='/')) {        //如果operator堆疊頂部運算子優先權大於token[i]則須先進行運算
            return true;
        }
        else if ((a=='+' || a=='-') && (b=='+' || b=='-')) {        //如果優先權一樣則按照由左至右的優先權
            return true;
        }
        else if ((a=='*' || a=='/') && (b=='*' || b=='/')) {
            return true;
        }
        else
        return false;
    }

}
