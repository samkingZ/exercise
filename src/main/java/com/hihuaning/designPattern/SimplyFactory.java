package com.hihuaning.designPattern;


abstract class Student{
	String name;
	String type;
	public abstract void SayType();
}

class PrimaryStudent extends Student{
	public void SayType(){
		System.out.println("I am primary student");
	}
}

class CollageStudent extends Student{
	public void SayType(){
		System.out.println("I am Collage student");
	}
}

class StudentFactory{
	public static Student returnStudent(int type){
		Student student = null;
		switch(type){
		case 1: student = new PrimaryStudent();break;
		case 2: student = new CollageStudent();break;
		//default:student = null;
		}
		
		return student;
	}
}

public class SimplyFactory{
	public static void main(String[] args){
		Student stu1 = StudentFactory.returnStudent(1);   
		Student stu2 = StudentFactory.returnStudent(2);
		stu1.SayType();
		stu2.SayType();
		System.out.println(stu2.toString());
	}
}