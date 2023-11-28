package H5;

import java.util.Scanner;
import java.util.Stack;

public class H5_111113208 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("請輸入一個加減乘除及括號整數運算式");
        String inpuString=sc.nextLine();
        char[] tokens=inpuString.toCharArray();

        Stack<Character> operator=new Stack<>();
        Stack<Double> number=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(Character.isDigit(tokens[i])){
                StringBuilder sb=new StringBuilder();
                while(i<tokens.length && (Character.isDigit(tokens[i]) || tokens[i]=='.')){
                    sb.append(tokens[i]);
                    i++;
                }
                number.push(Double.parseDouble(sb.toString()));
                i--;
            }
            else if(tokens[i] == '('){
                operator.push(tokens[i]);
            }
            else if(tokens[i] == ')'){
                while (operator.peek() != '(') {
                    double a=number.pop();
                    double b=number.pop();
                    char c=operator.pop();
                    double result=0;
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
            else if(Operator(tokens[i])){
                while (!operator.isEmpty() && Precedence(tokens[i],operator.peek())){
                    double a=number.pop();
                    double b=number.pop();
                    char c=operator.pop();
                    double result=0;
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
        }
        while (!operator.isEmpty()) {
            double a=number.pop();
            double b=number.pop();
            char c=operator.pop();
            double result=0;
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
    }
    private static boolean Operator(char c){
        if(c =='+' || c=='-' || c=='*' || c=='/'){
            return true;
        }
        else
        return false;
    }
    private static boolean Precedence(char a,char b){
        if (b=='(' || b==')') {
            return false;
        }
        else if((a=='+' || a=='-') && (b=='*' || b=='/')) {
            return true;
        }
        else
        return true;
    }
}
