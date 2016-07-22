package com.hihuaning.mixture;
/**
 * split()方法可以依指定的正则表达式，将符合的子字符串排除
 * .  符合任何一个字符
 * \d 符合0~9任一个数字字符
 * \D 符合0~9以外的任意字符
 * \s 符合\t,\n,\x0B,\f,\r等空格符
 * \w 符合数字和字母
 * \W 除数字和字母都符合
 * */
public class RegularExpressionDemo {
	public static void main(String[] args){
		String text = "abcdebcadxbc";
		String[] token = text.split(".bc");
		for(String i : token)
			System.out.print(i+" ");
		System.out.println();
		token = text.split("..bc");
		for(String i : token)
			System.out.print(i+" ");
	}
}