package com.hihuaning.basics;


public class OverloadingDemo1 extends MethodVisibility{
	private int d;
	public OverloadingDemo1(int a, int b, int c, int d){
		super(a,b,c);
		this.d = d;
	}
	private void sayHi(){
		System.out.println("say hi");
	}
	public void say2(){
		say1();
		System.out.println(" "+a+" ");
	}
	final void method1(){
		System.out.println("this a final method");     //修饰符为final的方法可以被重载
	}
	public final void method1(String a){
		System.out.println("this a final method "+a);
	}
	public static void method(){
		System.out.println("this is method");
	}
	public static void method(String a){      //修饰符为static的方法可以被重载（overloading）
		System.out.println("this is "+a);
	}
	public static void main(String[] args){
		OverloadingDemo1 d = new OverloadingDemo1(1,2,3,4);
		d.say2();
		d.start();
		OverloadingDemo1.method();
		OverloadingDemo1.method("hi");
		d.method1();
		d.method1("world");
	}
}



