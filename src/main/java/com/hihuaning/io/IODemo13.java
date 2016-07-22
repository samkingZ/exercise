package com.hihuaning.io;

import java.io.*;
public class IODemo13 {
	public static void main(String[] args)throws Exception{
		FileReader fr = new FileReader("abc.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
		fr.close();
	}
}
