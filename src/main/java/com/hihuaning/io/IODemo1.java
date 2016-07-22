package com.hihuaning.io;

import java.io.*;

public class IODemo1 {
	public static void main(String[] args) throws IOException{
		InputStream in = System.in;
		OutputStream out = System.out;
		try{
			int a = 0;
			while(a != -1){
				a = in.read();
				System.out.println(a);       //System.out.println()  是输出字节流
				out.write(a);                  //System.out.write()    是输出字符流
			}
		}
		catch(IOException e){

		}
		int a = 65;
		out.write(65);
		out.write(a);
		out.flush();//使用flush就可以输出留在缓存中的数据
	}
}
