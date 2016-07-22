package com.hihuaning.io;

import java.io.*;

/**
 * File类使用举例
 */
public class IODemo16 {
	public static void main(String[] args){
		File file1 = new File("aaa.txt");
		if(file1.exists()){
			int len = (int) file1.length();                             //返回的长度为文件的字节数
			boolean success = file1.renameTo(new File("bbb.txt"));     //给文件重名名
			boolean success1 = file1.isDirectory();                   //判断是否是目录
			System.out.println(len+" "+success+" "+success1);
		}
		File file = new File("lib");
		System.out.println(file.length());								//如果此路径名表示一个目录，则返回值是不确定的
		String[] filenames = file.list();                              //list()方法返回当前File对象指向的目录中所有文件与子目录的字符串名称
		File[] files = file.listFiles();                              //listFiles()方法返回当前File对象指向的目录中所有文件与子目录相关联的File对象
		for(String str:filenames)									//如果此抽象路径名不表示一个目录，那么此方法将返回 null
			System.out.println(str);
		fileSearch("bin");
	}

	public static void fileSearch(String path){						//遍历文件夹中的文件
		File file1 = new File(path);
		File[] files = file1.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				System.out.println(file.getName());
				fileSearch(file.getPath());
			}
			else
				System.out.println(file.getName());
		}
	}
}
