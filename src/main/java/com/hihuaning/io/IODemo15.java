package com.hihuaning.io;

import java.io.*;

/**
 * 演示RandomAccessFile的用法
 * java IO  RandomAccessFile*/
public class IODemo15 {
	public static void main(String[] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile("123.txt","rw");
		long len = raf.length();
		System.out.println(len);
		raf.skipBytes((int)len-2);       //skipBytes 表示从当前位置跳过n个字节
		int ch ;
		while((ch = raf.read()) != -1)
			System.out.write(ch);           //System.out.write()输出字符流()，System.out.println()是输出字节流
		System.out.flush();              //使用flush就可清空缓存，输出信息


		for(int i=1; i<10; i++){
			raf.writeDouble(i*2.5);     //表示写入double类型的数据，类似还有writeChar,writeFloat等等，对应的读操作，有readDouble(),readChar(),readFloat()
		}
		raf.seek(5*8+len);              //从开始位置跳过n个字节,seek(0)表示到文件的起始位置
		raf.writeDouble(2.5);
		raf.seek(len);
		double d;
		while((d=raf.readDouble())!=22.5)
			System.out.println(d);

		String str = "hi boy";
		byte[] b = str.getBytes();       //在向RandomAccessFile流中写数据时，需要转为字节型
		raf.write(b);

		raf.seek(0);
		int len1 = (int)raf.length(); //在使用length()时，要把指针移到文件开始位置，不然会报错
		byte[] bytes = new byte[len1];
		raf.readFully(bytes);
		RandomAccessFile rafcopy = new RandomAccessFile("123copy.txt","rw");  //使用RandomAccessFile来对文件复制
		rafcopy.write(bytes);
		rafcopy.close();
		raf.close();
	}
}