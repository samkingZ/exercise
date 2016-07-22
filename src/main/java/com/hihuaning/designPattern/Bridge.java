package com.hihuaning.designPattern;


interface Soft{
	public void runSoft();
}

class GameSoft implements Soft{
	public void runSoft(){
		System.out.println("打开游戏");
	}
}

class AddressBook implements Soft{
	public void runSoft(){
		System.out.println("打开通讯录");
	}
}

abstract class Phone {
	protected Soft soft;

	public void setSoft(Soft soft){
		this.soft = soft;
	}

	public abstract void run();
}

class PhoneA extends Phone{
	public void run(){
		soft.runSoft();
	}
}

class PhoneB extends Phone{
	public void run(){
		soft.runSoft();
	}
}

public class Bridge{
	public static void main(String[] args){
		Phone phone1 = new PhoneA();
		phone1.setSoft(new AddressBook());
		phone1.run();
		Phone phone2 = new PhoneB();
		phone2.setSoft(new GameSoft());
		phone2.run();
	}
}

