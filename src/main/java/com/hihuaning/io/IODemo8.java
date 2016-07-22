package com.hihuaning.io;

import java.io.*;

public class IODemo8 {
	static PipedInputStream in = new PipedInputStream();
	static PipedOutputStream out = new PipedOutputStream();
	public static void main(String[] args)throws IOException{
		try{
			in.connect(out);
		}
		catch(IOException e){
			System.out.println("管道连接失败");
			System.exit(1);
		}
		byte[] readdata = new byte[1000];
		int readnum = 0;
		int i = 0;
		startWrite();
		try{
			readnum = in.read(readdata);
			while(readnum != -1){
				i++;
				if(i == 10)
					System.exit(0);
				System.out.println("已经读取"+readnum+"还剩"+in.available());
				for(int j=0;j<readdata.length;j++)
					System.out.print(readdata[j]+" ");
				System.out.println();
				readnum = in.read(readdata);
			}
		}
		catch(IOException e){
			System.err.println("读取输入错误");
		}
	}
	public static void startWrite(){
		Runnable r = new Runnable(){
			public void run(){
				byte[] writedata = new byte[2000];
				while(true){
					for(int i=0;i<writedata.length;i++)
						writedata[i] = (byte)i;
					try{
						out.write(writedata);
					}
					catch(IOException e){
						System.err.println("写操作错误");
					}
					System.out.println("已经发送2000字节");
				}
			}
		};
		new Thread(r).start();
	}
}