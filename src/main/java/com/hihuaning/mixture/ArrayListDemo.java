package com.hihuaning.mixture;

import java.util.*;
import java.util.*;
/**
 * ArrayList类实现了List接口，List接口是Collection接口的子接口，而Collection接口则是Iterable的子接口。Iterable接口要求实现一个iterator()方法*/
public class ArrayListDemo {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<String> al  = new ArrayList<String>();
		while(true){
			String str = sc.nextLine();                   //Scanner类的nextLine()方法也可读取一行
			if(str.equals("quit"))
				break;
			else
				al.add(str);
		}
		/*for(int i = 0; i < al.size(); i++)
			System.out.println(al.get(i));*/

		Iterator iterator  = al.iterator();               //iterator()方法返回一个Iterator对象，这个对象提供访遍容器元素的方法。
		while(iterator.hasNext())
			System.out.println(iterator.next());

		for(String i : al)
			System.out.println(i);                     //使用foreach来遍历List中的元素

		sc.close();
	}
}
