//劉亦禎 111113208
//操作說明:
//隨機生成一個四位數字，使用者輸入四位數字，系統輸出幾A幾B，A代表數字對且位置對的位數，B代表數字對但位置不對的位數
//符合的評分標準:
//  1.程式有意義且可以執行
//  2.完成遊戲
//  3.當使用者輸入重複數字不可執行
//  4.自評:100
import java.util.Arrays;
import java.util.Scanner;

public class H3_111113208 {
    public static void main(String[] args) {
        int attempt=0;
        int[] ans=new int[4];
        ans=generatenumber();               //生成隨機四位數字
        // for(int i=0;i<4;i++){              //檢查答案
        //     System.out.print(ans[i]);
        // }
        int[] guess=new int[4];
        int[] result=new int[2];
        result[0]=0;
        System.out.println("輸入一組四位數數字，如:1234且每一個位數數字不重複");
        while (result[0]!=4){                           //當A值不等於4，代表答案還沒答對，則待在while繼續執行，直到4A為止
            Scanner sc = new Scanner(System.in);
            String aString=sc.nextLine(); 
            for(int i=0;i<4;i++){                   //將輸入的字串從索引值0一一輸入到陣列中
                guess[i] = Character.getNumericValue(aString.charAt(i));
            }
            // System.out.println("猜錯了，請重新輸入");
            if(checkinput(guess)){              //使用函數checkinput來確定輸入的值是否符合格式
                result=checkguess(ans,guess);
                System.out.println(result[0]+"A"+result[1]+"B");
                attempt++;
                if(attempt>=10){
                System.out.println("猜錯10次，答案是"+ans[0]+ans[1]+ans[2]+ans[3]);
                // System.out.println("還要在玩一次輸入1");
                // Scanner.sc = new Scanner(System.in);
                // int y=sc.nextInt();
                // if (y==1) {
                //     result[0]=0;
                //     attempt=0;
                // }
                break;
                }
            }
            else{
                System.out.println("輸入數字重複，請重新輸入");
            }
            
        }
        if(Arrays.equals(ans, guess)){
            System.out.println("恭喜答對!總共猜了"+attempt+"次");
            }
    }
    
    private static int[] generatenumber(){              //生成隨機數字
        int[] temp=new int[4];
        for(int i=0 ; i<4 ; i++){                       //從索引值0開始
            int r;
            do{                                         
                r=(int)(Math.random()*10);              //隨機生成0~9的數字
            }while(contain(temp,r));                    //檢查生成的數字是否已經出現過
            temp[i]=r;
        }
        return temp;
    }

    private static boolean contain(int[] arr,int m){    //檢查是否生成重複數字
        for(int num:arr){
            if (num == m) {
                return true;
            }
        }
        return false;
    }
    public static int[] checkguess(int[] ans,int[] guess){
        int[] result=new int[2];
        for(int i=0; i< ans.length;i++){            //檢查輸入的數跟答案的結果
            if (ans[i]==guess[i]) {                 //如果數字及位置都正確，將result[0]加1
                result[0]++;
            }
            else if (contain(ans,guess[i])) {       //如果數字對但位置不對，將result[1]加1
                result[1]++;
            }
        }
        return result;                              //傳回result陣列值
    }
    public static boolean checkinput(int[] arr){       //檢查使用者輸入的值是否重複
        for(int i=0;i<4;i++){                           //從第一個數值開始，跟第二個到底四個值做比較，如有相同，則回傳false         
             for(int j=i+1;j<4;j++){                    //，如果都沒有檢查到，則回傳true開始比較數值  
                if (arr[i]==arr[j]) {                      
                    return false;
                }
            }
        } 
        return true;
    }
}