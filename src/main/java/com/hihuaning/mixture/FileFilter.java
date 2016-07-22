package com.hihuaning.mixture;
/**
 *boolean endsWith(String str) 方法判断字符串是不是以指定文字作为结束*/
public class FileFilter {
	public static void main(String[] args){
		String[] strs = {"hee.jpg","wer.gif","fjask.jpg","fjasl.bmp"};
		for(String str : strs)
			if(str.endsWith(".jpg"))
				System.out.println(str);
	}
}
