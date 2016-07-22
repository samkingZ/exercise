package com.hihuaning.mixture;

public class StringDemo {
	public static void main(String[] args){
		String str = "Have a nice day";
		System.out.println("大写："+str.toUpperCase());
		System.out.println("小写："+str.toLowerCase());
		System.out.println("替代："+str.replaceAll("nice","good"));
		System.out.println("子字符串："+str.substring(5));
	}
}
