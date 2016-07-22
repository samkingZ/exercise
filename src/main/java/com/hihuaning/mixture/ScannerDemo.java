package com.hihuaning.mixture;

import java.util.Scanner;

public class ScannerDemo {
	public static void scannerDemo1(){
		Scanner s = new Scanner(System.in);
		String a = s.next();                                //获取使用者输入的字符串，nextInt()可以获取整型数据，类似还有nextFloat(),nextBoolean();
		System.out.printf("%s hello world %s",a,s.next());  //按下空格键，tab键或是Enter键，Scanner就会返回下一个输入
		s.close();
	}
	public static void main(String[] args){
		scannerDemo1();
	}
}
