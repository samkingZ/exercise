package com.hihuaning.algorithm.stack;

public class StackOfTwoWay {
	protected int[] data;
	protected int top1;
	protected int top2;
	protected int size;
	public StackOfTwoWay(){
		data = new int[20];
		top1 = 0;
		top2 = 19;
		size = 20;
	}
	
	public StackOfTwoWay(int size){
		data = new int[size];
		top1 = 0;
		top2 = size-1;
		this.size = size;
	}
	
	public boolean isFull(){
		if(top1 == top2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int push(int choice, int x){
		if(isFull()){
			return -1;
		}
		if(choice == 0){
			data[top1++] = x;
		}
		else if(choice == 1){
			data[top2--] = x;
		}
		else{
			return -2;
		}
		return 0;
	}
	
	public boolean isEmpty(int choice){
		return choice==0&&top1==0 || choice==1&&top2==size-1?true:false;
	}
	
	public int pop(int choice){
		if(isEmpty(choice)){
			return -1;
		}
		if(choice == 0){
			return data[top1--];
		}
		else if(choice == 1){
			return data[top2++];
		}
		else{
			return -2;
		}
	}
	
}
