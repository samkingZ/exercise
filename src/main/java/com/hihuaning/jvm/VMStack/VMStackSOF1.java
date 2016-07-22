package com.hihuaning.jvm.VMStack;

public class VMStackSOF1 {
	public static void main(String[] args){
		while(true){
			Thread thread = new Thread(new Runnable(){
				public void run(){
					int i=1;
					i++;
				}
			});
			thread.start();
		}
	}
}
