package com.hihuaning.jvm.VMStack;

public class VMStackSOF {
	int primary = 1;
	public void test(int i){
		test(i+1);
	}
	public static void main(String[] args){
		VMStackSOF sof = new VMStackSOF();
		sof.test(sof.primary);
	}
}
