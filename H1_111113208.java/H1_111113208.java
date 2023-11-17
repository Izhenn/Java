//H1質數判別
//劉亦禎 111113208
//輸入一個大於零整數來判別是否為質數並且分解出質因數
//符合的評分標準:
//  1.程式有意義且可執行
//  2.正確顯示答案
//  3.顯示其質因數分解可供驗證是否為質數
//  4.自評90
import java.util.Scanner;

public class H1_111113208{
    public static void main(String[] args){
        int num,m,t;
        System.out.println("請輸入一個大於零的整數");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        t = 1;
        for(int i=2;i<num;i++){      //從2開始進行輸入的數除i的運算，如果i跑到輸入的數之前就有數字可以被整除，那麼就是質數，如果i跑到num-1都沒有整除，就不是質數
            if(num%i==0){                            
                System.out.println("不是質數");
                t = 0;
                break;      //只要找到可以被整除的i，確認num為質數，即可跳出迴圈
            }
        }
        if (t == 1) {
            System.out.println("是質數");
        } else {
            m=2;
            while (m<=num) {        //設值m=2(最小質數)，如果num大於或等於m，進行判斷
                if (m==num) {                  //如果m=num，列印m
                    System.out.print(m);
                    m++;                        //因為m已經不是剩下的數的因數，所以+1
                }
                else if (num%m==0){             //利用餘數判斷可整除，如果可以整除，m即為num的因數，否則m+1
                    System.out.print(m+"*");    
                    num=num/m;                  //找出一個質因數後，將num除m再去找一次
                } 
                else{
                    m++;
                }
            }
        }
        

    }
}