package com.hihuaning.basics;

public class OverrideDemo1 extends OverloadingDemo1{                   //super 不是一个对象的引用，不能将 super 赋值给另一个对象变量，它只是一个指示编译器调用父类方法的特殊关键字。
	public OverrideDemo1(int a, int b, int c, int d){
		super(a,b,c,d);
	}
	private void sayHi(){                           // private方法不能被覆盖，这里只是定义了一个新方法
		System.out.println("this is Demo5.sayHi");
	}
	public void say2(){                             //覆盖父类方法，不能访问性不能比父类的访问性差
		super.say2();                               //通过super 调用父类的方法,不能调用父类的private方法
		System.out.println("this is Demo5.say2()");
	}
	public void visitedSuper(){
		System.out.println(super.a);               //不能使用super访问父类的private成员和不同包的default成员
	}
	public static void method(){
		System.out.println("this is Demo5.method");      //在static函数中不能使用super关键字
	}
	public static void method(String a){                 //final控制符不能被重写（override），但是可以被重载。
		System.out.println("this is Demo5."+a);
	}
	public static void main(String[] args){
		OverloadingDemo1 d4 = new OverrideDemo1(1,2,3,4);     //向上转型，调用静态方法，调用的是父类的静态方法。
		d4.method();
		d4.method("hello world");
		d4.say2();                         //向上转型，重写了say2()方法，这里调用的是子类say2方法
		OverrideDemo1 d5 = new OverrideDemo1(1,2,3,4);
		d5.visitedSuper();
	}
}

