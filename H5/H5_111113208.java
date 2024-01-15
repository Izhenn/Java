//劉亦禎 111113208
//操作說明:輸入一連串包含運算符號的運算式(包含括號)，可根據運算子優先權進行計算輸出結果。
//符合的評分標準:
//1.程式有意義且可以執行 
//2.可正確計算結果(不支援括號)
//3.支援括號
//自評:100分
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
            else if(Operator(tokens[i])){           //使用函數檢測tokens[i]是否為運算子
                while (!operator.isEmpty() && Precedence(tokens[i],operator.peek())){       //如果堆疊不為空，且現在的token優先權小於operator堆疊頂部的運算子(用Precedence函數檢測)
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
        while (!operator.isEmpty()) {                   //當運算式處理完畢，且運算子堆疊不為空，則不斷推出運算，直到堆疊為空
            double b=number.pop();
            double a=number.pop();
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
        System.out.println(number.pop());
    }   //莫
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
