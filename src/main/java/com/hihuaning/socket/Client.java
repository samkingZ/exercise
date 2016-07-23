package com.hihuaning.socket;

import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket c = new Socket("127.0.0.1",2000);
		System.out.println(c.getInetAddress());
		System.out.println(c.getLocalSocketAddress()+"已经连接上服务器程序");
		InputStream in = c.getInputStream();
		OutputStream out = c.getOutputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
		PrintStream ps = new PrintStream(out);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String msg;
		while((msg = br2.readLine())!=null){
			ps.println(msg);
			System.out.println("向服务器发送"+msg);
			System.out.println("客户端收到响应"+br1.readLine());
			if(msg.equals("quit")){
				System.out.println("客户端程序退出");
				in.close();
				out.close();
				c.close();
				break;
			}
		}

	}
}