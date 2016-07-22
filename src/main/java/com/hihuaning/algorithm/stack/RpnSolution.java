package com.hihuaning.algorithm.stack;

import java.util.Stack;

/*
 * 3.22*/
public class RpnSolution {
	public static double solve(String formula){
		Stack<Double> stack = new Stack<Double>();
		for(int i=0; i<formula.length(); i++){
			char temp = formula.charAt(i);
			if(temp <='9' && temp >='0'){
				stack.push((double)(temp-'0'));
			}
			else{
				stack.push(sum(stack.pop(), stack.pop(), temp));
			}
		}
		return stack.pop();
	}

	public static double sum(double b, double a, char symbol){
		switch(symbol){
			case '+':return a+b;
			case '-':return a-b;
			case '*':return a*b;
			case '/':return a/b;
		}
		return -1;
	}

	public static void main(String[] args){
		System.out.println(solve("32/"));
	}
}
