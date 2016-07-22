package com.hihuaning.thread;

public class ThreadDemo5 implements Runnable{
	A a = new A();
	B b = new B();
	ThreadDemo5(){
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this,"RacingThread");
		t.start();                                           //mainThread 在获取a的对象锁后，试图获取b的对象锁；而RacingThraed 在获取b的对象锁后，试图获取a的对象锁，顾形成了死锁
		a.foo(b);
		System.out.println("Back in main Thread");
	}

	public void run(){
		b.bar(a);
		System.out.println("Back in other thread");
	}

	public static void main(String[] args){
		new ThreadDemo5();
	}
}

class A{
	synchronized void foo(B b){                               //一个线程可以获取多个对象锁，但是一个对象锁只能被一个线程锁获取
		String name = Thread.currentThread().getName();
		System.out.println(name+"entered A.foo");
	/*	try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("A Interrupted");
		}*/
		System.out.println(name+"trying to call B.last()");
		b.last();
	}
	synchronized void last(){
		System.out.println("Inside A.last");
	}
}

class B{
	synchronized void bar(A a){
		String name = Thread.currentThread().getName();
		System.out.println(name+" enter B.bar");
		/*try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("B interrupted");
		}*/
		System.out.println(name+" trying to call A.last()");
		a.last();
	}

	synchronized void last(){
		System.out.println("Inside B.last");
	}
}

