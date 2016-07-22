package com.hihuaning.io;

import java.io.*;

public class IODemo2 {
	public static void printArray(byte bytes[],int num){
		System.out.println("读了"+num+"个字节，数组中的数据");
		for(int i = 0;i<num;i++){
			System.out.print(Integer.toHexString(bytes[i])+" ");
		}
		System.out.println();
		for(int i = 0;i<num;i++){
			System.out.write(bytes[i]);
		}
		System.out.flush();
		System.out.println();
	}
	public static void main(String[] args) throws IOException{
		InputStream in = System.in;
		byte bytes[] = new byte[5];
		try{
			int num = System.in.read(bytes);
			printArray(bytes,num);
			num = in.read(bytes,1,2);   //将输入流中最多 len 个数据字节读入 byte 数组。尝试读取 len 个字节，但读取的字节也可能小于该值。以整数形式返回实际读取的字节数。
			printArray(bytes,num);
			num = in.read(bytes,1,3);   //将读取的第一个字节存储在元素 b[off] 中，下一个存储在 b[off+1] 中，依次类推。读取的字节数最多等于 len。设 k 为实际读取的字节数；这些字节将存储在 b[off] 到 b[off+k-1] 的元素中，不影响 b[off+k] 到 b[off+len-1] 的元素
			printArray(bytes,num);
		}
		catch(IOException e){

		}
	}
}
