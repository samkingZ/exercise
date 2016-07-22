package com.hihuaning.jvm.RuntimeConstantPool;

import java.util.LinkedList;
import java.util.List;

public class RuntimeConstantPoolOOM {
	public static void main(String[] args){
		int i=1;
		List<String> list = new LinkedList<String>();
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
