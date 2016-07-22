package com.hihuaning.designPattern;


abstract class Fruit{
	public abstract void sayFruit();
}

class Apple extends Fruit{
	public void sayFruit(){
		System.out.println("I am apple");
	}
}

class Orange extends Fruit{
	public void sayFruit(){
		System.out.println("I am orange");
	}
}

interface FruitFactory{
	public Fruit returnFruit();
}

class AppleFactory implements FruitFactory{
	public Fruit returnFruit(){
		return new Apple();
	}
}

class OrangeFactory implements FruitFactory{
	public Fruit returnFruit(){
		return new Orange();
	}
}

public class Factory {
	public static void main(String args[]){
		FruitFactory fa = new AppleFactory();
		fa.returnFruit().sayFruit();
		FruitFactory fa1 = new OrangeFactory();
		fa1.returnFruit().sayFruit();
	}
}
