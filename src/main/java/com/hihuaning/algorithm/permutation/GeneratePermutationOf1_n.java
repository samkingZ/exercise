package com.hihuaning.algorithm.permutation;


import java.util.ArrayList;
import java.util.List;

public class GeneratePermutationOf1_n {
	public static void permutation(List<Integer> a, List<Integer> b, int cur){
		if(cur == a.size()){
			for(int i=0; i<b.size(); i++){
				System.out.print(b.get(i));
			}
			System.out.println();
		}
		else{
			for(int i=0; i<a.size(); i++){
				boolean ok = true;
				for(int j=0; j<cur; j++){
					if(b.get(j) == a.get(i)){
						ok = false;
						break;
					}
				}
				if(ok){
					b.add(a.get(i));
					permutation(a, b, cur+1);
					b.remove(b.indexOf(a.get(i)));
				}
			}
		}
	}

	public static void main(String[] args){
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		for(int i=0; i<4; i++){
			a.add(i);
		}
		permutation(a, b, 0);
	}

}