package com.hihuaning.designPattern;


class target{
	public void request(){
		System.out.println("普通请求");
	}
}

class adaptee{
	public void specificRequest(){
		System.out.println("特殊请求");
	}
}

public class adapter extends target{
	private adaptee ad = new adaptee();
	public void request(){
		ad.specificRequest();
	}
	public static void main(String[] args){
		target ta = new target();
		target ta1 = new adapter();
		ta.request();
		ta1.request();
	}
}

