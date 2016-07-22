package com.hihuaning.io;

import java.io.*;


public class IODemo12{
	public static void main(String[] args)throws Exception{
		File f = new File("123.txt");
		File f1 =new File("abc.txt");
		if(!f.exists())
			f.createNewFile();
		if(!f1.exists())
			f1.createNewFile();
		FileWriter fw = new FileWriter(f); //FileWriter 继承于OutputStreamWriter,而OutputStreamWriter继承与Writer
		FileWriter fw1 = new FileWriter(f1);
		fw.write("hello world");
		fw.close();                                  //对于一个文件，不能同时对它进行读写操作，这里必须先关闭写操作，然后进行读操作。
		FileReader a = new FileReader(f);
		char[] ch = new char[20];
		while((a.read(ch)) != -1)
			fw1.write(ch);
		fw1.close();
		a.close();
	}
}
