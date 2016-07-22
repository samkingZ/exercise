package com.hihuaning.genericity;

public class GenericityDemo1 {
	public static void main(String[] args){
		Point1<Integer,Integer> p = new Point1<Integer,Integer>();  //实例化泛型
		p.setX(2);
		p.setY(19);
		int x = p.getX();
		int y = p.getY();
		System.out.println(x+" "+y);

		Point1<Double,String> q = new Point1<Double,String>();
		q.setX(123.1);
		q.setY("hello world");
		double a = q.getX();
		String b = q.getY();
		System.out.println(a+" "+b);
		Point1.printPoint(x, y);           //泛型方法和泛型类没有必然联系，使用泛型方法不需要指明参数类型，编译器
		Point1.printPoint(a, b);          //会根据传递的参数自动查找出具体的类型。泛型方法除了定义不同，调用就向普通方法一样
	}
}


class Point1 <T1,T2>{    //T1,T2为类型参数
	private T1 x;
	private T2 y;
	public T1 getX(){
		return x;
	}

	public T2 getY(){
		return y;
	}

	public void setX(T1 x){
		this.x = x;
	}

	public void setY(T2 y){
		this.y = y;
	}

	public static <T1,T2> void printPoint(T1 x,T2 y){
		T1 m = x;
		T2 n = y;
		System.out.println("this point is :"+m+","+n);
	}
}