package com.hihuaning.mixture;
/**
 * char charAt(int index) 返回索引处字符
 * int indexOf(int ch)    返回找到的第一个指定字符的索引位置
 * int indexOf(String str)  返回找到的第一个指定字符串的索引位置
 * String substring(int beginIndex)  取出指定索引处至字符串尾端的子字符串
 * String substring(int beginIndex,int endIndex)  取出指定索引范围的子字符串
 * char[] toCharArray()  将字符串转换为字符数组
 * String[] split(String args) 可以用来分离字符串
 */
public class CharAtString {
	public static void main(String[] args){
		String text = "One's left brain has nothing right"+"One's right brain has nothing left.\n";
		System.out.println("字符串内容：");      //也可以用字符数组来构建字符串
		for(int i = 0; i < text.length(); i++)
			System.out.print(text.charAt(i));
		System.out.println("字符串长度为："+text.length());
		System.out.println("第一个left 在"+text.indexOf("left"));
		System.out.println("最后一个left 在"+text.lastIndexOf("left"));
		char[] array = text.toCharArray();
		for(char i : array)
			System.out.print(i);
	}
}
