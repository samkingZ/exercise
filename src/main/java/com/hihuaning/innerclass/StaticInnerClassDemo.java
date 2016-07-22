package com.hihuaning.innerclass;

/**
 * 静态内部类
 * 静态内部类与外部类相同，只是静态内部类可以为private属性，而外部类不可以。
 * 相当于外部类只提供了一个包的作用，静态内部类的用法和外部类相同
 * 静态内部类与其他类相同，可以继承其他父类，接口等*/
public class StaticInnerClassDemo {
	public static void main(String[] args){
		Car car = new Car("吉利","银色");
		car.show();
		Car.Engine engine = new Car.Engine("火花",200);
		engine.start();
	}
}

class Car{
	String brand;
	String color;
	static String type = "越野车";
	Engine engine;
	ABS abs;

	public void show(){
		System.out.println("这是一辆"+color+brand+type);
		abs.introduce();
		engine.start();
	}

	public Car(String brand, String color){
		this.brand = brand;
		this.color = color;
		engine = new Engine("电喷",500);
		abs = new ABS();
	}

	private static class ABS{
		public void introduce(){
			System.out.println("ABS防抱死系统");
		}
	}

	public static class Engine{
		String type;
		int power;

		public Engine(String type, int power){
			this.type = type;
			this.power = power;
		}
		public void start(){
			System.out.println(type+"引擎启动了");
		}
	}
}