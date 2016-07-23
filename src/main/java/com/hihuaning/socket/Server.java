package com.hihuaning.socket;

import java.io.*;
import java.net.*;
public class Server {

	public static class Operation implements Runnable{

		private Socket socket;

		public Operation(Socket socket){
			this.socket = socket;
		}

		public void run() {
			InputStream in = null;
			try {
				in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
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
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws Exception{
		ServerSocket s = new ServerSocket(2000);
		System.out.println("监听本机器的2000端口");
		System.out.println(s.getLocalSocketAddress());
		System.out.println(s.getInetAddress());
		System.out.println(s.getChannel());
		Socket c;
		while((c=s.accept()) != null){
			System.out.println(c.getInetAddress()+"连接上来了");
			new Thread(new Operation(c), c.getInetAddress().toString()).start();
		}

	}
}
