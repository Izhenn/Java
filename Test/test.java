import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input year is ");
		int year = sc.nextInt();
		System.out.println("Please input month is ");
		int month = sc.nextInt();
		int totalday = 0;
		int days = 0;
		int Tday;
		boolean febday;
		//计算到目前年份的天数
		for(int i = 1970; i < year; i++) {
			if((i % 4 == 0 && i % 100 != 0)||(i % 400 == 0)) {
				totalday = totalday + 366;
			}else {
				totalday = totalday + 365;
			}
		}
		
		
		System.out.println("\n********** " + year +" year " + month +" month calendar **********");
		//判断是否是闰年
		if((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0)) {
			 febday = true;
			
		}	
		
			//计算本月到本年初的天数
			int beforeday = 0;
			for(int j = 1;j <= month; j++ ) {
				switch(j) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					days = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					days = 30;
					break;
				case 2:
					if(febday = true) {
						days = 28 ;
					}else {
						days = 29 ;
					}
					break;
				default:
					System.out.println("输入错误");
					break;
				}
//				if(j < month ) {
					beforeday = beforeday + days;
//				}
				
			}
			
			//到目前月份第一天的总天数
			Tday = beforeday + totalday - days + 1;
			//System.out.println(Tday);
			int first1970week = 3;//1970年第一天为周四
			// 0	1	 2	  3	   4	5	  6
			//周一 周二 周三 周四 周五 周六 周日
			//求是周几
			int week = (Tday % 7 + first1970week - 1) % 7;
			//System.out.println(week);
			System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
			for(int k=1; k <= week; k++) {
				System.out.print("\t");
			}
			for(int m = 1; m <= days; m++) {
				System.out.print(m + "\t");
				if(m % 7 == (7 - week) % 7) {
					System.out.print("\n");
				}
			}
			
		
//		int week = (Tday + 6) / 7;
//		System.out.println("sunday\tmonday\ttuesday\twednesday\tthursday\tfriday\tsaturday");
	}
}