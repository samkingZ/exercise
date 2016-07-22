package com.hihuaning.io;

import java.io.*;
/**
 * 使用PipedInputStream和PipedOutputStream实现多个线程之间的通信
 * */

public class IODemo17 {
	public static void main(String[] args)throws IOException, InterruptedException{
		final PipedOutputStream out = new PipedOutputStream();
		final PipedInputStream in = new PipedInputStream(out);
		Thread th1 = new Thread(new Runnable(){
			public void run(){
				try{
					out.write("hello world 你好".getBytes());
				}
				catch(Exception e){

				}
			}
		});
		Thread th2 = new Thread(new Runnable(){
			public void run(){
				int data;
				try {
					data = in.read();
					while(data!=-1){
						System.out.print((char)data);
						data = in.read();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		th1.start();
		th2.start();
	}
}