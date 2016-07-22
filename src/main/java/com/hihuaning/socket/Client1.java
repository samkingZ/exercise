package com.hihuaning.socket;

import java.io.*;
import java.net.*;

public class Client1 {
	public static void main(String[] args)throws Exception{
		Socket c = new Socket("localhost",2000);
		System.out.println("程序已连接");
		InputStream in = c.getInputStream();
		OutputStream out = c.getOutputStream();
		//Person wangwu = new Person("老五",29,true);
		int msg;
		while((msg=System.in.read())!=-1){
			out.write(msg);
			System.out.write(in.read());
		}
		out.write(-1);
		in.close();
		out.close();
		c.close();
		System.out.println("客户机关闭");
	}
}

