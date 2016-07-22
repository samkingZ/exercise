package com.hihuaning.io;

import java.io.*;


public class IODemo9 {
	public static void readdata(byte bytes[]){
		try{
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			long a = 0;
			for(int i=0;i<8;i++)
				a = (a<<8)|bis.read();
			System.out.println("常整形值为"+a+"其16进制值为"+Long.toHexString(a));

			int b = 0;
			for(int i=0;i<4;i++)
				b = (b<<8)|bis.read();
			System.out.println("整形值为"+b+"其16进制值为"+Integer.toHexString(b));

			short c = 0;
			for(int i=0;i<2;i++)
				c = (short)((c<<8)|bis.read());
			System.out.println("短整型值为"+c+"其16进制值为"+Integer.toHexString(c));
		}
		catch(Exception e){

		}
	}
	public static void main(String args[]){
		byte[] data = {0x25,0x26,0x27,0x28,0x29,0x30,0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x39};
		readdata(data);
	}
}
