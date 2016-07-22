package com.hihuaning.mixture;

public class AutoBoxDemo3 {
	public static void main(String[] args){
		Integer i1 = 200;
		Integer i2 = 200;             //在自动装箱时对于值从-128到127之间的值，它们被装箱为Integer对象后，会存在内存中被重用，类似于String中的字符串池
		if(i1 == i2)
			System.out.println("相等");
		else
			System.out.println("不相等");
	}
}