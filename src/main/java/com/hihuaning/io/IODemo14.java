package com.hihuaning.io;

import java.io.*;

/**
 * 复制文件
 * */
public class IODemo14{
	public static void main(String[] args) throws IOException{
		File file = new File("123.jpg");
		File file1 = new File("321.jpg");
		if(!file1.exists())
			file1.createNewFile();
		FileInputStream fis = new FileInputStream(file);            //根据该文件是二进制文件还是文本文件来选择使用FileInputStream或者FileReader
		FileOutputStream fos = new FileOutputStream(file1);          //可以通过RandomAccessFile对文件进行随机存取
		//RandomAccessFile raf = new RandomAccessFile(fis);            //它的构造函数还要一个表示以只读方式("r")，还是以读写方式("rw")打开文件的参数 (和C的fopen( )一模一样)。它不支持只写文件
		int i;
		while((i=fis.read()) != -1)
			fos.write(i);
		fos.close();
		fis.close();
		System.out.println("hello world");
	}
}

