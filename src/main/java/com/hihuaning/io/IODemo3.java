package com.hihuaning.io;


import java.io.*;

public class IODemo3 {
	public static void printArray(byte bytes[]){
		System.out.println("数据长度"+bytes.length);
		for(int i=0;i<bytes.length;i++){
			System.out.print(Integer.toHexString(bytes[i])+"");
		}
		System.out.println();
		for(int i=0;i<bytes.length;i++){
			System.out.write(bytes[i]);
		}
		System.out.flush();
	}
	public static byte[] readData(){
		byte[] data = null;
		try{
			data = new byte[30];
			int offset = 0;
			while(offset<data.length){
				int readnum = System.in.read(data,offset,data.length-offset);
				System.out.println("读取的字节数"+readnum);
				if(readnum == -1)
					break;
				offset += readnum;
			}
		}
		catch(IOException e){
			System.err.println("can't read");
		}
		return data;
	}
	public static void main(String[] args){
		printArray(readData());
	}
}
