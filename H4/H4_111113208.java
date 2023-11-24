//劉亦禎 111113208
//依照格式輸入西元年/月/日
//符合的評分標準
//  1.程式有意義且可執行
//  2.完成全部功能
//  3.自評:100分

package H4;

import java.util.Scanner;

public class H4_111113208 {
    public static void main(String[] args) {
        System.out.println("輸入年、月、日, 例如: 2023/10/19 (輸入年份為1900年之後)");
        Scanner sc=new Scanner(System.in);
        String inputnumber=sc.nextLine();
        String[] split=inputnumber.split("/");
        int arr[]=new int[split.length];
        for (int i = 0; i < split.length; i++) {            //將分割的字串轉為數字傳入陣列
            arr[i] = Integer.parseInt(split[i]);
        }
        int inputyear=arr[0];
        int inputmonth=arr[1];
        int inputday=arr[2];
        int ydays=0,mdays=0,ddays=0;
        
        // System.out.println(inputyear+" "+inputmonth+" "+inputday);              
        
        for(int i=1990;i<inputyear;i++){                //算從1990年開始到輸入的年份前一年的天數
            if((i%4==0&&i%100!=0)||i%400==0){           //判斷是閏年還是平年
                ydays+=366;
            }
            else{
                ydays+=365;
            }
        }
        // System.out.println("1990距離所輸入年分共有"+ydays+"日");

        for(int i=1;i<inputmonth;i++){                  //計算從1月開始到輸入月份的前一個月的總天數
            if (i==2) {
                if ((inputyear%4==0&&inputyear%100!=0)||inputyear%400==0) {
                    mdays+=29;
                }
                else{
                    mdays+=28;
                }
            }
            else if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                mdays+=31;
            }
            else{
                mdays+=30;
            }
        }
        int mmdays=0;
        if (inputmonth==1||inputmonth==3||inputmonth==5||inputmonth==7||inputmonth==8||inputmonth==10||inputmonth==12) {
            mmdays=31;
        }
        else{
            mmdays=30;
        }
        // System.out.println("距離所輸入年分共有"+mdays+"日");
        ddays=ydays+mdays;              //總天數(不含當月)
        // System.out.println("共有"+ddays+"日");
        int wdays=(ddays+inputday-1)%7;             //找出星期幾
        if (wdays==6) {
            System.out.println("星期日");
        }
        else if (wdays==0) {
            System.out.println("星期一");
        }
        else if (wdays==1) {
            System.out.println("星期二");
        }
        else if (wdays==2) {
            System.out.println("星期三");
        }
        else if (wdays==3) {
            System.out.println("星期四");
        }
        else if (wdays==4) {
            System.out.println("星期五");
        }
        else if (wdays==5) {
            System.out.println("星期六");
        }

        System.out.println("日 一 二 三 四 五 六");
        int tab=ddays%7;
        if (tab!=6) {
            for(int i=0;i<tab+1;i++){               //找出此月第一天是星期幾
            System.out.print("  ");
        }
        }
        
        int tdays=0;
        for(int i=1;i<=mmdays;i++){             //依序列印出日期，並在天數減1後取與7相除的餘數
            tdays=(ddays+i-1)%7;
            if(i<=9){
                System.out.print(i+"  ");
            }
            else{
                System.out.print(i+" ");
            }
            
            if(tdays==5){
                System.out.print("\n");
            }
            // else{
            //     System.out.print("\t");
            // }
        }
    }
}