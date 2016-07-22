package com.hihuaning.socket;

import java.io.*;
import java.net.*;

class Person{
	int age;
	int name;
	boolean gender;

	public Person(int age,int name,boolean gender){
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	public String toString(){
		return "Person"+name+"年龄"+age;
	}
}

public class Server1 {
	public static void main(String[] args)throws Exception{
		ServerSocket s = new ServerSocket(2000);
		System.out.println("监听2000端口");
		Socket c = s.accept();
		System.out.println("有客户端程序连接上来");
		InputStream in = c.getInputStream();
		OutputStream out = c.getOutputStream();
		int msg;
		while((msg=in.read()) != -1){
			System.out.write(msg);
			out.write(msg);
		}
		out.write(-1);
		in.close();
		out.close();
		c.close();
		System.out.println("服务器关闭");
	}
}
