package com.hihuaning.innerclass;
/**
 * 局部内部类是函数中定义的类，它不属于外部类的一部分，所以不能有访问控制符，但它同样可以访问外部类的属性和方法，
 * 同时还可以访问该类的外部函数的局部变量，但该变量必须定义为final,即常量*/
public class LocalInnerClassDemo {
	public static void main(String[] args){
		Car3 c3 = new Car3("长安","黑色",1000);
		c3.show();
	}
}

interface GPRS{
	public void position();
}

class Car3{
	String brand;
	String color;
	GPRS tools;
	String he;

	public Car3(final String brand, final String color, final int miles){
		this.brand = brand;
		this.color = color;

		class GPRStools implements GPRS{
			public void position(){
				System.out.println(color+brand+"已经走了"+miles);

			}
		}

		tools = new GPRStools();
	}

	public void show(){
		System.out.println("这是一辆"+color+brand);
		tools.position();
	}
}