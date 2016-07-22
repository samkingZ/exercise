package com.hihuaning.innerclass;

/**
 * 匿名类就是为了实现某个接口，或者继承某个类，并覆盖或者实现里面的一个或少量方法。
 * 通常，这样的内部类不在别处使用，或者只使用一次，为了程序的结构清晰，用匿名类来定义*/
public class AnonymousInnerClassDemo {
	public static void main(String[] args){
		Car4 c4 = new Car4("长城","蓝色",200);
		c4.show();
	}
}

interface GPRS1{
	public void position();
}

abstract class ABS{
	String type;

	public ABS(String type){
		this.type = type;
	}

	abstract public void stop();
}

class Car4{
	String brand;
	String color;
	GPRS1 tools;
	ABS abs = new ABS("XXX"){
		public void stop(){
			System.out.println("ABS系统使你的车停下来了");
		}
	};

	public Car4(String brand, String color, final int miles){
		this.brand = brand;
		this.color = color;
		tools = new GPRS1(){
			public void position(){
				System.out.println("你的车走了"+miles);
			}
		};
	}

	public void show(){
		System.out.println("这是一辆"+color+brand);
		tools.position();
		abs.stop();
	}

}