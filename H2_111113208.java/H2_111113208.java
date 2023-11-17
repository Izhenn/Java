//劉亦禎 111113208
//輸入多個整數，輸出會由大到小排列
//符合的評分標準:
//  1.程式有意義且可執行
//  2.正確顯示答案
//  3.自評:80

import java.util.Scanner;

public class H2_111113208 {
    public static void main(String[] args) {
    
        System.out.println("請輸入多個整數，每個整數間以空白相隔");
        Scanner sc = new Scanner(System.in);
        String aString=sc.nextLine(); 
        String[] numbers = aString.split("\\s+");
        int arr[]=new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        for(int m=0;m<arr.length;m++){          //有幾個數字就執行幾次
            int max=-2147483648;
            int index=0;
            for(int i=0;i<arr.length;i++){      //從每次的陣列中找出最大值
                if(arr[i]>max){
                    max=arr[i];  
                    index=i;
                }
            }
            arr[index]=-2147483648;                       //將找到的最大值變為int範圍裡最小的數
            System.out.print(max+" ");
        }
    }
}
