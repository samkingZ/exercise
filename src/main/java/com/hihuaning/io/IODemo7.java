package com.hihuaning.io;

import java.io.*;

public class IODemo7 {
	public static void main(String[] args)throws IOException{
		byte[] source1 = {0x31,0x32,0x33,0x34,0x35,0x36};
		byte[] source2 = {0x37,0x38,0x39,0x40,0x41,0x42};
		ByteArrayInputStream bis1 = new ByteArrayInputStream(source1);
		ByteArrayInputStream bis2 = new ByteArrayInputStream(source2);
		SequenceInputStream sis = new SequenceInputStream(bis1,bis2);
		System.out.println(sis.available());
		int a = 0;
		while(a != -1){
			a = sis.read();
			System.out.write(a);
		}
		System.out.flush();
	}
}
