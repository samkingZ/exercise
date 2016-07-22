package com.hihuaning.algorithm.stack;

import java.util.LinkedList;
import java.util.Stack;

/*
 * 3.21
 * 中缀表达式转波兰式时，从式子右边开始遍历，碰到数字就输出，碰到运算符，if栈为空，入栈；else 栈不为空，
 * 判断当前运算符优先级是否大于栈顶运算符的，若是则入栈，如不是则一直出栈，知道当前运算符优先级大于栈顶。
 *
 *逆波兰式转中缀表达式时，可参照逆波兰式求值的算法，
 *遇到一个运算符时，将其前两个数字与该运算符转成字符串，再压入栈中这样最后栈中的元素即为中缀表达式*/
public class ReversePolishExpression {
	public static String Reverse_Polish(String str){
		Stack<Character> stack = new Stack<Character>();
		StringBuilder formula = new StringBuilder();
		for(int i=0; i<str.length(); i++){
			char temp = str.charAt(i);
			if(temp<='9' && temp >='0'){
				formula.append(temp);
			}
			else{
				if(stack.isEmpty() || compare(stack.peek(), temp)){
					stack.push(temp);
				}
				else{
					while(!stack.isEmpty() && !compare(stack.peek(), temp)){
						formula.append(stack.pop());
					}
					stack.push(temp);
				}
			}
		}
		while(!stack.isEmpty()){
			formula.append(stack.pop());
		}
		return formula.toString();
	}

	public static int change(char a){
		switch(a){
			case '+' :return 0;
			case '-' :return 1;
			case '*' :return 2;
			case '/' :return 3;
		}
		return -1;
	}

	public static boolean compare(char a, char b){
		boolean[][] compare = {{false, false, true, true},
				{false, false, true, true},
				{false, false, false, false,},
				{false, false, false, false,}};
		return compare[change(a)][change(b)];
	}

	public static void main(String[] args){
		System.out.println(Reverse_Polish("2+4*3-5"));
	}
}

