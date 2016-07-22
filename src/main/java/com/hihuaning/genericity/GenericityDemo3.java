package com.hihuaning.genericity;
/*
 * 通过使用通配符声明的名称所引用的对象，没办法再对它加入新的信息，只能取得它当中的信息或是移除当中的信息*/
public class GenericityDemo3 {
	public static void main(String[] args){
		Point2 p = new Point2();  //没有指明具体的数据类型，类型擦除
		p.setX(10);
		p.setY(20.10);
		int x = (Integer)p.getX();  //向下转型，和genericityDemo无差别
		double y = (Double)p.getY();

		Integer[] array = {1,2,3,4,5};
		int a = Point2.getMax(array);
		System.out.println(a);

		Point2 <TypeErase,TypeErase> p2 = new Point2();
		TypeErase t1 = new TypeErase();
		TypeErase t2 = new TypeErase();
		p2.setX(t1);
		p2.setY(t2);
		printPoint(p2);

		Point2 <Integer,Integer> p3 = new Point2();
		p3.setX(3);
		p3.setY(5);
		//printPoint(p3);
	}

	/*public static void printPoint(Point2 p){       //没有指明具体的数据类型，会擦除泛型类型，并向上转型为Object.
		System.out.println(p.getX()+" "+p.getY());
		System.out.println(p.getX().getClass()+" "+p.getClass());
	}*/

	/*	public static void printPoint(Point2<?,?> p){     //使用通配符？可避免类型擦除？然而并没有什么卵用
            TypeErase t3 = (TypeErase)p.getX();
            System.out.println(t3.toString());
        }
        */
	public static void printPoint(Point2<? extends TypeErase,? extends TypeErase> p){
		TypeErase t3 = p.getX();
	}
}


class Point2<T1,T2>{
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

	public static <T extends Number> T getMax(T array[]){              //使用关键字extends限制泛型的可用类型
		T max = array[0];                                              //后面可以是类也可以是接口，如果有多个接口，以&分隔
		for(T element:array){
			max = element.doubleValue()>max.doubleValue()?element:max;
		}
		return max;
	}
}

class TypeErase{
	private int a;
	private int b;
	public TypeErase(){
		a = 1;
		b = 2;
	}
}


