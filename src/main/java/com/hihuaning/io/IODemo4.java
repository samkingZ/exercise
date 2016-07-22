package com.hihuaning.io;


public class IODemo4 {
	public static void printArray(byte bytes[]){
		System.out.println("数组的内容");
		for(int i=0;i<bytes.length;i++){
			System.out.write(bytes[i]);
		}
		System.out.println();
	}
	public static void main(String[] args)throws Exception{
		byte[] b = new byte[2];
		int readnum = System.in.read(b);
		int left = System.in.available();
		System.out.println("读取了"+readnum+"个字符，还有"+left+"个字符可度");
		printArray(b);
		long skipnum = System.in.skip(2);
		left = System.in.available();
		System.out.println("跳过"+skipnum+"个字节数，还有"+left+"个字节可读");
		b = new byte[2];
		readnum = System.in.read(b);
		left = System.in.available();
		System.out.println("再读取"+readnum+"个字符，还剩"+left+"个字符可读");
		printArray(b);
		skipnum = System.in.skip(10);
		left = System.in.available();
		System.out.println("实际跳过字节数"+skipnum+"还剩"+left);

	}
}
