package com.hihuaning.algorithm.general;

import java.util.Scanner;

public class JudgeWeek {
	public static int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31}; //先存普通年份每个月的天数

	public static void main(String[] args){
		int year;
		int month;
		int day;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年月日");
		year = sc.nextInt();
		month = sc.nextInt();
		day = sc.nextInt();
		try{									//异常处理，如果出现非法输入，则抛出异常
			boolean isError = false;
			if(month > 12){
				isError = true;
			}
			if(!isLeap(year) && arr[month-1] < day)
				isError = true;
			else if(isLeap(year)){
				if(month==1 && day>29)
					isError = true;
				else if(arr[month-1] < day)
					isError = true;
			}

			if(isError)
				throw new Exception("请输入正确年月日");
			else
				judgeWeek(year, month, day);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void judgeWeek(int year, int month, int day){   //判断某日期是星期几
		int totalDay = 0;
		int startYearDayth = dayth(2003, 7, 6);		//假设2003.7.6是星期天
		for(int i=1997; i<year; i++){
			if(isLeap(i))
				totalDay += 366;
			else
				totalDay += 365;
		}
		totalDay += dayth(year, month, day);
		totalDay -= startYearDayth;
		System.out.println("今天是星期"+totalDay%7);
	}

	public static boolean isLeap(int year){        //判断是否是闰年
		if(year%4 == 0){
			if(year%400 == 0 || year%100 != 0){
				return true;
			}
		}
		return false;
	}


	public static int dayth(int year, int month, int day){  //计算某天是第几天
		int allDay = 0;
		if(isLeap(year))
			arr[1] = 29;
		for(int i=0; i<=month-1; i++){
			allDay += arr[i];
		}
		allDay += day;
		return allDay;
	}
}