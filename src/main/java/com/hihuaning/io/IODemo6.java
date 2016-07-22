package com.hihuaning.io;


import java.io.*;

public class IODemo6 {
	public static void main(String[] args) throws Exception{
		byte[] source = {0x30,0x31,0x32,0x33,0x34,0x35};
		ByteArrayInputStream bis = new ByteArrayInputStream(source);
		int num = bis.available();
		System.out.println("有"+num+"个字符");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int a = 0;
		while(a != -1){
			a = bis.read();
			System.out.write(a);
			bos.write(a);
		}
		System.out.println();
		byte[] destination = bos.toByteArray();
		for(int i=0;i<destination.length;i++){
			System.out.write(destination[i]);
		}
		System.out.flush();
	}
}
