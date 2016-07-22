package com.hihuaning.algorithm.permutation;

import java.util.ArrayList;
import java.util.List;
/*
 * 还可按用“下一个排列”算法解答，它从字典序最小的排列开始，不停调用“下一个排列”的过程，
 * 下一个排列的求法是，从排列后端的第二个数开始，在此数后方找到比此数大一点的数，交换顺序，按大小排列后方的数*/

public class GenerateRepeatablePermutationOf1_n {
	public static void permutation(List<Integer> a, List<Integer> b, int cur){
		if(cur == a.size()){
			for(int i=0; i<b.size(); i++){
				System.out.print(b.get(i));
			}
			System.out.println();
		}
		else{
			for(int i=0; i<a.size(); i++){
				if(i==0 || a.get(i-1) != a.get(i)){  //注意元素不能重复枚举  ,因为a是有顺序的，所以这里的判断能消除重复
					int count1 = 0;
					int count2 = 0;
					for(int j=0; j<a.size(); j++){
						if(a.get(j) == a.get(i)){
							count1++;
						}
					}
					for(int j=0; j<cur; j++){
						if(b.get(j) == a.get(i)){
							count2++;
						}
					}

					if(count1 > count2){
						b.add(a.get(i));
						permutation(a, b, cur+1);
						b.remove(b.indexOf(a.get(i)));
					}
				}
			}
		}
	}

	public static void main(String[] args){
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		for(int i=0; i<2; i++){
			a.add(0);
		}
		for(int i=1; i<2; i++){
			a.add(i);
		}
		a.add(0);
		permutation(a, b, 0);
	}
}
