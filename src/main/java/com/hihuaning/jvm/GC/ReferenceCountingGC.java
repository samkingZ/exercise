package com.hihuaning.jvm.GC;

public class ReferenceCountingGC {
	public Object instance = null;
	public static void main(String[] args){
		ReferenceCountingGC obj1 = new ReferenceCountingGC();
		ReferenceCountingGC obj2 = new ReferenceCountingGC();
		obj1.instance = obj2;
		obj2.instance = obj1;
		/*obj1 = null;
		obj2 = null;*/
		System.gc();
	}
}
