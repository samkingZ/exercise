package com.hihuaning.socket;

import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket s = new ServerSocket(2001);
		System.out.println("监听本机器的2000端口");
		Socket c;
		c = s.accept();
		System.out.println("一个客户端程序连接上来了");
		InputStream in = c.getInputStream();
		OutputStream out = c.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintStream ps = new PrintStream(out);
		String msg;
		while((msg = br.readLine())!=null){
			System.out.println("服务器端收到："+msg);
			ps.println(msg);
			if(msg.equals("quit")){
				System.out.println("服务器程序退出");
				break;
			}
		}
		in.close();
		out.close();
		c.close();

	}
}
