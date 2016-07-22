package com.hihuaning.basics;

import java.util.HashSet;
import java.util.Set;

public class BasicDataTypeDemo {
	public static void main(String[] args){
		double b = 23d;
		long l = 3412L;                 //long 类型最后必须有l字母
		System.out.println(b);
		float f = 1.24f;                   //float 最后要有f字母
		float a = 1.5f;
		double c = 21d;                   //double 最好有个d字母，也可以没有
		System.out.println(f+1);
		System.out.println(a*f);
		System.out.println(f*b);       //不精确，可以使用java.math.BigDecimal类来进行计算
		System.out.println(c*b);
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		Set<Integer> hash = new HashSet<Integer>();
		hash.add(n);
		while(n > 1){
			int count = 0;
			do{
				int temp = n%10;
				count +=temp*temp;
			}while((n=n/10) != 0);
			if(hash.contains(count))
				return false;
			n = count;
			hash.add(n);
		}
		return true;
	}
}
