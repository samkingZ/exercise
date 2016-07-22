package com.hihuaning.algorithm.backtrack;

import java.util.LinkedList;
/**
 * 用回溯法求集合的幂集
 */

public class PowerSetOFCollection {
	public static void getPowerSet(LinkedList<Integer> a, LinkedList<Integer> b, int level){
		if(level+1 > a.size()){
			for(int i=0; i<b.size(); i++){
				System.out.print(b.get(i));
			}
			System.out.println();
			return ;
		}
		int temp = a.get(level);
		b.add(temp);
		getPowerSet(a, b, level+1);
		b.removeLast();
		getPowerSet(a, b, level+1);
	}

	public static void main(String[] args){
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		for(int i=0; i<5; i++){
			a.add(i);
		}
		getPowerSet(a, b, 0);
	}
}
