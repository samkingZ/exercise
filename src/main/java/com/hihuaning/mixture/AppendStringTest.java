package com.hihuaning.mixture;
/*
 * String.valueOf(arg0) 返回参数字符串形式
 * System.currentTimeMillis() 返回当前时间
 *
 *
 * String 对象的长度是固定的，不能改变它的内容，或者是附加新字符到String对象中。
 * 使用+来串联字符串已达到附加新字符的目的，但是+会产生一个新的Stirng实例。如果这种附加字符串的需求很频繁，
 * 并不建议用+进行字符串串联。
 * StringBuilder类所产生的对象默认会有16字符的长度，也可以自行指定长度。如果字符串的长度超出这个长度就会自动
 * 增加长度，如果有频繁作字符串附加的需求，使用StringBuilder会让程序的效率大大提高。
 *
 * toString()方法可以返回String
 * length()方法得知目前对象中的字符长度
 * capacity()返回该对象目前可容纳的字符容量
 * insert()将字符插入指定位置，如果此位置有字符，则该位置以后的字符往后移
 * deleteChar()方法可以删除指定位置的字符
 * reverse()方法可以反转字符串
 *
 * 如果要用到多线程则用StringBuffer类
 * */
public class AppendStringTest {
	public static void main(String[] args){
		String text = "";
		long beginTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
			text = text + i;
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);

		StringBuilder builder = new StringBuilder("");
		beginTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
			builder.append(String.valueOf(i));
		endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
		System.out.println(System.currentTimeMillis());
	}
}
