package com.hihuaning.genericity;

public class GenericityDemo2 {    //泛型接口
	public static void main(String[] args){
		Info<String> obj = new InfoImp<String>("hello world");
		System.out.println(obj.getVar());
	}
}

interface Info<T>{
	public T getVar();
}

class InfoImp<T> implements Info<T> {
	private T var;
	public InfoImp(T var){
		this.setVar(var);
	}

	public void setVar(T var){
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}
}
