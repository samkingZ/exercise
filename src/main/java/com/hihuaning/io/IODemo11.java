package com.hihuaning.io;
import java.io.*;

public class IODemo11 {
	public static void main(String[] args)throws IOException{
		File file = new File("321.txt");
		File file1 = new File("aaa.txt");
		if(!file1.exists()){
			file1.createNewFile();
		}
		FileReader fr = new FileReader(file);
		FileWriter fw = new FileWriter(file1);               //流的关闭顺序，先打开的后关闭，后打开的先关闭，不然会产生java.io.IOException: Stream closed异常
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		String str = null;
		while((str = br.readLine())!=null){
			str = str.substring(4);
			bw.write(str+"\t\n");
		}
		bw.close();
		br.close();
		fw.close();
		fr.close();
	}
}
