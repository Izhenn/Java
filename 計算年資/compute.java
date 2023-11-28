package 計算年資;

import java.util.Scanner;

public class compute {
    public static void main(String[] args){
		int num;
		do{
			System.out.println("請輸入數字，日期格適用/間隔，如113/1/16");
			Scanner sc=new Scanner(System.in);
			String ainput=sc.nextLine();
			String[] split=ainput.split("/");
			int arr[]=new int[split.length];
			for (int i = 0; i < split.length; i++) {            //將分割的字串轉為數字傳入陣列
				arr[i] = Integer.parseInt(split[i]);
			}
			int a=arr[0];
			int b=arr[1];
			int c=arr[2];
			int x,y,z;

			// Scanner sc=new Scanner(System.in);
			String input2=sc.nextLine();
			String[] split2=input2.split("/");
			int arr2[]=new int[split2.length];
			for (int i = 0; i < split2.length; i++) {            //將分割的字串轉為數字傳入陣列
				arr2[i] = Integer.parseInt(split2[i]);
			}
			int d=arr2[0];
			int e=arr2[1];
			int f=arr2[2];

			if(c<f){
				b=b-1;
				c=c+30;
			}

			if(b<e){
				a=a-1;
				b=b+12;
			}
			x=a-d;
			y=b-e;
			z=c-f;
			System.out.println(x+"."+y+"."+z);
			System.out.println("如要繼續輸入請按1，不繼續輸入按0");
			num=sc.nextInt();
		}while(num==1);
		

	}
}
