package com.hihuaning.thread;


public class ThreadDemo2 {
	public static void main(String[] args){
		NewThread t = new NewThread();
		Thread t1 = new Thread(t,"child1");
		Thread t2 = new Thread(t,"child2");
		Thread t3 = new Thread(t,"child3");
		t2.setPriority(10);
		t3.setPriority(3);
		t1.start();
		t2.start();
		t3.start();                                            //isAlive()函数判断线程是否结束，join()函数等待指定线程结束
		System.out.println("t1 is alive "+t1.isAlive()+" t2 is alive "+t2.isAlive()+" t3 is alive "+t3.isAlive());
		try{
			t1.join();
			System.out.println("t1 is alive "+t1.isAlive()+" t2 is alive "+t2.isAlive()+" t3 is alive "+t3.isAlive());
			t2.join();
			System.out.println("t1 is alive "+t1.isAlive()+" t2 is alive "+t2.isAlive()+" t3 is alive "+t3.isAlive());
			t3.join();
			for(int i=5; i>=0; i--){
				System.out.println("mainThread "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println("main interrupted");
		}
		System.out.println("t1 is alive "+t1.isAlive()+" t2 is alive "+t2.isAlive()+" t3 is alive "+t3.isAlive());
		System.out.println("main end");
	}
}

class NewThread implements Runnable{               //通过实现Runnable接口来实现多线程
	public void run(){
		try{
			for(int i=5; i>=0;i--){
				System.out.println("childThread: "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println("child interrupted");
		}
	}
}
