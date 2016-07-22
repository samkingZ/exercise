package com.hihuaning.innerclass;
/**
 * 在单独定义内部类的变量时，一定要先定义外部类，通过外部类对象在去创建内部类对象。*/
public class InstanceInnerClassDemo {
	public static void main(String[] args){
		Car2 c2 = new Car2("奇瑞","红色");
		c2.show();
		Car2.Engine engine = c2.new Engine("火花",200);    //和静态内部类不同
		engine.start();
	}
}

class Car2{
	String brand;
	String color;
	static String type = "越野车";
	Engine engine;
	ABS abs;

	public Car2(String brand, String color){
		this.brand = brand;
		this.color = color;
		engine = new Engine("电喷",500);
		abs = new ABS();
	}

	public void show(){
		System.out.println("这是一辆"+color+brand+type);
		abs.introduce();
		engine.start();
	}

	public class Engine{
		String type;
		int power;

		public Engine(String type, int power){
			this.type = type;
			this.power = power;
		}

		public void start(){
			System.out.println(type+"系统启动");
		}
	}

	private class ABS{
		public void introduce(){
			System.out.println("防抱死系统");
		}
	}

}