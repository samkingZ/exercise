package com.hihuaning.thread;


public class ThreadDemo3 {
	public static void main(String[] args){
		NewThread2 t = new NewThread2();
		t.start();
		try{
			for(int i=5; i>=0; i--){
				System.out.println("main: "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println("main interrupted");
		}
		System.out.println("main end");
	}
}

class NewThread2 extends Thread{               //使用继承Thread类的方式来实现多线程
	public void run(){
		try{
			for(int i=5; i>=0; i--){
				System.out.println("child: "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println("child interrupted");
		}
	}
}
