//劉亦禎 111113208
//操作說明:使用者連續輸入數字，如輸入q則終止並輸出總和值，如輸入非數字以及非q字母則輸出提醒使用者重新輸入
//符合的評分標準:
//1.程式有意義且可執行
//2.允許使用者重複輸入數字，輸入字母q時會產生例外，顯示輸入數字總和
//3.輸入的資料不是數字也不是字母q時，會丟出例外提醒使用者應輸入數字並讓其繼續輸入
//自評:100
package H6;

import java.util.Scanner;

public class H6_111113208 {
    static class EndException extends Exception{
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("請連續輸入數字或字母q來結束輸入");
        int sum=0;
        while(true){                        //會一直重複執行直到收到break指令，這樣可以讓使用者一直輸入數字
            String input=sc.nextLine();
            try{                            
                if (input.equals("q")) {        //如果輸入字串為字母q則拋出例外EndException
                    throw new EndException();
                }
                int num=Integer.parseInt(input);        //轉換字串為數字，如果不能轉為數字，系統會自動拋出例外
                sum=sum+num;
            }
            catch(EndException e){                      //接收例外EndException時，輸出加總總和並且跳出while迴圈
                System.out.println("總和為" + sum);
                break;
            }
            catch(Exception e){                         //如果收到任何的例外則提示使用者讓其繼續輸入
                System.out.println("應輸入數字，請繼續輸入");
            }
        }
        

    }
}
