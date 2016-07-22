package com.hihuaning.io;



//http://zhidao.baidu.com/question/123567346.html 相关介绍
public class IODemo10 {
	public static void main(String[] args){
		System.out.println("1234发你好".getBytes().length);   //字符串编码跟设置的字符集关，eclipse默认的字符集是GBK，汉字占两个字节
		char[] ch = new char[30];
		System.out.println();
		char c = 'a';
		char a = '\n';
		c = '\u0022';
		System.out.println(c);
		System.out.println(a);                         //能输出asc||码的值，java 字符串采用Unicode编码，其中前128个字符与asc||码兼容。
		System.out.println("中国人".getBytes().length);
	}
}