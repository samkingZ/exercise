package com.hihuaning.basics;

/*public 共有的，对所有类可见。
protected 受保护的，对同一包内的类和所有子类可见。
private 私有的，在同一类内可见。
默认的 在同一包内可见。默认不使用任何修饰符。
*/
class MethodVisibilityDemo1{
	protected int a;
	int b;
	public MethodVisibilityDemo1(int a,int b){
		this.a = a;
		this.b = b;
	}
	void say(){
		System.out.println("hi");
	}
	public void start(){
		say();
	}
}

public class MethodVisibility extends MethodVisibilityDemo1 {
	private int c;
	public MethodVisibility(int a,int b,int c){
		super(a,b);
		this.c = c;
	}
	void say(){
		System.out.println("hello");
	}
	public void say1(){
		System.out.println(c+" "+a+" "+b);
		start();
	}
	public static void main(String[] args){
		MethodVisibility d = new MethodVisibility(1,2,3);
		System.out.println(d.toString());
		d.say();
		d.say1();
		d.c = 4;                           //同一个类中可以访问private 成员
		System.out.println(d.c);
		MethodVisibilityDemo1 d3 = new MethodVisibilityDemo1(4,5);
		d3.a = 6;
		System.out.println(d3.a);
	}
}
