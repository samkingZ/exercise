package com.hihuaning.genericity;

public class GenericityDemo {     //这样做虽然不需要重载方法但是会有风险
	public static void main(String[] args){
		Point p = new Point();
		p.setX(10);               //这里使用自动装箱和向上转型，int->Integer->Object
		p.setY(20);
		int x = (Integer)p.getX();  //这里是向下转型和自动拆箱，Object->Integer->int
		int y = (Integer)p.getY();
		System.out.println(y+" "+x);  //向下转型会有风险，编译期间可能不会发现，运行时才会抛出ClassCastException异常

		p.setX(24.1);
		p.setY(52.4);
		double a = (Double)p.getX();
		double b = (Double)p.getY();
		System.out.println(a+" "+b);
		Point.printPoint(123,"hello world");
	}
}

class Point{
	private Object x = 0;
	private Object y = 0;

	public Object getX(){
		return x;
	}

	public Object getY(){
		return y;
	}

	public void setX(Object x){
		this.x = x;
	}

	public  void setY(Object y){
		this.y = y;
	}
	public static <T1,T2> void printPoint(T1 a,T2 b){
		System.out.println("this point is :"+a+" "+b);   //在非泛型类中也可定义泛型方法,泛型方法和泛型类没有必然联系
	}
}