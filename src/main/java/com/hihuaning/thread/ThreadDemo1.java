package com.hihuaning.thread;

public class ThreadDemo1 {
	public static void main(String[] args){            //主线程是产生其他线程的线程，主线程最后完成执行，用于各种关闭动作
		Thread t = Thread.currentThread();             //currentThread()方法返回当前线程的引用
		System.out.println("Current thread:"+t);
		t.setName("My Thread");
		System.out.println("After name change: "+t);
		try{
			for(int n = 5; n>0; n--){
				System.out.println(n);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){                     //Thread类的sleep方法可能会引发InterruptedException异常，这种情形会在其他线程打搅沉睡线程时引发。
			System.out.println("Main thread interrupted");
		}
	}
}

