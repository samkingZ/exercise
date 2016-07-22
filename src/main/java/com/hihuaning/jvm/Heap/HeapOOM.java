package com.hihuaning.jvm.Heap;

import java.util.LinkedList;
import java.util.List;
/*
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError  */
public class HeapOOM {
	static{
		int x=1;
	}
	public HeapOOM(){
		System.out.println(x);
	}
	public int x = 2;
	public  int getx(){
		return x+x;
	}
	private int a = 1;
	public static void main(String[] args){
		Thread t = new Thread(){
			public void run(){
				System.out.println("1");
			}
		};
		new HeapOOM().getx();
/*		List<HeapOOM> list = new LinkedList<HeapOOM>();
		while(true){
			list.add(new HeapOOM());
		}*/
	}
	
}
