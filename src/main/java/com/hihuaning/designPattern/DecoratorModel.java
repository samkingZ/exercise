package com.hihuaning.designPattern;


public class DecoratorModel {
	public static void main(String[] args){
		Person zengbo = new Person();
		Person zengbo1 = new Decorate1(zengbo);
		Person zengbo2 = new Decorate2(zengbo1);
		Person zengbo3 = new Decorate1(zengbo2);
		zengbo3.show();
	}
}

class Person{
	private String name;
	private String cloth;
	public Person(){
		this.name = "曾波";
		this.cloth = "牛仔裤";
	}
	public void show(){
		System.out.println("穿的"+cloth);
	}
}

abstract class Decorate extends Person{
	protected Person decorator;
	public Decorate(Person decorator){
		this.decorator = decorator;
	}

}

class Decorate1 extends Decorate{
	public Decorate1(Person decorator) {
		super(decorator);
	}

	public void show(){
		decorator.show();
		System.out.println("短袖");
	}
}

class Decorate2 extends Decorate{
	public Decorate2(Person decorator) {
		super(decorator);
	}

	public void show(){
		decorator.show();
		System.out.println("短裤");
	}
}




