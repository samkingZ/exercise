package com.hihuaning.mixture;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectinDemo1 {
	public static void main(String[] args){

		String str1 = new String("hello world");
		String str2 = "hello world";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		Set<String> hash = new HashSet<String>();   ///hashset中判定重复对象 1，hashCode 是否一样 2，判断equals运算是否相等
		hash.add(str1);								//一个类的两个实例对象用equals方法比较结果相等时，他们的哈希码也必须相等，但反之则不成立，或者说哈希吗相同的两个对象的equals方法比较的结果可以不等
		hash.add(str2);
		System.out.println(hash.size());
		System.out.println();
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(1, 3);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		Set<Point> hashPoint = new HashSet<Point>();
		hashPoint.add(p1);
		hashPoint.add(p2);
		hashPoint.add(p1);
		hashPoint.add(p3);
		System.out.println(hashPoint.size());
	}
}

class Point {
	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		final Point other = (Point) obj;
		if(x != other.x)
			return false;
		if(y != other.y)
			return false;
		return true;
	}
}