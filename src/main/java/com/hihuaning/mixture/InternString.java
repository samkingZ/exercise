package com.hihuaning.mixture;
/*
 * 在intern()方法被调用的时候，如果池中已经包括了相同的String对象，那么会从池中返回该字符串，
 * 否则原String对象会被加入池中，并返回这个String对象的引用*/
public class InternString {
	public static void main(String[] args){
		String str1 = "fly";
		String str2 = "weight";
		String str3 = "flyweight";
		String str4 = null;

		str4 = str1 + str2;
		System.out.println(str3 == str4);

		str4 = (str1 + str2).intern();
		System.out.println(str3 == str4);
	}
}
