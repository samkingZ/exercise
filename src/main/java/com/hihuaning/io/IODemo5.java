package com.hihuaning.io;

import java.io.*;

public class IODemo5 {
	public static void main(String[] args)throws Exception{
		InputStream in= new FileInputStream(args[0]);
		OutputStream out= new FileOutputStream(args[1]);
		int c;
		while((c=in.read()) != -1){
			out.write(c);
			System.out.write(c);
		}
		in.close();
		out.close();
	}
}
