package com.hihuaning.socket;

import java.net.*;
import java.io.*;

public class ScanService {
	public static void main(String[] args){
		String host = "localhost";
		if(args.length>0){
			host = args[0];
		}
		for(int i=0;i<2001;i++){
			try{
				Socket s = new Socket(host,i);
				System.out.println("有程序在端口"+i+"监听");
			}
			catch(UnknownHostException e){
				System.err.println(e);
				break;
			}
			catch(IOException e){

			}
		}
	}
}

